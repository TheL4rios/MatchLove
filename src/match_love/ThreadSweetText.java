package match_love;

import javax.swing.JLabel;
import static match_love.Metodos.multStr;
import static match_love.Metodos.splitForCharacter;

/**
 *
 * @author yisus64
 */
public class ThreadSweetText extends Thread {

    private JLabel[] jlabels;
    private String[] textsReplace;
    private JLabel jlabel;
    private String textReplace; 
    private final int OPTION;
    private final long millis;
    
    public ThreadSweetText(JLabel jlabel, String textReplace, int millis) {
        this.jlabel = jlabel;
        this.textReplace = textReplace;
        this.millis = millis;
        OPTION = 1;
    }
    
    public ThreadSweetText(JLabel[] jlabels, String[] textsReplace, int millis) {
        if(jlabels.length != textsReplace.length) {
            throw new Error("La cantidad de labels debe de ser igual a la cantidad de textos a remplazar: " +
                            "cantidad de labels -> " + jlabels.length + ", cantidad de textos -> "+ textsReplace.length);
        }
        this.jlabels = jlabels;
        this.textsReplace = textsReplace;
        this.millis = millis;
        OPTION = 2;
    }

    @Override
    public void run() {
        switch (OPTION) {
            case 1:
                sweetText(jlabel, textReplace);
                break;
            case 2:
                sweetText(jlabels, textsReplace);
                break;
        }
    }

    /* Inicia un barrido de texto a un label junto con el texto de reemplazo */
    private void sweetText(JLabel jlabel, String textReplace) {
        String textJLabel = jlabel.getText();
        int tamTextJLabel = textJLabel.length(), tamTextReplace = textReplace.length();
        if (tamTextJLabel >= tamTextReplace) {
            textReplace += multStr(" ", tamTextJLabel - tamTextReplace);
        } else {
            textJLabel += multStr(" ", tamTextReplace - tamTextJLabel);
        }
        for (int j = 0; j < textJLabel.length(); j++) {
            String c = String.valueOf(textReplace.charAt(j));
            String[] splitsForChar = splitForCharacter(textJLabel, j);
            textJLabel = splitsForChar[0] + c + splitsForChar[2];
            jlabel.setText(textJLabel);
            try {
               sleep(millis);
            } catch (InterruptedException ex) {
                System.out.println("Error en barrido de texto: " + ex.getMessage());
            }
        }
    }
    
    /* Inicia un barrido de texto a un arreglo de labels junto con los textos de reemplazo */
    private void sweetText(JLabel[] jlabels, String[] textsReplace) {
        for(int i=0; i < jlabels.length; i++) {
            new ThreadSweetText(jlabels[i], textsReplace[i], (int)millis).start();
        }
    }
}
