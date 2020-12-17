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
					case "b1" : chooseEvent("");break;
					case "b2" : combatUI.updateCombatUI(travelUi.window, "background.jpg"); break; /*Inimigo 100%*/
					case "b3" : unicorn(); break;
					case "b4" : gameOver("Wuss. The forest swalled you whole.");break; /*Fim do Jogo 100%*/
					case "b5" : break;
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
					case "b2" : break; //100% inimigo
					case "b3" : break; //20% of an enemy
					case "b4" : gameOver("What kinda monster kills a unicorn?! You were instantly swallowed by the forest"); break; //Game over
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
		//binomial to know if there is an enemy
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
		String tb2 = "INVESTIGATE"; //G
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