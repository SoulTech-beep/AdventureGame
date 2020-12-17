package Combat;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import Auxiliary.*;
import Window.Story;

public class CombatUI {
    private Enemy enemy;
    public Player player;

    private JFrame window;
    private int windowWidth = 1200;
    private int windowHeight = 907;

    private int buttonWidth = 180;
    private int buttonHeight = 50;


    protected ImagePanel backgroundPanel = new ImagePanel();
    protected Song song;

    //CombatInterface
    protected JTextArea combatText;
    protected JButton btRun, btAttack;
    protected JTextArea textPlayerHealth, textPlayerDamage, textEnemyHealth, textEnemyDamage;

    //if true, player can run away
    private Boolean run = true;
    private Story story;


    public CombatUI(){
        player = new Player();
        enemy = new Enemy();
    }

    public void updateCombatUI(JFrame window, Story story) {
        this.story = story;
        //Create Frame
		this.window = window;
		setBackground("background.jpg");
        song = new Song("game.wav");
        enemy.updateEnemy("demonKing", 2, 10);
        setCombatInterface();
        setEnemy();
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


        ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("Images/Enemies/" + enemy.getName() + ".png")));
        System.out.println(img);
        JLabel enemyLabel = new JLabel();
        enemyLabel.setBounds(windowWidth/2-300,windowHeight/2-300,600,600);
        enemyLabel.setIcon(img);
        window.add(enemyLabel);
        //Visual



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
        textPlayerDamage.setForeground(Color.BLUE);
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

        //EnemyDamage
        textEnemyDamage = new JTextArea("DAMAGE: " + enemy.getDamage());
        System.out.println("Class CombatUI =" + enemy.getDamage());
        textEnemyDamage.setFont(Auxiliary.HealthBarFont);
        textEnemyDamage.setBounds(800, 610 , buttonWidth, 30);
        textEnemyDamage.setOpaque(false);
        textEnemyDamage.setForeground(Color.BLUE);
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
                story.chooseEvent("");

            }

            //Enemy attacks Player
            player.setHP( player.getHP() - enemy.getDamage() );
            textPlayerHealth.setText("HEALTH: " + player.getHP());

            if(player.getHP() <= 0){
                story.chooseEvent("");
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


