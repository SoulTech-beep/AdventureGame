import java.awt.*;
import java.util.Objects;
import javax.swing.*;

public class UI {

	private JFrame window;
	private int windowWidth;
	private int windowHeight;
	private int buttonWidth = 180;
	private int buttonHeight = 50;
	protected Image image;
	protected ImagePanel imagePanel;
	protected Song song;
	protected String position;
	protected JTextArea mainText;
	protected JButton bt1, bt2, bt3, bt4, bt5;
	protected Story story = new Story (this);

	public void createUI() {
		//Frame and Background
		frameCreate();

		//Start Point
		mainHall();
		setSong("s0.wav");

		window.setVisible(true);
	}



	private void frameCreate() {
		window = new JFrame ("Castle Adventure");
		window.setLayout(null);
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.BLACK);

		setBackground("mainHall.jpg");
		imagePanel.setBounds(0,0, windowWidth, windowHeight);
		window.setSize(windowWidth, windowHeight);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) dimension.getWidth()/2 - windowWidth /2;
		int y = (int) dimension.getHeight()/2 - windowHeight /2;
		window.setLocation(x, y);
		window.setResizable(false);
	}

	public void setBackground(String name) {
		imagePanel = new ImagePanel();
		ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("Images/backgrounds/" + name)));
		windowWidth = img.getIconWidth();
		windowHeight = img.getIconHeight();
		image = img.getImage();
		imagePanel.setImage(image);
		window.setContentPane(imagePanel);
	}

	public void setSong(String songLink) {
		song = new Song ("songs/" + songLink);
		song.start();
		song.loop();
	}

	private void mainHall() {
		//Define Player's Position with String
		position = "mainHall";

		//Main Text
		mainText = new JTextArea("You awaken inside a dark castle. You must find a way to escape. Which way do you go?");
		mainText.setLineWrap(true);
		mainText.setFont(Auxiliary.mainFont);
		mainText.setBounds(100, windowHeight / 2 + 190, 1000, 100);
		mainText.setBackground(null);
		mainText.setForeground(Color.BLACK);
		mainText.setEditable(false);
		window.add(mainText);

		// Buttons
		bt1 = setButton("DINING HALL", "b1", 100);
		window.add(bt1);
		bt2 = setButton("DUNGEON", "b2", (100 + buttonWidth + windowWidth / 2 - buttonWidth / 2) / 2 - buttonWidth / 2);
		window.add(bt2);
		bt3 = setButton("UP THE STAIRS", "b3", windowWidth / 2 - buttonWidth / 2);
		window.add(bt3);
		bt4 = setButton("BATHROOM", "b4", (windowWidth / 2 + buttonWidth / 2 + 1100 - buttonWidth) / 2 - buttonWidth / 2);
		window.add(bt4);
		bt5 = setButton("THRONE ROOM", "b5", 1100 - buttonWidth);
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
