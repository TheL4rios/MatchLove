package match_love;

import javax.swing.JRadioButton;

/**
 *
 * @author yisus64
 */
public class ThreadRadioButtons extends Thread {

    private final JRadioButton[] jRadioButtons;
    private final String[] textRadioButtons;
    private final long millis;

    public ThreadRadioButtons(JRadioButton[] jRadioButtons, String[] textRadioButtons, int millis) {
        if(textRadioButtons.length > jRadioButtons.length) {
            throw new Error("La cantidad de respuestas debe de ser menor a la cantidad jRadioBUttons: "+
                            "cantidad de respuestas -> " + textRadioButtons.length + 
                            ", cantidad de jRadioButtons -> " + jRadioButtons.length);
        }
        this.jRadioButtons = jRadioButtons;
        this.textRadioButtons = textRadioButtons;
        this.millis = millis;
    }

    @Override
    public void run() {
        for (int i = 0; i < jRadioButtons.length; i++) {
            JRadioButton jRadioButton = jRadioButtons[i];
            try {
                jRadioButton.setText(textRadioButtons[i]);
                jRadioButton.setVisible(true);
                sleep(millis);
            } catch (IndexOutOfBoundsException ex) {
                jRadioButton.setText("");
                jRadioButton.setVisible(false);
            } catch (InterruptedException ex) {
                System.out.println("Error en espera de los jRadioButtons: " + ex.getMessage());
            }
        }

    }

}
