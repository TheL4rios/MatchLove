package match_love;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import static match_love.Metodos.getNameWithPrologFormat;
import org.jpl7.Query;
import rojerusan.RSAnimation;

/**
 *
 * @author Kevin
 */
public class Inicial extends javax.swing.JFrame {

    private Popup popupInit; //Popup para dar la bienvenida al usuario
    private Popup popupMissingForm; //Popup para indicar que falta completar elementos del formulario
    private Popup popupErrorName; //Popup para indicar que el campo de nombre está mal llenado
    private Popup popupRepeatData; //Popup para indicar si un nombre ya está registrado
    private Timer timerButtonInit; // Timer para activar el botón de empezar
    private int typeError; //Error de formulario normal o error de llenado de nombre

    public Inicial() {
        initComponents();
        init();
       RSAnimation.setBajar(-100, 150, 3, 4, this);
       
    }

    private void init() {
        //Colocar en el centro de la pantalla
        setLocationRelativeTo(null);

        //Mostrar popup de bienvenida
        showPopupInit();

        //Activar el botón de empezar después de 1.3 segundos
        timerButtonInit = new Timer(1300, (ActionEvent e) -> {
            btnStart.setEnabled(true);
            btnConsult.setEnabled(true);
            timerButtonInit.stop();
        });
        timerButtonInit.start();

        // Agregar los jRadioButton a un determinado ButtonGroup
        buttonGroupSexo.add(jRadioButtonMan);
        buttonGroupSexo.add(jRadioButtonWoman);
        buttonGroupInteres.add(jRadioButtonMen);
        buttonGroupInteres.add(jRadioButtonWomen);
        buttonGroupInteres.add(jRadioButtonBoth);

    }

    // Mostrar un tipo de Popup
    private void showPopupInit() {
        if (popupInit == null) {
            popupInit = new Popup(Popup.POPUP_TYPE.WELCOME);
        }
        if (popupRepeatData != null) {
            popupRepeatData.dispose();
        }
        if (popupMissingForm != null) {
            popupMissingForm.dispose();
        }
        if (popupErrorName != null) {
            popupErrorName.dispose();
        }
        popupInit.setVisible(true);
        popupInit.move();
    }

    private void showPopupRepeatData() {
        if (popupRepeatData == null) {
            popupRepeatData = new Popup(Popup.POPUP_TYPE.REPEAT_DATA);
        }
        if (popupInit != null) {
            popupInit.dispose();
        }
        if (popupMissingForm != null) {
            popupMissingForm.dispose();
        }
        if (popupErrorName != null) {
            popupErrorName.dispose();
        }
        popupRepeatData.setVisible(true);
        popupRepeatData.move();
    }

    // Mostrar un tipo de Popup
    private void showPopupMissingForm() {
        if (popupMissingForm == null) {
            popupMissingForm = new Popup(Popup.POPUP_TYPE.MISSING_FORM);
        }
        if (popupInit != null) {
            popupInit.dispose();
        }
        if (popupRepeatData != null) {
            popupRepeatData.dispose();
        }
        if (popupErrorName != null) {
            popupErrorName.dispose();
        }
        popupMissingForm.setVisible(true);
        popupMissingForm.move();
    }

    private void showPopupErrorName() {
        if (popupErrorName == null) {
            popupErrorName = new Popup(Popup.POPUP_TYPE.ERROR_NAME);
        }
        if (popupInit != null) {
            popupInit.dispose();
        }
        if (popupRepeatData != null) {
            popupRepeatData.dispose();
        }
        if (popupMissingForm != null) {
            popupMissingForm.dispose();
        }
        popupErrorName.setVisible(true);
        popupErrorName.move();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupInteres = new javax.swing.ButtonGroup();
        buttonGroupSexo = new javax.swing.ButtonGroup();
        lblClose = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblCarrera = new javax.swing.JLabel();
        cmbCarrera = new javax.swing.JComboBox<>();
        jRadioButtonMan = new javax.swing.JRadioButton();
        lblSexo = new javax.swing.JLabel();
        jRadioButtonWoman = new javax.swing.JRadioButton();
        lblMeInteresa = new javax.swing.JLabel();
        jRadioButtonMen = new javax.swing.JRadioButton();
        jRadioButtonWomen = new javax.swing.JRadioButton();
        jRadioButtonBoth = new javax.swing.JRadioButton();
        btnStart = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblInstruction1 = new javax.swing.JLabel();
        lblInstruction2 = new javax.swing.JLabel();
        btnConsult = new javax.swing.JButton();
        lblFormaulario1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("BIENVENIDO");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/images/icons/heart.png")).getImage());
        setMinimumSize(new java.awt.Dimension(412, 502));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/close.png"))); // NOI18N
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCloseMouseClicked(evt);
            }
        });
        getContentPane().add(lblClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, -1, -1));

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 16)); // NOI18N
        jLabel1.setText("Introduce tu nombre");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, -1, -1));

        txtNombre.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
        });
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 70, 233, -1));

        lblCarrera.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 16)); // NOI18N
        lblCarrera.setText("Carrera");
        getContentPane().add(lblCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, -1, -1));

        cmbCarrera.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        cmbCarrera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elije tu carrera", "ISC", "AQUITECTURA", "BIOQUIMICA", "CIVIL", "ELECTRICA", "GESTION", "INDUSTRIAL", "MECATRONICA", "QUIMICA", "TICS", "ADMINISTRACION" }));
        getContentPane().add(cmbCarrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 110, -1, -1));

        jRadioButtonMan.setBackground(new java.awt.Color(255, 153, 153));
        jRadioButtonMan.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        jRadioButtonMan.setText("Masculino");
        jRadioButtonMan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonManActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButtonMan, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, 90, -1));

        lblSexo.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 16)); // NOI18N
        lblSexo.setText("Sexo");
        getContentPane().add(lblSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, -1, -1));

        jRadioButtonWoman.setBackground(new java.awt.Color(255, 153, 153));
        jRadioButtonWoman.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        jRadioButtonWoman.setText("Femenino");
        getContentPane().add(jRadioButtonWoman, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 210, 90, -1));

        lblMeInteresa.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 16)); // NOI18N
        lblMeInteresa.setText("Me interesa");
        getContentPane().add(lblMeInteresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 160, -1, -1));

        jRadioButtonMen.setBackground(new java.awt.Color(255, 153, 153));
        jRadioButtonMen.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        jRadioButtonMen.setText("Hombres");
        getContentPane().add(jRadioButtonMen, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 190, 80, -1));

        jRadioButtonWomen.setBackground(new java.awt.Color(255, 153, 153));
        jRadioButtonWomen.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        jRadioButtonWomen.setText("Mujeres");
        getContentPane().add(jRadioButtonWomen, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 210, 80, -1));

        jRadioButtonBoth.setBackground(new java.awt.Color(255, 153, 153));
        jRadioButtonBoth.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        jRadioButtonBoth.setText("Ambos");
        getContentPane().add(jRadioButtonBoth, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 230, 80, -1));

        btnStart.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 16)); // NOI18N
        btnStart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/vintage/encuesta.png"))); // NOI18N
        btnStart.setText("Contestar encuesta");
        btnStart.setEnabled(false);
        btnStart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnStartMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnStartMouseExited(evt);
            }
        });
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });
        getContentPane().add(btnStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 290, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));

        lblInstruction1.setFont(new java.awt.Font("Franklin Gothic Book", 1, 12)); // NOI18N
        lblInstruction1.setForeground(new java.awt.Color(255, 255, 255));
        lblInstruction1.setText("Si ya te habías registrado antes o deseas ver si dos personas");

        lblInstruction2.setFont(new java.awt.Font("Franklin Gothic Book", 1, 12)); // NOI18N
        lblInstruction2.setForeground(new java.awt.Color(255, 255, 255));
        lblInstruction2.setText("que conoces son compatibles, da clic en el siguiente botón:");

        btnConsult.setBackground(new java.awt.Color(0, 0, 0));
        btnConsult.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 12)); // NOI18N
        btnConsult.setText("Sí, deseo consultar");
        btnConsult.setEnabled(false);
        btnConsult.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnConsultMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnConsultMouseExited(evt);
            }
        });
        btnConsult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblInstruction1)
                            .addComponent(lblInstruction2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(btnConsult)))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblInstruction1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInstruction2)
                .addGap(18, 18, 18)
                .addComponent(btnConsult)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 360, 390, 100));

        lblFormaulario1.setFont(new java.awt.Font("Lucida Calligraphy", 1, 24)); // NOI18N
        lblFormaulario1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/vintage/corazon.png"))); // NOI18N
        lblFormaulario1.setText("Match Love");
        getContentPane().add(lblFormaulario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, -1, 20));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/vintage/latido-del-corazon.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 150, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/vintage/identidad.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 60, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/vintage/estudiante.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/vintage/fluido-de-genero.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 150, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 153, 153));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/vintage/hearts-3063664_960_720.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        if (validateQuestions()) {
            String nombre = txtNombre.getText().trim().replaceAll(" +", " ");
            SEXO sexo;
            INTERES interes;
            if (jRadioButtonMan.isSelected()) {
                sexo = SEXO.hombre;
            } else {
                sexo = SEXO.mujer;
            }
            if (jRadioButtonMen.isSelected()) {
                interes = INTERES.hombres;
            } else if (jRadioButtonWomen.isSelected()) {
                interes = INTERES.mujeres;
            } else {
                interes = INTERES.ambos;
            }
            CARRERA carrera;
            switch (cmbCarrera.getSelectedIndex()) {
                case 1:
                    carrera = CARRERA.ISC;
                    break;
                case 2:
                    carrera = CARRERA.AQUITECTURA;
                    break;
                case 3:
                    carrera = CARRERA.BIOQUIMICA;
                    break;
                case 4:
                    carrera = CARRERA.CIVIL;
                    break;
                case 5:
                    carrera = CARRERA.ELECTRICA;
                    break;
                case 6:
                    carrera = CARRERA.GESTION;
                    break;
                case 7:
                    carrera = CARRERA.INDUSTRIAL;
                    break;
                case 8:
                    carrera = CARRERA.MECATRONICA;
                    break;
                case 9:
                    carrera = CARRERA.QUIMICA;
                    break;
                case 10:
                    carrera = CARRERA.TICS;
                    break;
                default:
                    carrera = CARRERA.ADMINISTRACION;
                    break;
            }
            Encuesta encuesta = new Encuesta();
            encuesta.setDataPerson(nombre, sexo, interes, carrera);
            encuesta.init();
            encuesta.setVisible(true);
            close();
        } else {
            switch (typeError) {
                case 0:
                    showPopupMissingForm();
                    break;
                case 1:
                    showPopupErrorName();
                    break;
                default:
                    showPopupRepeatData();
                    break;
            }
        }


    }//GEN-LAST:event_btnStartActionPerformed

    // Cerrar toda la ventana y lo relacionado con ella
    private void close() {
        dispose();
        if (popupInit != null) {
            popupInit.dispose();
        }
        if (popupRepeatData != null) {
            popupRepeatData.dispose();
        }
        if (popupMissingForm != null) {
            popupMissingForm.dispose();
        }
        if (popupErrorName != null) {
            popupErrorName.dispose();
        }
    }

    // Evento de teclado para poner la letra de color negro en el campo del Nombre
    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        txtNombre.setForeground(Color.black);
    }//GEN-LAST:event_txtNombreKeyReleased

    // Evento que se activa al cerrar la ventana
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (JOptionPane.showConfirmDialog(null, "¿Deseas cerrar la aplicación?",
                "｡ﾟ(｡ﾉωヽ｡)ﾟ｡ Cerrar aplicación ｡ﾟ(｡ﾉωヽ｡)ﾟ｡", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE) == 0) {
            dispose();
        }
    }//GEN-LAST:event_formWindowClosing

    private void btnConsultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultActionPerformed
        new Consulta().setVisible(true);
        close();
    }//GEN-LAST:event_btnConsultActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void jRadioButtonManActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonManActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonManActionPerformed

    private void btnStartMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStartMouseEntered
        btnStart.setForeground(Color.red);        // TODO add your handling code here:
    }//GEN-LAST:event_btnStartMouseEntered

    private void btnStartMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStartMouseExited
        btnStart.setForeground(Color.BLACK);        // TODO add your handling code here:
    }//GEN-LAST:event_btnStartMouseExited

    private void btnConsultMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultMouseExited
       btnConsult.setForeground(Color.BLACK);  // TODO add your handling code here:
    }//GEN-LAST:event_btnConsultMouseExited

    private void btnConsultMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultMouseEntered
        btnConsult.setForeground(Color.red);         // TODO add your handling code here:
    }//GEN-LAST:event_btnConsultMouseEntered

    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
        if (JOptionPane.showConfirmDialog(null, "¿Deseas cerrar la aplicación?",
                "｡ﾟ(｡ﾉωヽ｡)ﾟ｡ Cerrar aplicación ｡ﾟ(｡ﾉωヽ｡)ﾟ｡", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE) == 0) {
            dispose();
        }
    }//GEN-LAST:event_lblCloseMouseClicked

    // Validar que se haya llenado correctamente el formulario
    private boolean validateQuestions() {
        typeError = 0;
        String nombre = txtNombre.getText().trim().replaceAll(" +", " ");
        if (nombre.isEmpty()) {
            txtNombre.setRequestFocusEnabled(true);
            return false;
        }
        String validChar = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZÁÉÍÓÚ ";
        for (int i = 0; i < nombre.length(); i++) {
            String charName = String.valueOf(nombre.charAt(i));
            if (!validChar.contains(charName) && !validChar.toLowerCase().contains(charName)) {
                txtNombre.setForeground(Color.red);
                txtNombre.requestFocus();
                typeError = 1;
                return false;
            }
        }
        Query consult = new Query("consult('knowledge_database.pl')");
        if (consult.hasSolution()) {
            consult = new Query("nombre(" + getNameWithPrologFormat(nombre) + ")");
            if (consult.hasSolution()) {
                consult.close();
                typeError = 2;
                return false;
            }
        }
        if (cmbCarrera.getSelectedIndex() == 0) {
            cmbCarrera.requestFocus(true);
            return false;
        }
        return !(buttonGroupSexo.getSelection() == null || buttonGroupInteres.getSelection() == null);
    }

    enum SEXO {
        hombre, mujer
    }

    enum INTERES {
        hombres, mujeres, ambos
    }

    enum CARRERA {
        ISC, AQUITECTURA, BIOQUIMICA, CIVIL, ELECTRICA, GESTION, INDUSTRIAL,
        MECATRONICA, QUIMICA, TICS, ADMINISTRACION
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
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
                System.out.println("Error en LookAndFeel: " + e.getMessage());
            }

            new Inicial().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsult;
    private javax.swing.JButton btnStart;
    private javax.swing.ButtonGroup buttonGroupInteres;
    private javax.swing.ButtonGroup buttonGroupSexo;
    private javax.swing.JComboBox<String> cmbCarrera;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButtonBoth;
    private javax.swing.JRadioButton jRadioButtonMan;
    private javax.swing.JRadioButton jRadioButtonMen;
    private javax.swing.JRadioButton jRadioButtonWoman;
    private javax.swing.JRadioButton jRadioButtonWomen;
    private javax.swing.JLabel lblCarrera;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblFormaulario1;
    private javax.swing.JLabel lblInstruction1;
    private javax.swing.JLabel lblInstruction2;
    private javax.swing.JLabel lblMeInteresa;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
