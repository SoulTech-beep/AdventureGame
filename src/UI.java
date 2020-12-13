import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
public class UI {

	private JFrame frame;
	private int width;
	private int height;
	private Font font = new Font ("Times New Roman", Font.PLAIN, 24);

	protected Image image;
	protected ImagePanel imagePanel;
	protected Song song;
	protected String position;
	protected JTextArea mainTextArea;
	protected JButton ch1, ch2, ch3;
	protected Story story = new Story (this);



	public void createUI() {
		//Frame and Background
		frame = new JFrame ("Castle Adventure");
		frame.setLayout(null);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.BLACK);
		imagePanel = new ImagePanel();
		setBackground("backgrounds/b0.jpg");
		imagePanel.setBounds(0,0, width,height);
		frame.setSize(width,height);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) dimension.getWidth()/2 - width/2;
		int y = (int) dimension.getHeight()/2 - height/2;
		frame.setLocation(x, y); 
		frame.setResizable(false);
		
		
		//Story
		newPosition("castleEntrance","Hello World", "Door on the left","Up the stairs", "Door on the right");

				
		//Song
		song = new Song ("songs/s0.wav");
		song.start();
		song.loop();
		
		frame.setVisible(true);
	}
	
	public void setBackground(String name) {
		ImageIcon img = new ImageIcon(getClass().getClassLoader().getResource(name));
		width = img.getIconWidth();
		height = img.getIconHeight();
		image = img.getImage();
		imagePanel.setImage(image);
		frame.setContentPane(imagePanel);
	}
	
	private void newPosition(String position, String mainText, String optOneText, String optTwoText, String optThreeText){
		this.position = position;

		//Main Text
		mainTextArea = new JTextArea(mainText);
		mainTextArea.setLineWrap(true);
		mainTextArea.setFont(font);
		mainTextArea.setBounds(100, height/2+170, 1000, 100);
		mainTextArea.setBackground(null);
		mainTextArea.setForeground(Color.BLACK);
		mainTextArea.setEditable(false);
		frame.add(mainTextArea);

		//Option One
		ch1 = new JButton(optOneText);
		ch1.setActionCommand("c1");
		ch1.addActionListener(story);
		ch1.setBackground(Color.BLACK);
		ch1.setForeground(Color.WHITE);
		ch1.setFont(font);
		ch1.setBounds(100, height/2+300, 333, 50);
		frame.add(ch1);
		story.actionPerformed(ch1.getAction());

		//Option Two
		ch2 = new JButton(optTwoText);
		ch2.setActionCommand("c2");
		ch2.addActionListener(story);
		ch2.setBackground(Color.BLACK);
		ch2.setForeground(Color.WHITE);
		ch2.setFont(font);
		ch2.setBounds(435, height/2+300, 334, 50);
		frame.add(ch2);


		//Option Three
		ch3 = new JButton(optThreeText);
		ch3.setActionCommand("c3");
		ch3.addActionListener(story);
		ch3.setBackground(Color.BLACK);
		ch3.setForeground(Color.WHITE);
		ch3.setFont(font);
		ch3.setBounds(771, height/2+300, 333, 50);
		frame.add(ch3);
	}

	public class SomethingHandler implements ActionListener {
		public void actionPerformed
	}
}
