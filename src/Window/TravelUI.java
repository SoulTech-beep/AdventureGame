package Window;

import Auxiliary.Auxiliary;

import java.awt.*;
import java.util.Objects;
import javax.swing.*;
import Auxiliary.*;

public class TravelUI {

	protected JFrame window;
	private int windowWidth;
	private int windowHeight;
	private int buttonWidth = 180;
	private int buttonHeight = 50;
	protected Image image;
	protected ImagePanel backgroundPanel = new ImagePanel();
	protected Song song;
	protected String position;
	protected JTextArea mainText;
	protected JButton bt1, bt2, bt3, bt4, bt5;
	protected Story story = new Story (this);



	public TravelUI(JFrame window) {
		//Create Frame
		this.window = window;
		setBackground("background.jpg");
		backgroundPanel.setBounds(0,0, windowWidth, windowHeight);

		//Set position
		entrance();

		//Set song
		song = new Song("game.wav");


	}


	public void setBackground(String name) {
		ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("Images/Backgrounds/" + name)));
		windowWidth = img.getIconWidth();
		windowHeight = img.getIconHeight();
		image = img.getImage();
		backgroundPanel.setImage(image);
		window.setContentPane(backgroundPanel);
	}

	private void entrance() {
		//Define Player's Position with String
		position = "entrance";

		//Main Text
		mainText = new JTextArea("You awaken inside a dark and creepy forest. You must find a way to escape. Which way do you go?");
		mainText.setLineWrap(true);
		mainText.setFont(Auxiliary.mainFont);
		mainText.setBounds(100, windowHeight / 2 + 190, 1000, 100);
		mainText.setBackground(null);
		mainText.setForeground(Color.BLACK);
		mainText.setEditable(false);
		window.add(mainText);

		// Buttons
		bt1 = setButton("GO LEFT", "b1", 100);
		window.add(bt1);
		bt2 = setButton("CALL FOR HELP", "b2", (100 + buttonWidth + windowWidth / 2 - buttonWidth / 2) / 2 - buttonWidth / 2);
		window.add(bt2);
		bt3 = setButton("GO FORWARD", "b3", windowWidth / 2 - buttonWidth / 2);
		window.add(bt3);
		bt4 = setButton("CRY", "b4", (windowWidth / 2 + buttonWidth / 2 + 1100 - buttonWidth) / 2 - buttonWidth / 2);
		window.add(bt4);
		bt5 = setButton("GO RIGHT", "b5", 1100 - buttonWidth);
		window.add(bt5);
	}

	private JButton setButton(String textButton, String id, int buttonX){
		JButton button = new JButton(textButton);
		button.setActionCommand(id);
		button.addActionListener(story);
		button.setBackground(Color.BLACK);
		button.setForeground(Color.WHITE);
		button.setFont(Auxiliary.buttonFont);
		Rectangle bounds = new Rectangle(buttonX, windowHeight /2+300, buttonWidth, buttonHeight);
		button.setBounds(bounds);
		return button;
	}

}
