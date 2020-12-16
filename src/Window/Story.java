package Window;

import Combat.CombatUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Story implements ActionListener {

	private final TravelUI travelUi;
	private final CombatUI cb = new CombatUI();
	protected CombatUI combatUI = new CombatUI();


	public Story (TravelUI travelUi) {
		this.travelUi = travelUi;
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		String chosen = event.getActionCommand();
		switch(travelUi.position) {
			case "mainHall" :
				switch (chosen) {
					case "b1" : break;
					case "b2" :
						dungeonEntrance("You are now in the dungeons of the castle.");
						break;
					case "b3" : break;
					case "b4" : break;
					case "b5" : break;
				}
				break;

			case "dungeonEntrance":
				switch (chosen){
					case "b2": break;
					case "b3":
						shrine("You are now at the shrine.");
						break;
					case "b4":
						mainHall("You are now in the main hall.");
						break;
				}
				break;

			case "shrine":
				switch (chosen){
					case "b1": break;
					case "b2":
						dungeonEntrance("You came back to the dungeons");
						break;
				}
				break;
		}
	}


	private void mainHall(String mainText){
		String position = "mainHall";
		String tb1 = "DINING HALL";
		String tb2 = "DUNGEON";
		String tb3 = "UP THE STAIRS";
		String tb4 = "BATHROOM";
		String tb5 = "THRONE ROOM";
		String background = "mainHall.jpg";
		changePosition(position, mainText, tb1, tb2, tb3, tb4, tb5, background, null);
	}

	private void dungeonEntrance(String mainText){
//		cb.createCombatUI(travelUi.Window, backgroundPanel);
		String position = "dungeonEntrance";
		String tb2 = "ALCHEMY ROOM";
		String tb3 = "SHRINE";
		String tb4 = "GO BACK";
		String background = "dungeonEntrance.jpg";
		changePosition(position, mainText, null, tb2, tb3, tb4, null,  background, null);
	}

	private void shrine(String mainText){
		String position = "shrine";
		String tb1 = "SPECIAL ROOM";
		String tb2 = "GO BACK";
		String background = "shrine.jpg";
		changePosition(position, mainText, tb1, tb2, null, null, null, background, null);
	}


	public void changePosition(String position, String mainText, String textButton1, String textButton2, String textButton3, String textButton4, String textButton5, String background, String textSong) {
		travelUi.mainText.setText(mainText);
		travelUi.position = position;
		travelUi.setBackground(background);
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
		combatUI.updateCombatUI(travelUi.window, background);


	}

}