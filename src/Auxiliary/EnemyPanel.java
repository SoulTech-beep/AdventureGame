package Auxiliary;

import java.awt.Graphics;
import java.awt.Image;
import java.io.Serial;

import javax.swing.JComponent;

public class EnemyPanel extends JComponent{

    @Serial
    private static final long serialVersionUID = 2L;
    private Image image;

    public EnemyPanel() {}

    public EnemyPanel(Image image) {
        this.image = image;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 600, 0, this);
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

}