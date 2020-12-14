import java.awt.*;
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
	private final Font fontMainText = new Font ("Times New Roman", Font.PLAIN, 24);
	private final Font fontButtonText = new Font ("Times New Roman", Font.PLAIN, 16);
	protected JTextArea mainText;
	protected JButton bt1, bt2, bt3, bt4, bt5;
	protected Story story = new Story (this);

	public void createUI() {
		//Frame and Background
		frameCreate();

		//Start Point
		mainHall();
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
		setBackground("mainHall.jpg");
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
		mainText = new JTextArea("You awaken inside a dark castle. You must find a way to escape. Which way do you go?");
		mainText.setLineWrap(true);
		mainText.setFont(fontMainText);
		mainText.setBounds(100, height / 2 + 190, 1000, 100);
		mainText.setBackground(null);
		mainText.setForeground(Color.BLACK);
		mainText.setEditable(false);
		frame.add(mainText);


		// Buttons
		bt1 = setButton("DINING HALL", "b1", 100);
		frame.add(bt1);
		bt2 = setButton("DUNGEON", "b2", (100 + buttonWidth + width / 2 - buttonWidth / 2) / 2 - buttonWidth / 2);
		frame.add(bt2);
		bt3 = setButton("UP THE STAIRS", "b3", width / 2 - buttonWidth / 2);
		frame.add(bt3);
		bt4 = setButton("BATHROOM", "b4", (width / 2 + buttonWidth / 2 + 1100 - buttonWidth) / 2 - buttonWidth / 2);
		frame.add(bt4);
		bt5 = setButton("THRONE ROOM", "b5", 1100 - buttonWidth);
		frame.add(bt5);
	}

	private JButton setButton(String textButton, String id, int buttonX){

		JButton button = new JButton(textButton);
		button.setActionCommand(id);
		button.addActionListener(story);
		button.setBackground(Color.BLACK);
		button.setForeground(Color.WHITE);
		button.setFont(fontButtonText);
		Rectangle bounds = new Rectangle(buttonX, height/2+300, buttonWidth, buttonHeight);
		button.setBounds(bounds);
		return button;
	}

}
