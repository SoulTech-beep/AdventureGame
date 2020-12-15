import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StartMenu {

    JFrame window = new JFrame("Castle Adventure");

    protected ImagePanel backgroundPanel = new ImagePanel();

    JButton startButton = new JButton("START GAME");
    JButton rulesButton = new JButton("INSTRUCTIONS");


    public StartMenu(){
        window.setLayout(null);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);

        backgroundPanel = Auxiliary.setBackground("mainMenu.jpg");
        int windowWidth = backgroundPanel.getWidth();
        int windowHeight = backgroundPanel.getHeight();
        window.setContentPane(backgroundPanel);
        window.setSize(windowWidth, windowHeight);

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) (dimension.getWidth()/2 - windowWidth/2);
        int y = (int) (dimension.getHeight()/2 - windowHeight/2);
        window.setLocation(x, y);
        window.setResizable(false);

        Song song = new Song ("songs/mainMenu.wav");
        song.start();
        song.loop();

        startButton.setFont(Auxiliary.startButtonText);
        startButton.setBackground(Color.BLACK);
        startButton.setForeground(Color.WHITE);
        startButton.setBounds(windowWidth/2 - 210/2, 540, 210, 70);



        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                song.stop();
                UI ui = new UI();
                ui.createUI(window);
            }
        });
        window.add(startButton);

        rulesButton.setFont(Auxiliary.startButtonText);
        rulesButton.setBackground(Color.BLACK);
        rulesButton.setForeground(Color.WHITE);
        rulesButton.setBounds(windowWidth/2 - 210/2, 630, 210, 70);
        rulesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("yyyyyyyyyyyyyyyyyyy");
            }
        });
        window.add(rulesButton);
        window.setVisible(true);

    }


}
