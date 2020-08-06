package match_love;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

/**
 *
 * @author Marissa
 */
public class FondoPanel extends JPanel {
    private final Image image;
   
    public FondoPanel(Image image) {
        this.image = image;
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }
    
}
