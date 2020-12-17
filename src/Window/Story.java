package Window;

import Combat.CombatUI;
import Combat.Player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Story implements ActionListener {

	private final TravelUI travelUi;
	protected CombatUI combatUI = new CombatUI();
	protected int level = 0;
	protected Player player = combatUI.player;

	public Story (TravelUI travelUi) {
		this.travelUi = travelUi;
		System.out.println("Antes da house" + player.getHP());
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String chosen = event.getActionCommand();
		switch(travelUi.position) {
			case "entrance" :
				switch (chosen) {
					case "b1" : break;
					case "b2" : combatUI.updateCombatUI(travelUi.window, "background.jpg"); break; /*Inimigo 100%*/
					case "b3" : break;
					case "b4" : break; /*Fim do Jogo 100%*/
					case "b5" : break;
				}
				level++;
				break;

			case "house":
				switch (chosen){
					case "b2" : player.setHP(player.getHP()+3); break; /*Receber vida*/
					case "b4" : break;
				}
				level++;
				break;

			case "distantVoices":
				switch (chosen){
					case "b1" : combatUI.updateCombatUI(travelUi.window, "background.jpg"); break; /*100% inimigo*/
					case "b3" : break;
					case "b5" : break;
				}
				level++;
				break;
		}
	}

	private void chooseEvent(){
		//binomial to know if there is an enemy
		//if there is one, triangular to determine which enemy

	}

	//Events:
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