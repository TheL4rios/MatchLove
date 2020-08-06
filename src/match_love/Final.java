package match_love;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import static match_love.Metodos.getNameWithNormalFormat;
import org.jpl7.Query;
import org.jpl7.Term;
import rojerusan.RSAnimation;

/**
 *
 * @author Larios & Yisus64
 */
public class Final extends javax.swing.JFrame {

    private Timer timerPopup; // Timer para inciar el Popup de Match
    private Popup popup; //Popup para indicarle al usuario que no tuvo match
    private String nameFormatProlog; // Guardar el nombre formateado de la persona que hizo la encuesta
    private ArrayList<Person> couples, friends, companions; // Guaradar las posibles parejas, amigos y compañeros

    /**
     * Creates new form Final
     */
    public Final() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    RSAnimation.setBajar(-100, 150, 3, 5, this);
    }

    public void init(String nameFormatProlog) {
        // Obtener el nombre formateado de la ventana Encuesta
        this.nameFormatProlog = nameFormatProlog;

        // Inicializar ArrayList
        couples = new ArrayList();
        friends = new ArrayList();
        companions = new ArrayList();

        // Colocar en el centro de la pantalla
        setLocationRelativeTo(null);

        // Obtener los nombres de los posibles match y sus puntos
        getCoupleNamesPoints();

        // Si el array de parejas está vacío, decirle que no tuvo match con un popup
        if (couples.isEmpty()) {
            timerPopup = new Timer(250, (ActionEvent e) -> {
                showPopup(Popup.POPUP_TYPE.NO_MATCH);
                timerPopup.stop();
            });
        } else {
            timerPopup = new Timer(250, (ActionEvent e) -> {
                showPopup(Popup.POPUP_TYPE.MATCH);
                timerPopup.stop();
            });
        }
        timerPopup.start();

        // Llenar los textArea con los nombres
        fillTextAreas();

    }

    // Método para mostrar un tipo de popup
    private void showPopup(Popup.POPUP_TYPE option) {
        if (popup == null) {
            popup = new Popup(option);
        }
        popup.setVisible(true);
        popup.move();
    }

    // Llenar los textAreas con los nombres de las parejas, amigos o compaleros
    private void fillTextAreas() {
        String text = "";
        for (int i = 0; i < couples.size(); i++) {
            text += couples.get(i).getFormatNamePoint();
            if (i != couples.size() - 1) {
                text += "\n";
            }
        }
        if (text.isEmpty()) {
            txtAreaCouples.setText("Ninguno/a");
        } else {
            txtAreaCouples.setText(text);
        }
        text = "";
        for (int i = 0; i < friends.size(); i++) {
            text += friends.get(i).getFormatNamePoint();
            if (i != friends.size() - 1) {
                text += "\n";
            }
        }
        if (text.isEmpty()) {
            txtAreaFriends.setText("Ninguno/a");
        } else {
            txtAreaFriends.setText(text);
        }
        text = "";
        for (int i = 0; i < companions.size(); i++) {
            text += companions.get(i).getFormatNamePoint();
            if (i != companions.size() - 1) {
                text += "\n";
            }
        }
        if (text.isEmpty()) {
            txtAreaCompanions.setText("Ninguno/a");
        } else {
            txtAreaCompanions.setText(text);
        }
    }

    // Método para obtener nombre de los posibles match
    public void getCoupleNamesPoints() {
        String name = nameFormatProlog;
        Query consult = new Query("consult('knowledge_database.pl')");

        // Obtener los nombres de los posbiles match
        ArrayList<String> possibleCoupleNames = new ArrayList();
        if (consult.hasSolution()) {
            consult = new Query("validarPareja(" + name + ", Y)"); // Si el gusto del sexo que le atrae a ambos es compatible
            if (consult.hasSolution()) {
                Map<String, Term>[] result = consult.allSolutions();
                for (Map<String, Term> res : result) {
                    String possibleCouple = res.get("Y").toString();
                    if (possibleCouple.contains("'")) {
                        possibleCouple = possibleCouple.substring(1, possibleCouple.length() - 1);
                    }
                    // Que no se considere a sí mismo
                    if (!possibleCouple.equals(name)) {
                        possibleCoupleNames.add(possibleCouple);
                    }
                }
            }
        }
        // System.out.println("Existen "+possibleCoupleNames.size()+" personas a las que les puedes gustar...");
        lblMensaje.setText(lblMensaje.getText().replace("X", String.valueOf(possibleCoupleNames.size())));
        // Obtener los puntos de los posbiles matches
        double[] points = new double[possibleCoupleNames.size()];
        for (int i = 0; i < possibleCoupleNames.size(); i++) {
            String possibleCoupleName = possibleCoupleNames.get(i);
            // System.out.println("La persona "+(i+1)+" se llama "+possibleCoupleName);
            for (int j = 1; j <= 23; j++) {
                consult = new Query("p" + j + "(" + name + ", " + possibleCoupleName + ", Z)"); // Devueleve en Z la cantidad de puntos
                if (consult.hasSolution()) {
                    double point = Double.parseDouble(consult.oneSolution().get("Z").toString());
                    points[i] += point;
                    // System.out.println("Para la pregunta "+j+" obtuvieron "+point+" puntos");
                }
            }
            // System.out.println("Obtuvieron en total "+points[i]+" puntos...");
            possibleCoupleName = getNameWithNormalFormat(possibleCoupleName);
            // System.out.println("Se cambia el formato del nombre a normal: "+ possibleCoupleName);
            if (points[i] <= 20) { // Si puntos >= 0 &&  <= 20 entonces solo puede ser compañero
                companions.add(new Person(possibleCoupleName, points[i]));
            } else if (points[i] <= 50) { // Si puntos > 20 && puntos <= 50 entonces solo puede ser amigo
                friends.add(new Person(possibleCoupleName, points[i]));
            } else { // Si puntos >50 && puntos <= 100, puede ser una potencial pareja
                couples.add(new Person(possibleCoupleName, points[i]));
            }
            // System.out.println("\n---Continuamos con la siguiente persona---\n");
        }

        sortArrays();
    }

    // Ordenamos cada uno de los ArrayList de parejas, amigos y compañeros dependiendo del % de compatibilidad
    private void sortArrays() {
        Collections.sort(companions, (Person p1, Person p2)
                -> new Double(p2.points).compareTo(p1.points)
        );

        Collections.sort(friends, (Person p1, Person p2)
                -> new Double(p2.points).compareTo(p1.points)
        );

        Collections.sort(couples, (Person p1, Person p2)
                -> new Double(p2.points).compareTo(p1.points)
        );
    }

    // Cerrar toda la ventana y lo relacionado con ella
    private void close() {
        dispose();
        if (popup != null) {
            popup.dispose();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblMensaje = new javax.swing.JLabel();
        lblCouples = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaCouples = new javax.swing.JTextArea();
        lblFriends = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAreaFriends = new javax.swing.JTextArea();
        lblCompanions = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaCompanions = new javax.swing.JTextArea();
        btnStart = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("RESULTADOS");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/images/icons/heart.png")).getImage());
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMensaje.setFont(new java.awt.Font("Franklin Gothic Demi", 1, 18)); // NOI18N
        lblMensaje.setForeground(new java.awt.Color(255, 255, 255));
        lblMensaje.setText("De nuestra lista, X podrían emparejar contigo...");
        jPanel1.add(lblMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        lblCouples.setFont(new java.awt.Font("Franklin Gothic Book", 1, 15)); // NOI18N
        lblCouples.setText("Pareja [>50%]");
        jPanel1.add(lblCouples, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, -1, -1));

        txtAreaCouples.setEditable(false);
        txtAreaCouples.setColumns(20);
        txtAreaCouples.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        txtAreaCouples.setRows(5);
        jScrollPane2.setViewportView(txtAreaCouples);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 382, 70));

        lblFriends.setFont(new java.awt.Font("Franklin Gothic Book", 1, 15)); // NOI18N
        lblFriends.setText("Amigos[>20 y <=50%]");
        jPanel1.add(lblFriends, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, -1));

        txtAreaFriends.setEditable(false);
        txtAreaFriends.setColumns(20);
        txtAreaFriends.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        txtAreaFriends.setRows(5);
        jScrollPane3.setViewportView(txtAreaFriends);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 382, 70));

        lblCompanions.setFont(new java.awt.Font("Franklin Gothic Book", 1, 15)); // NOI18N
        lblCompanions.setText("Compañeros[<=20%]");
        jPanel1.add(lblCompanions, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, -1, -1));

        txtAreaCompanions.setEditable(false);
        txtAreaCompanions.setColumns(20);
        txtAreaCompanions.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        txtAreaCompanions.setRows(5);
        jScrollPane1.setViewportView(txtAreaCompanions);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, 382, 70));

        btnStart.setBackground(new java.awt.Color(255, 153, 153));
        btnStart.setFont(new java.awt.Font("Franklin Gothic Book", 1, 14)); // NOI18N
        btnStart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/vintage/salida.png"))); // NOI18N
        btnStart.setText("Inicio");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });
        jPanel1.add(btnStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 400, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/vintage/amigos.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/vintage/pareja.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/vintage/amistad.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/vintage/fondo canasta.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 440));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Ir a la ventana de Inicio
    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        if (questionForClose()) {
            new Inicial().setVisible(true);
            close();
        }
    }//GEN-LAST:event_btnStartActionPerformed

    // Evento que se activa al cerrar la ventana
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (questionForClose()) {
            new Inicial().setVisible(true);
            close();
        }
    }//GEN-LAST:event_formWindowClosing

    // Método que pregunta al usuario si desea cerrar la ventana, en caso de que si retorna true
    private boolean questionForClose() {
        return JOptionPane.showConfirmDialog(null, "¿Deseas cerrar la ventana de información? Tus respuestas ya fueron guardadas",
                " Encuesta en curso ", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE) == 0;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Final.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Final.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Final.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Final.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Final().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblCompanions;
    private javax.swing.JLabel lblCouples;
    private javax.swing.JLabel lblFriends;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JTextArea txtAreaCompanions;
    private javax.swing.JTextArea txtAreaCouples;
    private javax.swing.JTextArea txtAreaFriends;
    // End of variables declaration//GEN-END:variables
}
