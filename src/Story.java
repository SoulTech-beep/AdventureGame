import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Story implements ActionListener {

	private final UI ui;

	public Story (UI ui) {
		this.ui=ui;
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		String chosen = event.getActionCommand();
		switch(ui.position) {
			case "mainHall" :
				switch (chosen) {
					case "b1" : break;
					case "b2" :
						dungeonEntrance("You are now in the entrance of the Dungeon of the castle");
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
						shrine("You are now at the shrine");
						break;
					case "b4":
						mainHall("You are now at the main hall");
						break;
				}
				break;

			case "shrine":
				switch (chosen){
					case "b1": break;
					case "b2":
						dungeonEntrance("You came back to the Dungeon");
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
		ui.mainText.setText(mainText);
		ui.position = position;
		if(textButton1 != null) {
			ui.bt1.setText(textButton1);
			ui.bt1.setVisible(true);
		}else{ui.bt1.setVisible(false);}

		if(textButton2 != null) {
			ui.bt2.setText(textButton2);
			ui.bt2.setVisible(true);
		}else{ui.bt2.setVisible(false);}

		if(textButton3 != null) {
			ui.bt3.setText(textButton3);
			ui.bt3.setVisible(true);
		}else{ui.bt3.setVisible(false);}

		if(textButton4 != null) {
			ui.bt4.setText(textButton4);
			ui.bt4.setVisible(true);
		}else{ui.bt4.setVisible(false);}

		if(textButton5 != null) {
			ui.bt5.setText(textButton5);
			ui.bt5.setVisible(true);
		}else{ui.bt5.setVisible(false);}

		if(textSong != null) {
			ui.setSong(textSong);
		}
		ui.setBackground(background);
	}



	/*Modelo
	* 	String position = "";
		String text = "";
		String ch1 = "";
		String ch2 = "";
		String ch3 = "";
		String ch4 = "";
		String ch5 = "";
		String background = "";
		changePosition(position, text, ch1, ch2, ch3, ch4, ch5, background);
		* */

}