import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StartMenu {

    JFrame window = new JFrame("Castle Adventure");
    Container con;

    ImagePanel titleImagePanel = new ImagePanel();


    JPanel startButtonPanel = new JPanel();
    JButton startButton = new JButton("START");

    JPanel rulesButtonPanel = new JPanel();
    JButton rulesButton = new JButton("RULES");

    public StartMenu(){
        window.setLayout(null);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);

        ImageIcon img = new ImageIcon(getClass().getClassLoader().getResource("images/mainMenu.jpg"));
        Image image = img.getImage();
        titleImagePanel.setImage(image);
        window.setContentPane(titleImagePanel);
        titleImagePanel.setBounds(0,0, img.getIconWidth(), img.getIconHeight());
        window.setSize(img.getIconWidth(), img.getIconHeight());

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) (dimension.getWidth()/2 - 600);
        int y = (int) (dimension.getHeight()/2 - 453.5);
        window.setLocation(x, y);
        window.setResizable(false);

        con = window.getContentPane();

        startButtonPanel.setBounds(400,400,200,80);
        startButtonPanel.setBackground(Color.RED);
        startButton.setFont(Auxiliary.startBottonText);
        startButton.setBackground(Color.BLACK);
        startButton.setForeground(Color.WHITE);
        startButtonPanel.add(startButton);
        con.add(startButtonPanel);

        Song song = new Song ("songs/mainMenu.wav");
        song.start();
        song.loop();

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                song.stop();
                UI ui = new UI();
                ui.createUI(window);
            }
        });

        rulesButtonPanel.setBounds(400,600,200,80);
        rulesButtonPanel.setBackground(Color.GREEN);
        rulesButton.setFont(Auxiliary.buttonFont);
        rulesButton.setBackground(Color.BLUE);
        rulesButton.setForeground(Color.YELLOW);
        rulesButtonPanel.add(rulesButton);
        con.add(rulesButtonPanel);
        rulesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("yyyyyyyyyyyyyyyyyyy");
            }
        });

        window.setVisible(true);

    }


}
