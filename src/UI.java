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
	protected Song song;
	protected String position;
	private Font font = new Font ("Times New Roman", Font.PLAIN, 24);
	protected JTextArea textArea;
	protected JButton ch1, ch2, ch3;
	protected Story story = new Story (this);

	public void createUI() {
		//Frame and Background
		frameCreate();

		//Story
		castleEntrance();

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

	private void castleEntrance() {
		//Define Player's Position with String
		position = "castleEntrance";

		//Main Text
		textArea = new JTextArea("Hello World");
		textArea.setLineWrap(true);
		textArea.setFont(font);
		textArea.setBounds(100, height/2+170, 1000, 100);
		textArea.setBackground(null);
		textArea.setForeground(Color.BLACK);
		textArea.setEditable(false);
		frame.add(textArea);

		//Option One
		ch1 = new JButton("Door on the left");
		ch1.setActionCommand("c1");
		ch1.addActionListener(story);
		ch1.setBackground(Color.BLACK);
		ch1.setForeground(Color.WHITE);
		ch1.setFont(font);
		ch1.setBounds(100, height/2+300, 333, 50);
		frame.add(ch1);

		//Option Two
		ch2 = new JButton("Up the stairs");
		ch2.setActionCommand("c2");
		ch2.addActionListener(story);
		ch2.setBackground(Color.BLACK);
		ch2.setForeground(Color.WHITE);
		ch2.setFont(font);
		ch2.setBounds(435, height/2+300, 334, 50);
		frame.add(ch2);


		//Option Three
		ch3 = new JButton("Door on the right");
		ch3.setActionCommand("c3");
		ch3.addActionListener(story);
		ch3.setBackground(Color.BLACK);
		ch3.setForeground(Color.WHITE);
		ch3.setFont(font);
		ch3.setBounds(771, height/2+300, 333, 50);
		frame.add(ch3);

	}

}
