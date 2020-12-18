package Window;

import Auxiliary.Auxiliary;
import Auxiliary.ImagePanel;
import Auxiliary.Song;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Instructions {
    protected JFrame window;
    private int windowWidth;
    private int windowHeight;
    private int buttonWidth = 180;
    private int buttonHeight = 50;
    protected Image image;
    protected ImagePanel backgroundPanel = new ImagePanel();
    private JButton startButton = new JButton("START GAME");
    private Song song;

    public Instructions(JFrame window, Song song){
        this.window = window;
        this.song=song;
        setBackground("instructions.jpg");
        backgroundPanel.setBounds(0,0, windowWidth, windowHeight);

        startButton.setFont(Auxiliary.startButtonFont);
        startButton.setBackground(Color.BLACK);
        startButton.setForeground(Color.WHITE);
        startButton.setBounds(windowWidth/2 - 210/2, 700, 210, 70);

        window.add(startButton);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                song.stop();
                new TravelUI(window);
            }
        });

    }

    public void setBackground(String name) {
        ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("Images/Backgrounds/" + name)));
        windowWidth = img.getIconWidth();
        windowHeight = img.getIconHeight();
        image = img.getImage();
        backgroundPanel.setImage(image);
        window.setContentPane(backgroundPanel);
    }
}
