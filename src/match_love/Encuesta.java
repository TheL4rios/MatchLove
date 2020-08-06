package match_love;

import javax.swing.ImageIcon;
import java.awt.Image;
import Animacion.Animacion;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.Timer;
import java.util.Map;
import javax.swing.JOptionPane;
import org.jpl7.Query;
import org.jpl7.Term;
import static match_love.Metodos.*;
import rojerusan.RSAnimation;

/**
 *
 * @author yisus64
 */
public class Encuesta extends javax.swing.JFrame {

    Image[] imagesInterview; // Arreglo de imágenes para la ventana Encuesta
    int indexImgInterview; // Índice de referencia del arreglo de imágenes de la ventana Encuesta 
    FondoPanel fondoPanel; // Imagen de fondo para el frame de la ventana Encuesta
    Timer timerChangeBackgFondo; // Timer para cambiar el fondo (label) de la ventana Encuesta 
    ArrayList<Pregunta> preguntas; // Guardar las preguntas y sus respuestas
    JLabel[] jLabels; // Anexar los labels que tendrán efecto de barrido
    JRadioButton[] jRadioButtons; // Anexar los jRadioButtons
    int indexQuestions; // Índice de referencia del arreglo de preguntas
    Timer timerChangeBackgFondo2; // Timer para cambiar el fondo2 (label) de la ventana Encuesta 
    Popup popup; // Popup para proporcionar información al usuario
    String nombre; // Almacenar el nombre de la persona que hizo la encuesta
    Inicial.SEXO sexo; // Almacenar el sexo de la perosna que hizo la encuesta
    Inicial.INTERES interes; // Almacenar el sexo que le atrae a la perosna que hizo la encuesta
    ArrayList<String> nombreIntereses;
    /* Guardar el nombre de las personas que le interesan a 
                                          la persona que hizo la encuesta */
    Inicial.CARRERA carrera; // Guardar la carrea de la persona que hizo la encuesta

    /**
     * Creates new form NewJFrame
     */
    public Encuesta() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        RSAnimation.setMoverDerecha(-50, 520, 3, 5, this);
    }

    void setDataPerson(String nombre, Inicial.SEXO sexo, Inicial.INTERES interes, Inicial.CARRERA carrera) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.interes = interes;
        this.carrera = carrera;
    }

    // Inicialización de variables u otros componentes importantes
    public void init() {
        // Colocar en el centro de la pantalla
        setLocationRelativeTo(null);

        // Inicializar todos los ArrayList
        preguntas = new ArrayList();
        nombreIntereses = new ArrayList();

        //Obtener las imágenes que se encuentran en la carpeta images/interview
        imagesInterview = getImagesResource("/images/love", getWidth(), getHeight());
        indexImgInterview = 0;

        // Timers de transición de fondo
        BackgroundTransition();

        // Agregar los jRadioButton a un arreglo
        jRadioButtons = new JRadioButton[]{jRadioButtonA, jRadioButtonB,
            jRadioButtonC, jRadioButtonD,
            jRadioButtonE, jRadioButtonF,
            jRadioButtonG};

        // Agregar los jRadioButtons a un buttonGroup
        for (JRadioButton jRadioButton : jRadioButtons) {
            buttonGroup.add(jRadioButton);
        }

        // Guardar labels que tendrán efecto de barrido
        jLabels = new JLabel[]{lblNumberQuestion, lblQuestion};

        // Obtener datos de la base de conocimiento de Prolog
        getQuestionsAnswersProlog();

        // Inicializar índice para recorrido de preguntas
        indexQuestions = 0;
        setQuestionInWindow(preguntas.get(indexQuestions));
        setStateButtons();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        panelAnswers = new javax.swing.JPanel();
        jRadioButtonA = new javax.swing.JRadioButton();
        jRadioButtonB = new javax.swing.JRadioButton();
        jRadioButtonC = new javax.swing.JRadioButton();
        jRadioButtonD = new javax.swing.JRadioButton();
        jRadioButtonE = new javax.swing.JRadioButton();
        jRadioButtonF = new javax.swing.JRadioButton();
        jRadioButtonG = new javax.swing.JRadioButton();
        btnNext = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnFinish = new javax.swing.JButton();
        lblNumberQuestion = new javax.swing.JLabel();
        lblQuestion = new javax.swing.JLabel();
        btnStart = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();
        lblFondo2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("っ˘̩╭╮˘̩)っ      (っ˘з(˘⌣˘ ) ♡");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/images/icons/heart.png")).getImage()
        );
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelAnswers.setBackground(new java.awt.Color(0, 0, 0));
        panelAnswers.setLayout(new javax.swing.BoxLayout(panelAnswers, javax.swing.BoxLayout.Y_AXIS));

        jRadioButtonA.setBackground(new java.awt.Color(0, 0, 0));
        jRadioButtonA.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jRadioButtonA.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonA.setText("Respuesta A");
        panelAnswers.add(jRadioButtonA);

        jRadioButtonB.setBackground(new java.awt.Color(0, 0, 0));
        jRadioButtonB.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jRadioButtonB.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonB.setText("Respuesta B");
        panelAnswers.add(jRadioButtonB);

        jRadioButtonC.setBackground(new java.awt.Color(0, 0, 0));
        jRadioButtonC.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jRadioButtonC.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonC.setText("Respuesta C");
        panelAnswers.add(jRadioButtonC);

        jRadioButtonD.setBackground(new java.awt.Color(0, 0, 0));
        jRadioButtonD.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jRadioButtonD.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonD.setText("Respuesta D");
        panelAnswers.add(jRadioButtonD);

        jRadioButtonE.setBackground(new java.awt.Color(0, 0, 0));
        jRadioButtonE.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jRadioButtonE.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonE.setText("Respuesta E");
        panelAnswers.add(jRadioButtonE);

        jRadioButtonF.setBackground(new java.awt.Color(0, 0, 0));
        jRadioButtonF.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jRadioButtonF.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonF.setText("Respuesta F");
        panelAnswers.add(jRadioButtonF);

        jRadioButtonG.setBackground(new java.awt.Color(0, 0, 0));
        jRadioButtonG.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jRadioButtonG.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonG.setText("Respuesta G");
        panelAnswers.add(jRadioButtonG);

        getContentPane().add(panelAnswers, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 630, 200));

        btnNext.setBackground(new java.awt.Color(0, 0, 0));
        btnNext.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 14)); // NOI18N
        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/vintage/flecha.png"))); // NOI18N
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        getContentPane().add(btnNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 360, 80, 40));

        btnBack.setBackground(new java.awt.Color(0, 0, 0));
        btnBack.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 14)); // NOI18N
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/vintage/flecha-izquierda.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 360, 80, 40));

        btnFinish.setBackground(new java.awt.Color(0, 0, 0));
        btnFinish.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 14)); // NOI18N
        btnFinish.setForeground(new java.awt.Color(255, 0, 153));
        btnFinish.setText("Terminar");
        btnFinish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinishActionPerformed(evt);
            }
        });
        getContentPane().add(btnFinish, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 360, 90, 40));

        lblNumberQuestion.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        lblNumberQuestion.setText("Pregunta");
        getContentPane().add(lblNumberQuestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        lblQuestion.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 18)); // NOI18N
        lblQuestion.setText("¿?");
        getContentPane().add(lblQuestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        btnStart.setBackground(new java.awt.Color(0, 0, 0));
        btnStart.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 14)); // NOI18N
        btnStart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/vintage/salida.png"))); // NOI18N
        btnStart.setText("Inicio");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });
        getContentPane().add(btnStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 100, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/vintage/parejas.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 90, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/vintage/lesbiana.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/vintage/gay.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 90, -1, -1));

        lblFondo.setBackground(new java.awt.Color(255, 0, 204));
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 460));
        getContentPane().add(lblFondo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Evento para el botón atrás
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        lblFondo.setVisible(false); // Lo hacemos invisible porque empieza a parpadear, desconocemos porque
        Pregunta pregunta = preguntas.get(indexQuestions);
        setSelectedAnswerToQuestion(pregunta);
        Pregunta preguntaAnt = preguntas.get(--indexQuestions);
        setQuestionInWindow(preguntaAnt);
        setStateButtons();
    }//GEN-LAST:event_btnBackActionPerformed

    // Evento para el botón siguiente
    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        lblFondo.setVisible(false); // Lo hacemos invisible porque empieza a parpadear, desconocemos porque
        if (buttonGroup.getSelection() != null) {
            Pregunta preguntaAct = preguntas.get(indexQuestions);
            setSelectedAnswerToQuestion(preguntaAct);
            setQuestionInWindow(preguntas.get(++indexQuestions));
            setStateButtons();
        } else {
            showPopup(Popup.POPUP_TYPE.MISSING_QUESTION);
        }
    }//GEN-LAST:event_btnNextActionPerformed

    // Evento para el botón terminar
    private void btnFinishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinishActionPerformed
        if (buttonGroup.getSelection() != null) {
            // Guardar la última pregunta
            Pregunta pregunta = preguntas.get(indexQuestions);
            setSelectedAnswerToQuestion(pregunta);
            // Agregar datos al archivo Prolog mediante Buffer de datos
            addDataToFilesProlog();
            Final finalFrame = new Final();
            finalFrame.init(getNameWithPrologFormat(nombre));
            finalFrame.setVisible(true);
            close();
        } else {
            showPopup(Popup.POPUP_TYPE.MISSING_QUESTION);
        }
    }//GEN-LAST:event_btnFinishActionPerformed

    // Ir a la ventana de inicio, si confirma abandonar la encuesta
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
        return JOptionPane.showConfirmDialog(null, "¿Deseas cerrar la encuesta? Tus respuestas se borrarán de forma definitiva",
                "(｡T ω T｡) Encuesta en curso (｡T ω T｡)", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE) == 0;
    }

    // Cerrar toda la ventana y lo relacionado con ella
    private void close() {
        dispose();
        if (popup != null) {
            popup.dispose();
        }
    }

    // Método para Timers de transición de fondo
    private void BackgroundTransition() {
        lblFondo2.setIcon(new ImageIcon(imagesInterview[indexImgInterview]));
        double s = 4;
        timerChangeBackgFondo2 = new Timer((int) (s * 1000), (ActionEvent e) -> {
            indexImgInterview++;
            if (indexImgInterview == imagesInterview.length) {
                indexImgInterview = 0;
            }
            lblFondo2.setIcon(new ImageIcon(imagesInterview[indexImgInterview]));
            if (indexImgInterview == 0) {
                lblFondo.setIcon(new ImageIcon(imagesInterview[imagesInterview.length - 1]));
            } else {
                lblFondo.setIcon(new ImageIcon(imagesInterview[indexImgInterview - 1]));
            }
            lblFondo.setLocation(0, 0);
            lblFondo.setVisible(true);
        });
        s = 7;
        timerChangeBackgFondo = new Timer((int) (s * 1000), (ActionEvent e) -> {
            Animacion.mover_derecha(0, getWidth(), 1, 6, lblFondo);
            timerChangeBackgFondo.restart();
            timerChangeBackgFondo2.restart();
        });
        timerChangeBackgFondo.start();
        timerChangeBackgFondo2.start();
    }

    // Especificar el estado de los botones, dependiendo del índice de la pregunta
    private void setStateButtons() {
        if (preguntas.size() == 1) {
            btnBack.setEnabled(false);
            btnNext.setEnabled(false);
            btnFinish.setEnabled(true);
        } else if (indexQuestions == preguntas.size() - 1) {
            btnBack.setEnabled(true);
            btnNext.setEnabled(false);
            btnFinish.setEnabled(true);
        } else if (indexQuestions == 0) {
            btnBack.setEnabled(false);
            btnNext.setEnabled(true);
            btnFinish.setEnabled(false);
        } else {
            btnBack.setEnabled(true);
            btnNext.setEnabled(true);
            btnFinish.setEnabled(false);
        }
    }

    // Cambiar texto de labels y radioButtons con efecto de barrido
    private void setQuestionInWindow(Pregunta pregunta) {
        new ThreadSweetText(jLabels, new String[]{"Pregunta " + pregunta.numero, pregunta.pregunta}, 15).start();
        new ThreadRadioButtons(jRadioButtons, pregunta.respuestas, 60).start();
        setSelectedAnswer(pregunta);
    }

    private void setSelectedAnswer(Pregunta pregunta) {
        switch (pregunta.selectRespuesta) {
            case A:
                jRadioButtonA.setSelected(true);
                break;
            case B:
                jRadioButtonB.setSelected(true);
                break;
            case C:
                jRadioButtonC.setSelected(true);
                break;
            case D:
                jRadioButtonD.setSelected(true);
                break;
            case E:
                jRadioButtonE.setSelected(true);
                break;
            case F:
                jRadioButtonF.setSelected(true);
                break;
            case G:
                jRadioButtonG.setSelected(true);
                break;
            case NONE:
                buttonGroup.clearSelection();
        }
    }

    /* Asignar una respuesta a cada una de las preguntas del arreglo de preguntas, dependiendo del estado 
    de los jRadioButton */
    private void setSelectedAnswerToQuestion(Pregunta pregunta) {
        for (JRadioButton jRadioButton : jRadioButtons) {
            if (jRadioButton.isSelected()) {
                if (jRadioButton == jRadioButtonA) {
                    pregunta.selectRespuesta = Pregunta.RESPUESTA.A;
                    pregunta.indexSelectRespuesta = 0;
                } else if (jRadioButton == jRadioButtonB) {
                    pregunta.selectRespuesta = Pregunta.RESPUESTA.B;
                    pregunta.indexSelectRespuesta = 1;
                } else if (jRadioButton == jRadioButtonC) {
                    pregunta.selectRespuesta = Pregunta.RESPUESTA.C;
                    pregunta.indexSelectRespuesta = 2;
                } else if (jRadioButton == jRadioButtonD) {
                    pregunta.selectRespuesta = Pregunta.RESPUESTA.D;
                    pregunta.indexSelectRespuesta = 3;
                } else if (jRadioButton == jRadioButtonE) {
                    pregunta.selectRespuesta = Pregunta.RESPUESTA.E;
                    pregunta.indexSelectRespuesta = 4;
                } else if (jRadioButton == jRadioButtonF) {
                    pregunta.selectRespuesta = Pregunta.RESPUESTA.F;
                    pregunta.indexSelectRespuesta = 5;
                } else {
                    pregunta.selectRespuesta = Pregunta.RESPUESTA.G;
                    pregunta.indexSelectRespuesta = 6;
                }
                break;
            }
        }
    }

    // Obtener los datos (preguntas y respuestas) del archivo prolog, para mostrarlas al usuario
    private void getQuestionsAnswersProlog() {
        // Obtener las preguntas y sus posibles respuestas
        ArrayList<String> respuestas = new ArrayList();
        String pregunta = null;
        Query consult = new Query("consult('questions_answers.pl')");
        if (consult.hasSolution()) {
            for (int i = 1; i <= 23; i++) {
                consult = new Query("question(X, " + i + ")");
                if (consult.hasSolution()) {
                    String question = consult.oneSolution().get("X").toString();
                    pregunta = question.substring(1, question.length() - 1);
                    // Obtenemos las respuestas de cada pregunta
                    consult = new Query("answer(X, " + i + ")");
                    if (consult.hasSolution()) {
                        Map<String, Term>[] result = consult.allSolutions();
                        for (Map<String, Term> res : result) {
                            // Llenamos el array con las respuestas
                            String answer = res.get("X").toString();
                            if (answer.contains("'")) {
                                answer = answer.substring(1, answer.length() - 1);
                            }
                            respuestas.add(answer);
                        }
                    }
                }
                if (!respuestas.isEmpty()) {
                    // Creamos una pregunta con sus respuestas y la agregamos al arreglo de preguntas
                    preguntas.add(new Pregunta(i, pregunta, ArrayListToArray(respuestas)));
                    respuestas.clear();
                }

            }
        }
        consult.close();
    }

    // Agregar los nuevos datos de la persona que hizo la encuesta al archivo prolog
    private void addDataToFilesProlog() {
        // Modificación de variables
        String name = getNameWithPrologFormat(nombre),
                career = carrera.toString().toLowerCase(),
                sex = sexo.toString(),
                interest = interes.toString(),
                data = "%===============================================================================\n"
                + "%============================= HECHOS RESPUESTAS ===============================\n"
                + "%===============================================================================\n\n";

        Query consult = new Query("consult('knowledge_database.pl')");
        if (consult.hasSolution()) {
            // Consultar nombres
            consult = new Query("nombre(X)");
            if (consult.hasSolution()) {
                Map<String, Term>[] result = consult.allSolutions();
                for (Map<String, Term> res : result) {
                    // Concatenamos las consultas de los nombres
                    String nom = res.get("X").toString();
                    if (nom.contains("'")) {
                        nom = nom.substring(1, nom.length() - 1);
                    }
                    data += "nombre(" + nom + ").\n";
                }
                data += "nombre(" + name + ").\n\n";
            }
            // Consultar carreras
            consult = new Query("carrera(X, Y)");
            if (consult.hasSolution()) {
                Map<String, Term>[] result = consult.allSolutions();
                for (Map<String, Term> res : result) {
                    // Concatenamos las consultas de la carreras
                    String nom = res.get("X").toString(),
                            car = res.get("Y").toString();
                    if (nom.contains("'")) {
                        nom = nom.substring(1, nom.length() - 1);
                    }
                    data += "carrera(" + nom + "," + car + ").\n";
                }
                data += "carrera(" + name + ", " + career + ").\n\n";
            }
            // Consultar los que son hombres
            consult = new Query("eshombre(X)");
            if (consult.hasSolution()) {
                Map<String, Term>[] result = consult.allSolutions();
                for (Map<String, Term> res : result) {
                    // Concatenamos las consultas de si es hombre
                    String nom = res.get("X").toString();
                    if (nom.contains("'")) {
                        nom = nom.substring(1, nom.length() - 1);
                    }
                    data += "eshombre(" + nom + ").\n";
                }
                if (sex.equals("hombre")) {
                    data += "eshombre(" + name + ").\n";
                }
            }
            // Consultar los que son hombres
            consult = new Query("esmujer(X)");
            if (consult.hasSolution()) {
                Map<String, Term>[] result = consult.allSolutions();
                for (Map<String, Term> res : result) {
                    // Concatenamos las consultas de si son mujeres
                    String nom = res.get("X").toString();
                    if (nom.contains("'")) {
                        nom = nom.substring(1, nom.length() - 1);
                    }
                    data += "esmujer(" + nom + ").\n";
                }
                if (sex.equals("mujer")) {
                    data += "esmujer(" + name + ").\n\n";
                } else {
                    data += "\n";
                }
            }
            // Consultar lo que le atrea a cada uno
            consult = new Query("leatrae(X, Y)");
            if (consult.hasSolution()) {
                Map<String, Term>[] result = consult.allSolutions();
                for (Map<String, Term> res : result) {
                    // Concatenamos las consultas de el sexo que le atrae
                    String nom = res.get("X").toString(),
                            resp = res.get("Y").toString();
                    if (nom.contains("'")) {
                        nom = nom.substring(1, nom.length() - 1);
                    }
                    data += "leatrae(" + nom + ", " + resp + ").\n";
                }
                data += "leatrae(" + name + ", " + interest + ").\n\n";
            }

            /* Consultar las respuestas de cada uno de los hechos (predicados)
               La cantidad de hechos y de preguntas es exactamente la misma
             */
            String[] hechos = Hechos.HECHOS;
            for (int i = 0; i < hechos.length; i++) {
                Pregunta pregunta = preguntas.get(i);
                String hecho = hechos[i];
                consult = new Query(hecho + "(X, Y)");
                if (consult.hasSolution()) {
                    Map<String, Term>[] result = consult.allSolutions();
                    for (Map<String, Term> res : result) {
                        // Concatenamos las respuestas del hecho (predicado) i
                        String nom = res.get("X").toString(),
                                resp = res.get("Y").toString();
                        if (nom.contains("'")) {
                            nom = nom.substring(1, nom.length() - 1);
                        }
                        if (resp.contains("'")) {
                            resp = resp.substring(1, resp.length() - 1);
                        }
                        data += hecho + "(" + nom + ", \"" + resp + "\").\n";
                    }
                    data += hecho + "(" + name + ", \"" + pregunta.getRespuesta() + "\").\n\n";
                }
            }
        }
        consult.close();
        /* Exportamos un archivo de nombre  knowledge_database.pl (si ya existe lo sobrescribe) con los 
        datos anteriores + datos nuevos del usuario + el texto que contiene el archivo validations.val 
        Nota: ISO_8859_1 es el formato ANSI con el que puede trabajar prolog */
        String directory = System.getProperty("user.dir"), // Obtiene el directorio de trabajo
                nameFile = "knowledge_database.pl",
                nameFileValidations = "validations.val";
        data += decodeTextOfFile(directory, nameFileValidations, StandardCharsets.ISO_8859_1);
        exportFileEncoding(directory, nameFile, data, StandardCharsets.ISO_8859_1);
    }

    // Obtener cada uno de las imágenes de la carpeta o de alguna subcarpeta de Source Packages
    private Image[] getImagesResource(String resource) {
        File[] files = getFilesResource(resource);
        Image[] images = new Image[files.length];
        for (int i = 0; i < files.length; i++) {
            images[i] = new ImageIcon(String.valueOf(files[i])).getImage();
        }

        return images;
    }

    /* Obtener cada uno de las imágenes de la carpeta o de alguna subcarpeta de Source Packages,
       especificando un tamaño específico de escalamiento
     */
    private Image[] getImagesResource(String resource, int width, int height) {
        Image[] images = getImagesResource(resource);
        for (int i = 0; i < images.length; i++) {
            images[i] = scaleImage(images[i], width, height);
        }
        return images;
    }

    // Obtener cada uno de los archivos de la carpeta o de alguna subcarpeta de Source Packages   
    private File[] getFilesResource(String resource) {
        File file = new File(getClass().getResource(resource).getFile());
        return file.listFiles();
    }

    // Mostrar un tipo de Popup
    private void showPopup(Popup.POPUP_TYPE option) {
        if (popup == null) {
            popup = new Popup(option);
        }
        popup.setVisible(true);
        popup.move();
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
            java.util.logging.Logger.getLogger(Encuesta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Encuesta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Encuesta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Encuesta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Encuesta().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnFinish;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnStart;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton jRadioButtonA;
    private javax.swing.JRadioButton jRadioButtonB;
    private javax.swing.JRadioButton jRadioButtonC;
    private javax.swing.JRadioButton jRadioButtonD;
    private javax.swing.JRadioButton jRadioButtonE;
    private javax.swing.JRadioButton jRadioButtonF;
    private javax.swing.JRadioButton jRadioButtonG;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblFondo2;
    private javax.swing.JLabel lblNumberQuestion;
    private javax.swing.JLabel lblQuestion;
    private javax.swing.JPanel panelAnswers;
    // End of variables declaration//GEN-END:variables

}
