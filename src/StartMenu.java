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
        window.setSize(1200,907);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);


        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) (dimension.getWidth()/2 - 600);
        int y = (int) (dimension.getHeight()/2 - 453.5);
        window.setLocation(x, y);
        window.setResizable(false);

        con = window.getContentPane();

        //TODO help já não sei o que fazer aqui!
//        titleNamePanel.setBounds(100,100,525,375);
//        titleNamePanel.setImage(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/title.jpeg"))).getImage());
//        titleNamePanel.setBackground(Color.BLACK);
//        titleNameLabel.setText("CASTLE ADVENTURE");
//        titleNameLabel.setFont(Auxiliary.titleFont);
//        titleNameLabel.setForeground(Color.white);
//        titleNamePanel.add(titleNameLabel);
//        window.setContentPane(titleNamePanel);
//        con.add(titleNamePanel);


        ImageIcon img = new ImageIcon(getClass().getClassLoader().getResource("images/mainMenu.jpeg"));
        Image image = img.getImage();
        titleImagePanel.setImage(image);
        window.setContentPane(titleImagePanel);


//
//        window.add(new JLabel(new ImageIcon("C:\\Users\\Henrique\\IdeaProjects\\AdventureGame\\src\\images\\title.jpg")));


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
