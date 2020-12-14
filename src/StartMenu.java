import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class StartMenu {

    JFrame window = new JFrame("Castle Adventure");
    Container con;

    ImagePanel titleImagePanel = new ImagePanel();

    JPanel startButtonPanel = new JPanel();
    JButton startButton = new JButton();

    public StartMenu(){
        window.setLayout(null);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);

        ImageIcon img = new ImageIcon(getClass().getClassLoader().getResource("images/mainMenu.jpg"));
        Image image = img.getImage();
        titleImagePanel.setImage(image);
        window.setContentPane(titleImagePanel);
        int windowWidth = img.getIconWidth();
        int windowHeight = img.getIconHeight();
        titleImagePanel.setBounds(0,0, windowWidth, windowHeight);
        window.setSize(windowWidth, windowHeight);

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) (dimension.getWidth()/2 - 600);
        int y = (int) (dimension.getHeight()/2 - 453.5);
        window.setLocation(x, y);
        window.setResizable(false);

        con = window.getContentPane();

        startButtonPanel.setBounds(400,400,200,80);
        startButtonPanel.setBackground(Color.RED);
        startButton.setText("START");
        startButton.setFont(Auxiliary.startBottonText);
        startButton.setBackground(Color.BLACK);
        startButton.setForeground(Color.WHITE);

        startButtonPanel.add(startButton);
        con.add(startButtonPanel);



        window.setVisible(true);

    }


}
