package Window;

import Combat.CombatUI;
import Combat.Player;
import Auxiliary.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Story implements ActionListener {

	private final TravelUI travelUi;
	protected CombatUI combatUI = new CombatUI();
	protected int level = 0;
	private static final int FINALLEVEL = 7;
	protected Player player = combatUI.player;
	private int n = 7;
	private int k = 0;
	private double p = 0.2;
	private Functions fun = new Functions();

	public Story (TravelUI travelUi) {
		this.travelUi = travelUi;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String chosen = event.getActionCommand();
		switch(travelUi.position) {
			case "entrance" :
				switch (chosen) {
					case "b1" : break;
					case "b2" : combatUI.updateCombatUI(travelUi.window, "background.jpg"); break; /*Inimigo 100%*/
					case "b3" : snake2(); break;
					case "b4" : gameOver("Wuss. The forest swalled you whole.");break; /*Fim do Jogo 100%*/
					case "b5" : snake1(); break;
				}
				level++;
				break;

			case "house":
				switch (chosen){
					case "b2" : player.setHP(player.getHP()+3); chooseEvent("You find some potions inside that give you +3 HP"); break; /*Receber vida*/
					case "b4" : chooseEvent(null); break;
				}
				level++;
				break;

			case "distantVoices":
				switch (chosen){
					case "b1" : combatUI.updateCombatUI(travelUi.window, "background.jpg"); break;  //100% inimigo
					case "b3" : break; //20% of an enemy
					case "b5" : break; //random variable: higher player level, higher the probability of success

				}
				level++;
				break;

			case "unicorn":
				switch (chosen){
					case "b2" : player.setHP(player.getHP()+5); break;
					case "b3" : break; //?% of an enemy
					case "b4" : gameOver("What kinda monster kills a unicorn?! You were instantly swallowed by the forest"); break; //Game over
				}
				level++;
				break;

			case "hole":
				switch (chosen){
					case "b2" : break; //the higher the level, the more likely you are to jump over it
					case "b4" : break; //random chance of facing an enemy
				}
				level++;
				break;

			case "sword":
				switch (chosen){
					case "b2" : player.setDamage(player.getDamage()+4);break; //the higher the level, the more likely you are to jump over it
					case "b4" : break; //random chance of facing an enemy
				}
				level++;
				break;

			case "snake1":
				switch (chosen){
					case "b1" : gameOver("Wrong answer! The snake killed you mere seconds."); break;
					case "b2" : player.setDamage(player.getDamage()+1); break;
					case "b3" : gameOver("Wrong answer! The snake killed you mere seconds.");  break;
					case "b4" : gameOver("Wrong answer! The snake killed you mere seconds.");  break;
					case "b5" : gameOver("Wrong answer! The snake killed you mere seconds.");  break;
				}
				level++;
				break;

			case "snake2":
				switch (chosen){
					case "b1" : gameOver("Wrong answer! The snake killed you mere seconds."); break;
					case "b2" : gameOver("Wrong answer! The snake killed you mere seconds.");  break;
					case "b3" : gameOver("Wrong answer! The snake killed you mere seconds.");  break;
					case "b4" : player.setDamage(player.getDamage()+1); break;
					case "b5" : gameOver("Wrong answer! The snake killed you mere seconds.");  break;
				}
				level++;
				break;

			case "gameOver":
				switch (chosen){
					case "b2" : break; //Main Menu
					case "b4" : entrance(); break; //Game over
				}
				break;

		}
	}

	private void chooseEvent(String text){
		//the higher the player level, the more probability of facing an enemy; the lesser the level, the less probability of facing
		System.out.println("p = " + p);
		double bin = fun.binomial(n,k,p);
		System.out.println(bin);
		if (bin<0.2){
			//doesn't face


		}
		else{
			//faces

			k++;
		}

		//if there is one, triangular to determine which enemy
		//if there is not one, choose a random event
		//if event has already been done, change

	}

	//Events:
	private void entrance(){
		level = 0;
		String mainText = "You awaken inside a dark and creepy forest. You must find a way to escape. Which way do you go?";
		String position = "entrance";
		String tb1 = "GO LEFT";
		String tb2 = "CALL FOR HELP";
		String tb3 = "GO FORWARD";
		String tb4 = "CRY";
		String tb5 = "GO RIGHT";
		String background = "background.jpg";
		String songLink = "game.wav";
		changePosition(position, mainText, tb1, tb2, tb3, tb4, tb5, songLink, background);

	}

	private void house(){
		String mainText = "You come across a house. It appears to be abandoned. What do you do?";
		String position = "house";
		String tb2 = "INVESTIGATE";
		String tb4 = "KEEP MOVING";
		String background = "house.jpg";
		changePosition(position, mainText, null, tb2, null, tb4, null, null, background);
	}

	private void distantVoices(){
		String mainText = "You hear voices in distance. Could they be friendly? What do you do?";
		String position = "distantVoices";
		String tb1 = "INVESTIGATE";
		String tb3 = "GO AROUND";
		String tb5 = "HIDE AND WAIT";
		String background = "background.jpg";
		changePosition(position, mainText, tb1, null, tb3, null, tb5, null, background);
	}

	private void unicorn(){
		String mainText = "You come across a unicorn. It looks friendly. What do you do?";
		String position = "unicorn";
		String tb2 = "PET HIM";
		String tb3 = "KEEP MOVING";
		String tb4 = "KILL HIM";
		String background = "unicorn.jpg";
		String songLink = "unicorn.wav";
		changePosition(position, mainText, null, tb2, tb3, tb4, null, songLink, background);
	}

	private void hole(){
		String mainText = "You come across a giant hole in the ground. You're unsure if you're able to jump over it or not. What do you do?";
		String position = "hole";
		String tb2 = "ATTEMPT TO JUMP";
		String tb4 = "GO AROUND";
		String background = "background.jpg";;
		changePosition(position, mainText, null, tb2, null, tb4, null, null, background);
	}

	private void sword(){
		String mainText = "You come across a sword stuck inside a large stone. What do you do?";
		String position = "sword";
		String tb2 = "ATTEMPT TO PULL SWORD";
		String tb4 = "KEEP MOVING";
		String background = "background.jpg";
		changePosition(position, mainText, null, tb2, null, tb4, null, null, background);
	}

	private void snake1(){
		String mainText = "A giant snake shows up and tells you that she will only let you pass if you answer her riddle correctly.  Her riddle is: I have seas with no water, coast with no sand, towns without people, mountains without    land. What am I?";
		String position = "snake1";
		String tb1 = "MOON";
		String tb2 = "MAP";
		String tb3 = "DREAM";
		String tb4 = "IDEA";
		String tb5 = "BOAT";
		String background = "snake.jpg";
		changePosition(position, mainText, tb1, tb2, tb3, tb4, tb5, null, background);
	}

	private void snake2(){
		String mainText = "A giant snake shows up and tells you that she will only let you pass if you answer her riddle correctly.  Her riddle is: Often will I spin a tale, never will I charge a fee. I'll amuse you an entire eve, but, alas you wont remember me. What am I?";
		String position = "snake1";
		String tb1 = "LIAR";
		String tb2 = "MUSIC";
		String tb3 = "BOOK";
		String tb4 = "DREAM";
		String tb5 = "SPIDER";
		String background = "snake.jpg";
		changePosition(position, mainText, tb1, tb2, tb3, tb4, tb5, null, background);
	}

	private void gameOver(String text){
		String position = "gameOver";
		String tb2 = "MAIN MENU";
		String tb4 = "RESTART";
		String background = "gameOver.jpg";
		changePosition(position, text, null, tb2, null, tb4, null, null, background);
	}




	public void changePosition(String position, String mainText, String textButton1, String textButton2, String textButton3, String textButton4, String textButton5, String textSong, String background) {
		travelUi.mainText.setText(mainText);
		travelUi.setBackground(background);
		travelUi.position = position;
		if(textButton1 != null) {
			travelUi.bt1.setText(textButton1);
			travelUi.bt1.setVisible(true);
		}else{
			travelUi.bt1.setVisible(false);}

		if(textButton2 != null) {
			travelUi.bt2.setText(textButton2);
			travelUi.bt2.setVisible(true);
		}else{
			travelUi.bt2.setVisible(false);}

		if(textButton3 != null) {
			travelUi.bt3.setText(textButton3);
			travelUi.bt3.setVisible(true);
		}else{
			travelUi.bt3.setVisible(false);}

		if(textButton4 != null) {
			travelUi.bt4.setText(textButton4);
			travelUi.bt4.setVisible(true);
		}else{
			travelUi.bt4.setVisible(false);}

		if(textButton5 != null) {
			travelUi.bt5.setText(textButton5);
			travelUi.bt5.setVisible(true);
		}else{
			travelUi.bt5.setVisible(false);}

		if(textSong != null) {
			travelUi.song.stop();
			travelUi.song.updateSong(textSong);
		}


	}

	/*	private void mainHall(String mainText){
		String position = "mainHall";
		String tb1 = "DINING HALL";
		String tb2 = "DUNGEON";
		String tb3 = "UP THE STAIRS";
		String tb4 = "BATHROOM";
		String tb5 = "THRONE ROOM";
		String background = "mainHall.jpg";
		changePosition(position, mainText, tb1, tb2, tb3, tb4, tb5, background, null);
	}

*/



}