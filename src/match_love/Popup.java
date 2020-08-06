package match_love;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import static match_love.Metodos.scaleImage;
import Animacion.Animacion;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

/**
 *
 * @author yisus64
 */
public class Popup extends javax.swing.JFrame {

    private Image iconLabel, iconButton;
    private final POPUP_TYPE option;
    private Timer timerPopup;

    /**
     * Creates new form Popup
     *
     * @param option
     */
    Popup(POPUP_TYPE option) {
        // Poner fondo dependiendo del tipo de Popup
        this.option = option;
        Image background;
        if (null == option) {
            background = getImageResource("/images/vintage/acuarelaRoja.jpg");
        } else {
            switch (option) {
                case WELCOME:
                    background = getImageResource("/images/vintage/acuarelaRoja.jpg");
                    break;
                case MATCH:
                case NO_MATCH:
                    background = getImageResource("/images/vintage/acuarelaRoja.jpg");
                    break;
                default:
                    background = getImageResource("/images/vintage/acuarelaRoja.jpg");
                    break;
            }
        }
        FondoPanel fondoPanel = new FondoPanel(background);
        setContentPane(fondoPanel);
        initComponents();
        init();
    }

    private void init() {
        // Llenar elementos dependiendo del tipo de Popup
        switch (option) {
            case WELCOME:
                iconLabel = getImageResource("/images/icons/hola.png", 57, 57);
                lblMessage1.setText("¡Gracias por usar nuestra app!");
                lblMessage2.setText("   Suerte en tu búsqueda  ");
                setTitle("♥ Match Love App ♥");
                break;
            case REPEAT_DATA:
                iconLabel = getImageResource("/images/icons/error.png", 57, 57);
                lblMessage1.setText("¡Ese nombre ya está registrado!");
                lblMessage2.setText("        Porfavor use otro     ");
                setTitle(" Acción no permitida ");
                break;
            case ERROR_NAME:
                iconLabel = getImageResource("/images/icons/error.png", 57, 57);
                lblMessage1.setText("El nombre solo debe de contener");
                lblMessage2.setText("        letras y espacios      ");
                setTitle(" Acción no permitida ");
                break;
            case MISSING_FORM:
                iconLabel = getImageResource("/images/icons/error.png", 57, 57);
                lblMessage1.setText("Favor de completar el formulario");
                lblMessage2.setText("       para poder continuar     ");
                setTitle(" Acción no permitida ");
                break;
            case MISSING_QUESTION:
                iconLabel = getImageResource("/images/icons/error.png", 57, 57);
                lblMessage1.setText("Favor de elegir una opción para");
                lblMessage2.setText("      para poder continuar     ");
                setTitle("☣ Acción no permitida ☣");
                break;
            case MATCH:
                iconLabel = getImageResource("/images/icons/heart.png", 70, 57);
                lblMessage1.setText("¡Felicidades, si eres compatible");
                lblMessage2.setText("  con alguien de nuestra lista! ");
                setTitle(" ♥ Match conseguido  ♥");
                break;
            case NO_MATCH:
                iconLabel = getImageResource("/images/icons/triste.png", 70, 57);
                lblMessage1.setText("¡No te preocupes!, aun así puedes");
                lblMessage2.setText("        hacer algunos amigos     ");
                setTitle(" ♡ Match no conseguido ♡ ");
                break;
            case THEY_MATCH:
                iconLabel = getImageResource("/images/icons/heart.png", 70, 57);
                lblMessage1.setText(" Ambos son compatibles <3 invita");
                lblMessage2.setText(" a esa persona especial a salir ");
                setTitle(" ♥ Match conseguido  ♥");
                break;
            case THEY_NO_MATCH:
                iconLabel = getImageResource("/images/icons/triste.png", 70, 57);
                lblMessage1.setText("Ambos no son compatibles, aún así");
                lblMessage2.setText("  pueden ser amigos o compañeros ");
                setTitle(" ♡ Match no conseguido ♡ ");
                break;
        }
        iconButton = getImageResource("/images/icons/ok.png", 50, 21);
        lblIcon.setIcon(new ImageIcon(iconLabel));
        btnPopup.setIcon(new ImageIcon(iconButton));
    }

    // Mover popup de arriba abajo
    public void move() {
        // Poner en la parte superior central
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (screenSize.width - getWidth()) / 2,
                centerY = (screenSize.height - getHeight()) / 2;
        setLocation(centerX, 0);

        // Mover a hacia abajo simulando efecto Popup
        timerPopup = new Timer(150, (ActionEvent e) -> {
            Animacion.bajar(0, centerY, 1, 4, this);
            timerPopup.stop();
            toFront();
        });
        timerPopup.start();
    }

    // Obtener la imagen de la carpeta o de alguna subcarpeta de Source Packages
    private Image getImageResource(String resource) {
        File file = getFileResource(resource);
        return new ImageIcon(String.valueOf(file)).getImage();
    }

    /* Obtener cada uno de las imágenes de la carpeta o de alguna subcarpeta de Source Packages,
       especificando un tamaño específico de escalamiento
     */
    private Image getImageResource(String resource, int width, int height) {
        Image image = getImageResource(resource);
        return scaleImage(image, width, height);
    }

    // Obtener un archivo de la carpeta o de alguna subcarpeta de Source Packages 
    private File getFileResource(String resource) {
        return new File(getClass().getResource(resource).getFile());
    }

    enum POPUP_TYPE {
        WELCOME, REPEAT_DATA, MISSING_FORM, MISSING_QUESTION, ERROR_NAME, MATCH, NO_MATCH,
        THEY_MATCH, THEY_NO_MATCH
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblIcon = new javax.swing.JLabel();
        lblMessage1 = new javax.swing.JLabel();
        lblMessage2 = new javax.swing.JLabel();
        btnPopup = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/images/icons/heart.png")).getImage());

        lblMessage1.setFont(new java.awt.Font("Eras Medium ITC", 1, 12)); // NOI18N
        lblMessage1.setText("lblMessage1");
        lblMessage1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lblMessage2.setFont(new java.awt.Font("Eras Medium ITC", 1, 12)); // NOI18N
        lblMessage2.setText("lblMessage2");
        lblMessage2.setToolTipText("");
        lblMessage2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        btnPopup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPopupActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMessage1, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                            .addComponent(lblMessage2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPopup, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)))
                .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(lblMessage1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMessage2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPopup, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPopupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPopupActionPerformed
        dispose();
    }//GEN-LAST:event_btnPopupActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Popup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        //java.awt.EventQueue.invokeLater(() -> {
//            try {
//                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
//                System.out.println("Error al especificar el LookAndFeel: " + ex.getMessage());
//            }
        //  new Popup().setVisible(true);
        //});
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPopup;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblMessage1;
    private javax.swing.JLabel lblMessage2;
    // End of variables declaration//GEN-END:variables
}
