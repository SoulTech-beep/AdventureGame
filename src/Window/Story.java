package Window;

import Combat.CombatUI;
import Combat.Player;
import Auxiliary.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;


public class Story implements ActionListener {

    private final TravelUI travelUi;
    protected CombatUI combatUI = new CombatUI();
    private int level = 0;
    private static final int FINALLEVEL = 6;
    protected Player player = combatUI.player;
    private Functions fun = new Functions();
    private ArrayList<Integer> usedEvents = new ArrayList<Integer>();

    public Story(TravelUI travelUi) {
        this.travelUi = travelUi;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String chosen = event.getActionCommand();
        switch (travelUi.position) {
            case "entrance":
                switch (chosen) {
                    case "b1":
                        chooseEvent("", false);
                        break;
                    case "b2":
                        goToCombatUI(travelUi.window, this, "bat");
                        break; /*Inimigo 100%*/
                    case "b3":
                        chooseEvent("", false);
                        break;
                    case "b4":
                        gameOver("Well... What did you expect from doing this?! Of course you died you little chicken!");
                        break;
                    case "b5":
                        chooseEvent("", false);
                        break;
                }
                break;

            case "house":
                switch (chosen) {
                    case "b2":
                        player.setHP(player.getHP() + 3);
                        chooseEvent("You found some potions inside and gained +3 HP. ", false);
                        break; /*Receber vida*/
                    case "b4":
                        run();
                        break;
                }
                break;

            case "distantVoices":
                switch (chosen) {
                    case "b1":
                        goToCombatUI(travelUi.window, this, "bat");
                        break;  //100% inimigo
                    case "b3":
                        run();
                        break; //qto mais baixo o nivel mais facil de bazar
                    case "b5":
                        chooseEvent("The coast is clear. You move ahead. ", true);
                        break;

                }
                break;

            case "unicorn":
                switch (chosen) {
                    case "b2":
                        player.setHP(player.getHP() + 5);
                        chooseEvent("The unicorn gives you +5HP and leaves. ", false);
                        break;
                    case "b3":
                        chooseEvent("", false);
                        break; //?% of an enemy
                    case "b4":
                        gameOver("What kinda monster kills a unicorn?! You were instantly swallowed by the forest");
                        break; //Game over
                }
                break;

            case "hole":
                switch (chosen) {
                    case "b2":
                        holeEvent();
                        break; //the higher the level, the more likely you are to jump over it
                    case "b4":
                        run();
                        break; //random chance of facing an enemy
                }
                break;

            case "sword":
                switch (chosen) {
                    case "b2":
                        pullSword();
                        break;
                    case "b4":
                        chooseEvent("", false);
                        break;
                }
                break;

            case "snake1":
                switch (chosen) {
                    case "b1":
                        gameOver("Wrong answer! The snake killed you mere seconds.");
                        break;
                    case "b2":
                        player.setDamage(player.getDamage() + 1);
                        chooseEvent("The snake lets you pass. You are gifted +1DP. ", false);
                        break;
                    case "b3":
                        gameOver("Wrong answer! The snake killed you mere seconds.");
                        break;
                    case "b4":
                        gameOver("Wrong answer! The snake killed you mere seconds.");
                        break;
                    case "b5":
                        gameOver("Wrong answer! The snake killed you mere seconds.");
                        break;
                }
                break;

            case "snake2":
                switch (chosen) {
                    case "b1":
                        gameOver("Wrong answer! The snake killed you mere seconds.");
                        break;
                    case "b2":
                        gameOver("Wrong answer! The snake killed you mere seconds.");
                        break;
                    case "b3":
                        gameOver("Wrong answer! The snake killed you mere seconds.");
                        break;
                    case "b4":
                        player.setDamage(player.getDamage() + 1);
                        chooseEvent("The snake lets you pass. You are gifted +1DP. ", false);
                        break;
                    case "b5":
                        gameOver("Wrong answer! The snake killed you mere seconds.");
                        break;
                }
                break;

                case "doors":
                switch (chosen) {
                    case "b1":
                        player.setHP(player.getHP() - new Random().nextInt(3 + 1));
                        chooseEvent("The door you chose takes some of your health away ", false);
                        break;
                    case "b2":
                        player.setDamage(player.getDamage() + 3);
                        chooseEvent("The door you chose gives you super strength. You are gifted +3DP. ", false);
                        break;
                    case "b4":
                        randomDoor();
                        break;
                    case "b5":
                        run();
                        break;
                }
                break;

            case "gameOver":
                switch (chosen) {
                    case "b2":
                        break; //Main Menu
                    case "b4":
                        entrance("");
                        break; //Game over
                }
                break;

            case "portal":
                switch (chosen) {
                    case "b2":
                        entrance("Sorry. The portal took you back to the beginning");
                        break;
                    case "b4":
                        run();
                        break; //Game over
                }
                break;

            case "endGame":
                switch (chosen) {
                    case "b2":
                        break; //Main Menu
                    case "b4":
                        entrance("");
                        break; //Game over
                }
                break;
        }
    }

    public void chooseEvent(String text, boolean fromCombatUI) {
        if (level == 7) {
            System.out.println("Finished The Game!");
            endGame();
        } else {

            if (text.equals("gameOver")) {
                gameOver("You have been defeated!");
            } else {
                if (fromCombatUI) {
                    travelUi.song.updateSong("game.wav");
                }

                System.out.println("Level: " + level);
                //the higher the player level, the more probability of facing an enemy; the lesser the level, the less probability of facing
                //binomial to know if there is an enemy
                double bin = fun.binomial(FINALLEVEL, 0.2);
                System.out.println("Binomial Value: " + bin);
                if (bin >= 1.5 && !fromCombatUI) {
                    level++;
                    int tri = (int) fun.triangular(1.0, (double) FINALLEVEL, (double) level);
                    System.out.println("Triangular Value: " + tri);
                    switch (tri){
                        case 0: goToCombatUI(travelUi.window, this, "bat"); break;
                        case 1: goToCombatUI(travelUi.window, this, "imp"); break;
                        case 2: goToCombatUI(travelUi.window, this, "goblin"); break;
                        case 3: goToCombatUI(travelUi.window, this, "knight"); break;
                        case 4: goToCombatUI(travelUi.window, this, "troll"); break;
                        case 5: goToCombatUI(travelUi.window, this, "wraith"); break;
                        case 6: goToCombatUI(travelUi.window, this, "demonKing"); break;
                    }

                } else {
                    //doesn't fight

                    int ratio = 6;
                    int event = new Random().nextInt(7 + 1);
                    while (usedEvents.contains(event)) {
                        event = (int) (Math.random() * ratio);
                    }
                    usedEvents.add(event);
                    switch (event) {
                        case 0:
                            house("");
                            System.out.println("Going to do the house");
                            break;
                        case 1:
                            distantVoices("");
                            System.out.println("Going to do the voices");
                            break;
                        case 2:
                            unicorn("");
                            System.out.println("Going to do unicorn");
                            break;
                        case 3:
                            hole("");
                            System.out.println("Going to do the hole");
                            break;
                        case 4:
                            sword("");
                            System.out.println("Going to do the sword");
                            break;
                        case 5:
                            snake1("");
                            System.out.println("Going to do the snake1");
                            break;
                        case 6:
                            snake2("");
                            System.out.println("Going to do the snake2");
                            break;
                        case 7:
                            doors("");
                            System.out.println("Going to do the doors");
                            break;
                        case 8:
                            portal("");
                            System.out.println("Going to do the portal");
                            break;
                    }


                }
            }
        }
        //if there is one, triangular to determine which enemy
        //if there is not one, choose a random event
        //if event has already been done, change

    }

    public void holeEvent() {
        double exp = fun.exponential(0, level);
        System.out.println("Exponential Value (Hole): " + exp);
        if (exp < level / 2)
            chooseEvent("You managed to jump over the hole", false);
        else
            gameOver("You fell down the hole. Better luck next time pal. ");
    }

    public void pullSword() {
        int bern = fun.bernoulli(0.6);
        if (bern == 1) {
            player.setDamage(player.getDamage() + 4);
            chooseEvent("", false);
        }
        else
            chooseEvent("Unfortunately the sword remained stuck. Good luck next time", false);
    }

    public void randomDoor(){
        int bern = fun.bernoulli(0.1);
        if (bern == 1) {
            endGame();
        }
        else
            gameOver("Wrong door! The door you chose leads straight to hell.");
    }

    //Events:
    private void entrance(String text) {
        String mainText = "You awaken inside a dark and creepy forest. You must find a way to escape. Which way do you go?";
        String position = "entrance";
        String tb1 = "GO LEFT";
        String tb2 = "CALL FOR HELP";
        String tb3 = "GO FORWARD";
        String tb4 = "CRY";
        String tb5 = "GO RIGHT";
        String background = "background.jpg";
        String songLink = "game.wav";
        changePosition(position, text + mainText, tb1, tb2, tb3, tb4, tb5, songLink, background);

    }

    public void house(String text) {
        level++;
        String mainText = "You come across a house. It appears to be abandoned. What do you do?";
        String position = "house";
        String tb2 = "INVESTIGATE";
        String tb4 = "KEEP MOVING";
        String background = "house.jpg";
        changePosition(position, text + mainText, null, tb2, null, tb4, null, null, background);
    }

    public void distantVoices(String text) {
        level++;
        String mainText = "You hear voices in distance. Could they be friendly? What do you do?";
        String position = "distantVoices";
        String tb1 = "INVESTIGATE";
        String tb3 = "GO AROUND";
        String tb5 = "HIDE AND WAIT";
        String background = "background.jpg";
        changePosition(position, text + mainText, tb1, null, tb3, null, tb5, null, background);
    }

    private void unicorn(String text) {
        level++;
        String mainText = "You come across a unicorn. It looks friendly. What do you do?";
        String position = "unicorn";
        String tb2 = "PET HIM";
        String tb3 = "KEEP MOVING";
        String tb4 = "KILL HIM";
        String background = "unicorn.jpg";
        changePosition(position, text + mainText, null, tb2, tb3, tb4, null, null, background);
    }

    private void hole(String text) {
        level++;
        String mainText = "You come across a giant hole in the ground. You're unsure if you're able to jump over it or not. What do you do?";
        String position = "hole";
        String tb2 = "ATTEMPT TO JUMP";
        String tb4 = "GO AROUND";
        String background = "background.jpg";
        ;
        changePosition(position, text + mainText, null, tb2, null, tb4, null, null, background);
    }

    private void sword(String text) {
        level++;
        String mainText = "You come across a sword stuck inside a large stone. What do you do?";
        String position = "sword";
        String tb2 = "PULL SWORD";
        String tb4 = "KEEP MOVING";
        String background = "sword.jpg";
        changePosition(position, text + mainText, null, tb2, null, tb4, null, null, background);
    }

    private void snake1(String text) {
        level++;
        String mainText = "A giant snake shows up and tells you that she will only let you pass if you answer her riddle correctly.  Her riddle is: I have seas with no water, coast with no sand, towns without people, mountains without    land. What am I?";
        String position = "snake1";
        String tb1 = "MOON";
        String tb2 = "MAP";
        String tb3 = "DREAM";
        String tb4 = "IDEA";
        String tb5 = "BOAT";
        String background = "snake.jpg";
        changePosition(position, text + mainText, tb1, tb2, tb3, tb4, tb5, null, background);
    }

    private void snake2(String text) {
        level++;
        String mainText = "A giant snake shows up and tells you that she will only let you pass if you answer her riddle correctly.  Her riddle is: Often will I spin a tale, never will I charge a fee. I'll amuse you an entire eve, but, alas you wont remember me. What am I?";
        String position = "snake2";
        String tb1 = "LIAR";
        String tb2 = "MUSIC";
        String tb3 = "BOOK";
        String tb4 = "DREAM";
        String tb5 = "SPIDER";
        String background = "snake.jpg";
        changePosition(position, text + mainText, tb1, tb2, tb3, tb4, tb5, null, background);
    }

    private void doors(String text){
        level++;
        String mainText = "Three doors appear in front of you. What do you do?";
        String position = "doors";
        String tb1 = "GREEN DOOR";
        String tb2 = "PURPLE DOOR";
        String tb4 = "RED DOOR";
        String tb5 = "GO AROUND";
        String background = "doors.jpg";
        changePosition(position, text + mainText, tb1, tb2, null, tb4, tb5, null, background);
    }

    private void portal(String text){
        level++;
        String mainText = "A mysterious portal opens in front of you. What do you do?";
        String position = "doors";
        String tb2 = "GO THROUGH IT";
        String tb4 = "GO AROUND";
        String background = "portal.jpg";
        changePosition(position, text + mainText, null, tb2, null, tb4, null, null, background);
    }

    public void gameOver(String text) {
        level = 0;
        player.setHP(20);
        player.setDamage(2);
        usedEvents.clear();
        String position = "gameOver";
        String tb2 = "MAIN MENU";
        String tb4 = "RESTART";
        String background = "gameOver.jpg";
        changePosition(position, text, null, tb2, null, tb4, null, null, background);
    }

    public void endGame() {
        level = 0;
        player.setHP(20);
        player.setDamage(2);
        usedEvents.clear();
        String tb2 = "MAIN MENU";
        String tb4 = "RESTART";
        String position = "endGame";
        String background = "endGame.jpg";
        String mainText = "Congratulations! You have reached the end of the forest alive! Hope you enjoyed playing. If you wish   to play again, click the button below to start over!";
        changePosition(position, mainText, null, tb2, null, tb4, null, null, background);
    }


    public void changePosition(String position, String mainText, String textButton1, String textButton2, String textButton3, String textButton4, String textButton5, String textSong, String background) {
        travelUi.mainText.setText(mainText);
        travelUi.setBackground(background);
        travelUi.position = position;
        if (textButton1 != null) {
            travelUi.bt1.setText(textButton1);
            travelUi.bt1.setVisible(true);
        } else {
            travelUi.bt1.setVisible(false);
        }

        if (textButton2 != null) {
            travelUi.bt2.setText(textButton2);
            travelUi.bt2.setVisible(true);
        } else {
            travelUi.bt2.setVisible(false);
        }

        if (textButton3 != null) {
            travelUi.bt3.setText(textButton3);
            travelUi.bt3.setVisible(true);
        } else {
            travelUi.bt3.setVisible(false);
        }

        if (textButton4 != null) {
            travelUi.bt4.setText(textButton4);
            travelUi.bt4.setVisible(true);
        } else {
            travelUi.bt4.setVisible(false);
        }

        if (textButton5 != null) {
            travelUi.bt5.setText(textButton5);
            travelUi.bt5.setVisible(true);
        } else {
            travelUi.bt5.setVisible(false);
        }

        if (textSong != null) {
            travelUi.song.closeSong();
            travelUi.song.updateSong(textSong);
        }

    }

//    public void setLevel(int level) {
//        this.level= level;
//    }

    public Functions getFun() {
        return fun;
    }

    private void run(){
        double exp = fun.exponential(0,level);
        System.out.println("Exponential Value (Story): " + exp);
        if(exp>=level) {
            goToCombatUI(travelUi.window, this, "bat");
        }
        else{
            chooseEvent("", true);
        }
    }


    private void goToCombatUI(JFrame window, Story story, String selectedEnemy) {
        travelUi.song.closeSong();
        combatUI.updateCombatUI(window, story, selectedEnemy);
    }


}