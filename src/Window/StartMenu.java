package Window;

import Auxiliary.Auxiliary;
import Auxiliary.ImagePanel;
import Auxiliary.Song;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StartMenu {

    private JFrame window = new JFrame("Castle Adventure");

    private ImagePanel titleImagePanel = new ImagePanel();

    JButton startButton = new JButton("START GAME");
    JButton rulesButton = new JButton("INSTRUCTIONS");

    private int windowWidth;
    private int windowHeight;

    public StartMenu(){
        window.setLayout(null);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);

        ImageIcon img = new ImageIcon(getClass().getClassLoader().getResource("images/mainMenu.jpg"));
        Image image = img.getImage();
        titleImagePanel.setImage(image);
        window.setContentPane(titleImagePanel);
        windowWidth = img.getIconWidth();
        windowHeight = img.getIconHeight();
        titleImagePanel.setBounds(0,0, windowWidth, windowHeight);
        window.setSize(img.getIconWidth(), img.getIconHeight());

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) (dimension.getWidth()/2 - windowWidth/2);
        int y = (int) (dimension.getHeight()/2 - windowHeight/2);
        window.setLocation(x, y);
        window.setResizable(false);

        Song song = new Song("menu.wav");

        startButton.setFont(Auxiliary.startButtonFont);
        startButton.setBackground(Color.BLACK);
        startButton.setForeground(Color.WHITE);
        startButton.setBounds(windowWidth/2 - 210/2, 540, 210, 70);

        window.add(startButton);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                song.stop();
                TravelUI travelUi = new TravelUI(window);
            }
        });


        rulesButton.setFont(Auxiliary.startButtonFont);
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
