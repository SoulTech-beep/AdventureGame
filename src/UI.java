import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
public class UI {

	private JFrame frame;
	protected Image image;
	protected ImagePanel imagePanel;
	private int width;
	private int height;
	private int buttonWidth = 180;
	private int buttonHeight = 50;
	protected Song song;
	protected String position;
	private Font fontTextArea = new Font ("Times New Roman", Font.PLAIN, 24);
	private Font fontButton = new Font ("Times New Roman", Font.PLAIN, 16);
	protected JTextArea textArea;
	protected JButton ch1, ch2, ch3, ch4, ch5;
	protected Story story = new Story (this);

	public void createUI() {
		//Frame and Background
		frameCreate();

		//Story
		mainHall();

		//Song
		setSong("s0.wav");

		frame.setVisible(true);
	}

	public void setBackground(String name) {
		ImageIcon img = new ImageIcon(getClass().getClassLoader().getResource("backgrounds/" + name));
		width = img.getIconWidth();
		height = img.getIconHeight();
		image = img.getImage();
		imagePanel.setImage(image);
		frame.setContentPane(imagePanel);
	}

	public void setSong(String songLink) {
		song = new Song ("songs/" + songLink);
		song.start();
		song.loop();
	}

	private void frameCreate() {
		frame = new JFrame ("Castle Adventure");
		frame.setLayout(null);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.BLACK);
		imagePanel = new ImagePanel();
		setBackground("b0.jpg");
		imagePanel.setBounds(0,0, width,height);
		frame.setSize(width,height);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) dimension.getWidth()/2 - width/2;
		int y = (int) dimension.getHeight()/2 - height/2;
		frame.setLocation(x, y);
		frame.setResizable(false);
	}

	private void mainHall() {
		//Define Player's Position with String
		position = "mainHall";

		//Main Text
		textArea = new JTextArea("You awaken inside a dark castle. You must find a way to escape. Which way do you go?");
		textArea.setLineWrap(true);
		textArea.setFont(fontTextArea);
		textArea.setBounds(100, height/2+190, 1000, 100);
		textArea.setBackground(null);
		textArea.setForeground(Color.BLACK);
		textArea.setEditable(false);
		frame.add(textArea);

		//Option One
		ch1 = new JButton("DINING HALL");
		ch1.setActionCommand("c1");
		ch1.addActionListener(story);
		ch1.setBackground(Color.BLACK);
		ch1.setForeground(Color.WHITE);
		ch1.setFont(fontButton);
		ch1.setBounds(100, height/2+300, buttonWidth, buttonHeight);
		frame.add(ch1);

		//Option Two
		ch2 = new JButton("DUNGEON");
		ch2.setActionCommand("c2");
		ch2.addActionListener(story);
		ch2.setBackground(Color.BLACK);
		ch2.setForeground(Color.WHITE);
		ch2.setFont(fontButton);
		ch2.setBounds((100 + buttonWidth + width/2-buttonWidth/2)/2 - buttonWidth/2, height/2+300, buttonWidth, buttonHeight);
		frame.add(ch2);


		//Option Three
		ch3 = new JButton("UP THE STAIRS");
		ch3.setActionCommand("c3");
		ch3.addActionListener(story);
		ch3.setBackground(Color.BLACK);
		ch3.setForeground(Color.WHITE);
		ch3.setFont(fontButton);
		ch3.setBounds(width/2-buttonWidth/2, height/2+300, buttonWidth, buttonHeight);
		frame.add(ch3);

		//Option Four
		ch4 = new JButton("BATHROOM");
		ch4.setActionCommand("c4");
		ch4.addActionListener(story);
		ch4.setBackground(Color.BLACK);
		ch4.setForeground(Color.WHITE);
		ch4.setFont(fontButton);
		ch4.setBounds((width/2+ buttonWidth/2 + 1100-buttonWidth)/2 - buttonWidth/2, height/2+300, buttonWidth, buttonHeight);
		frame.add(ch4);


		//Option Five
		ch5 = new JButton("THRONE ROOM");
		ch5.setActionCommand("c5");
		ch5.addActionListener(story);
		ch5.setBackground(Color.BLACK);
		ch5.setForeground(Color.WHITE);
		ch5.setFont(fontButton);
		ch5.setBounds(1100-buttonWidth, height/2+300, buttonWidth, buttonHeight);
		frame.add(ch5);
	}

}
