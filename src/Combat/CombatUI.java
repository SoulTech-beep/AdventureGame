package Combat;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import Auxiliary.*;

public class CombatUI {
    private Enemy enemy;
    private Player player;

    private JFrame window;
    private int windowWidth = 1200;
    private int windowHeight = 907;

    private int buttonWidth = 180;
    private int buttonHeight = 50;


    protected ImagePanel backgroundPanel = new ImagePanel();
    protected EnemyPanel enemyPanel = new EnemyPanel();
    protected Song song;

    //CombatInterface
    protected JTextArea combatText;
    protected JButton btRun, btAttack;
    protected JTextArea textPlayerHealth, textPlayerDamage, textEnemyHealth, textEnemyDamage;

    //if true, player can run away
    private Boolean run = true;


    public CombatUI(){
        player = new Player();
        enemy = new Enemy();
    }

    public void updateCombatUI(JFrame window, String nameBackground) {

        //Create Frame
		this.window = window;

		setBackground(nameBackground);
        setEnemy();


        song = new Song("s0.wav");

        setCombatInterface();

    }


    private void setBackground(String name) {
        ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("Images/Backgrounds/" + name)));
        windowWidth = img.getIconWidth();
        windowHeight = img.getIconHeight();
        Image image = img.getImage();
        backgroundPanel.setImage(image);
        backgroundPanel.setBounds(0,0, windowWidth, windowHeight);
        window.setContentPane(backgroundPanel);
    }

    private void setEnemy(){
        //TODO make this random

        enemy.updateEnemy("demonKing", 2, 10);


        //Visual
        ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("Images/Enemies/" + enemy.getName() + ".png")));
        Image image = img.getImage();
        System.out.println(img);
        enemyPanel.setImage(image);
        enemyPanel.setBounds(600,0, 600, 600);
        window.setContentPane(enemyPanel);


    }


    public void setCombatInterface() {
        //TODO FAZER JPANEL E O ICON COM A IMAGE



        //playerHealth
        textPlayerHealth = new JTextArea("HEALTH: " + player.getHP());
        textPlayerHealth.setFont(Auxiliary.HealthBarFont);
        textPlayerHealth.setBounds(100, windowHeight /2+210, buttonWidth, 30);
        textPlayerHealth.setOpaque(false);
        textPlayerHealth.setForeground(Color.RED);
        textPlayerHealth.setEditable(false);
        window.add(textPlayerHealth);

        //playerDamage
        textPlayerDamage = new JTextArea("DAMAGE: " + player.getDamage());
        textPlayerDamage.setFont(Auxiliary.HealthBarFont);
        textPlayerDamage.setBounds(300, windowHeight /2+210, buttonWidth, 30);
        textPlayerDamage.setOpaque(false);
        textPlayerDamage.setForeground(Color.BLACK);
        textPlayerDamage.setEditable(false);
        window.add(textPlayerDamage);

        //EnemyHealth
        textEnemyHealth = new JTextArea("HEALTH: " + enemy.getHP());
        textEnemyHealth.setFont(Auxiliary.HealthBarFont);
        textEnemyHealth.setBounds(600, 610 , buttonWidth, 30);
        textEnemyHealth.setOpaque(false);
        textEnemyHealth.setForeground(Color.RED);
        textEnemyHealth.setEditable(false);
        window.add(textEnemyHealth);

        //playerDamage
        textEnemyDamage = new JTextArea("DAMAGE: " + enemy.getDamage());
        textEnemyDamage.setFont(Auxiliary.HealthBarFont);
        textEnemyDamage.setBounds(800, 610 , buttonWidth, 30);
        textEnemyDamage.setOpaque(false);
        textEnemyDamage.setForeground(Color.BLACK);
        textEnemyDamage.setEditable(false);
        window.add(textEnemyDamage);

        //CombatText
        combatText = new JTextArea("FIGHT FIGHT FIGHT FIGHT!!");
        combatText.setLineWrap(true);
        combatText.setFont(Auxiliary.mainFont);
        combatText.setBounds(100, windowHeight /2+240, 1000-buttonWidth-20, 110);
        combatText.setBackground(null);
        combatText.setForeground(Color.BLACK);
        combatText.setEditable(false);
        window.add(combatText);

        // Buttons
        btAttack = setButton("ATTACK", windowHeight /2+240);
        clickedAttack();
        window.add(btAttack);
        btRun = setButton("RUN",  windowHeight /2+300);
        clickedRun();
        window.add(btRun);

    }

    private JButton setButton(String textButton, int buttonY){
        JButton button = new JButton(textButton);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setFont(Auxiliary.buttonFont);
        Rectangle bounds = new Rectangle(1100 - buttonWidth, buttonY, buttonWidth, buttonHeight);
        button.setBounds(bounds);
        return button;
    }


    private void clickedAttack(){
        btAttack.addActionListener(e -> {
            //Player attacks Enemy
            enemy.setHP( enemy.getHP() - player.getDamage() );
            textEnemyHealth.setText("HEALTH: " + enemy.getHP());

            if(enemy.getHP() <= 0){
                //TODO ACABAR COMBATUI
            }

            //Enemy attacks Player
            player.setHP( player.getHP() - enemy.getDamage() );
            textPlayerHealth.setText("HEALTH: " + player.getHP());

            if(player.getHP() <= 0){
                //TODO gameover
            }
        });
    }

    private void clickedRun(){
        btAttack.addActionListener(e -> {
            //Player trys to run
//            if(run)
//                //run away //TODO ACABAR COMBATUI
//            else
//                //Enemy attacks Player
//                player.setHP( player.getHP() - enemy.getDamage() );
        });
    }







}

/*
* import Auxiliary.Auxiliary;

import java.awt.*;
import java.util.Objects;
import javax.swing.*;
import Auxiliary.ImagePanel;
import Combat.CombatUI;

public class Window.TravelUI {

	protected JFrame Window;
	private int windowWidth;
	private int windowHeight;
	private int buttonWidth = 180;
	private int buttonHeight = 50;
	protected Image image;
	protected ImagePanel backgroundPanel = new ImagePanel();
	protected Auxiliary.Song song;
	protected String position;
	protected JTextArea mainText;
	protected JButton bt1, bt2, bt3, bt4, bt5;
	protected Window.Story story = new Window.Story (this);


	public void createTravelUI(JFrame Window) {
		//Create Frame
		this.Window = Window;
		setBackground("mainHall.jpg");
		backgroundPanel.setBounds(0,0, windowWidth, windowHeight);

		//Set position
		mainHall();



		//Set song
		setSong("s0.wav");

		//Window.setVisible(true);
	}




	public void setSong(String songLink) {
		song = new Auxiliary.Song ("Sound/" + songLink);
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
		Window.add(mainText);

		// Buttons
		bt1 = setButton("DINING HALL", "b1", 100);
		Window.add(bt1);
		bt2 = setButton("DUNGEON", "b2", (100 + buttonWidth + windowWidth / 2 - buttonWidth / 2) / 2 - buttonWidth / 2);
		Window.add(bt2);
		bt3 = setButton("UP THE STAIRS", "b3", windowWidth / 2 - buttonWidth / 2);
		Window.add(bt3);
		bt4 = setButton("BATHROOM", "b4", (windowWidth / 2 + buttonWidth / 2 + 1100 - buttonWidth) / 2 - buttonWidth / 2);
		Window.add(bt4);
		bt5 = setButton("THRONE ROOM", "b5", 1100 - buttonWidth);
		Window.add(bt5);
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
	*
	* public void setBackground(String name) {
		ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("Images/Backgrounds/" + name)));
		windowWidth = img.getIconWidth();
		windowHeight = img.getIconHeight();
		image = img.getImage();
		backgroundPanel.setImage(image);
		Window.setContentPane(backgroundPanel);
	}

}

* */
