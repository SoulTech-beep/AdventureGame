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
					case "c1" : break;
					case "c2" : dungeonEntrance(); break;
					case "c3" : break;
					case "c4":  break;
					case "c5" : break;
				}
			case "dungeonEntrance":
				switch (chosen){
					case "c1": break;
					case "c2": break;
					case "c3": shrine(); break;
					case "c4": mainHallAgain(); break;
					case "c5": break;
				}
		}
	}

	private void dungeonEntrance(){
		String position = "dungeonEntrance";
		String text = "You are now in the entrance of the dungeons of the castle";
		String ch2 = "ALCHEMY ROOM";
		String ch3 = "SHRINE";
		String ch4 = "GO BACK";
		String background = "b1.jpg";
		changePosition(position, text, ch2, ch3, ch4, background);
	}

	private void mainHallAgain(){
		String position = "mainHall";
		String text = "You are now at the main hall";
		String ch1 = "DINING HALL";
		String ch2 = "DUNGEONS";
		String ch3 = "UP THE STAIRS";
		String ch4 = "BATHROOM";
		String ch5 = "THRONE ROOM";
		String background = "b0.jpg";
		changePosition(position, text, ch1, ch2, ch3, ch4, ch5, background);
	}

	private void shrine(){
		String position = "shrine";
		String text = "You are now at the shrine";
		String ch1 = "DUNGEONS";
		String ch2 = "STAFF ROOM";
		String ch3 = "UP THE STAIRS";
		String ch4 = "BATHROOM";
		String ch5 = "MAIN HALL";
		String background = "b2.jpg";
		changePosition(position, text, ch1, ch2, ch3, ch4, ch5, background);
	}


	public void changePosition(String position, String text, String ch1, String ch2, String ch3, String ch4, String ch5, String background) {
		ui.textArea.setText(text);
		ui.position = position;
		ui.ch1.setText(ch1);
		ui.ch1.setVisible(true);
		ui.ch2.setText(ch2);
		ui.ch2.setVisible(true);
		ui.ch3.setText(ch3);
		ui.ch3.setVisible(true);
		ui.ch4.setText(ch4);
		ui.ch4.setVisible(true);
		ui.ch5.setText(ch5);
		ui.ch5.setVisible(true);
		ui.setBackground(background);
	}

	public void changePosition(String position, String text, String ch1, String ch2, String ch3, String ch4, String ch5, String background, String song) {
		ui.textArea.setText(text);
		ui.position = position;
		ui.ch1.setText(ch1);
		ui.ch2.setText(ch2);
		ui.ch3.setText(ch3);
		ui.ch4.setText(ch4);
		ui.ch5.setText(ch5);
		ui.setBackground(background);
		ui.setSong(song);
	}

	public void changePosition(String position, String text, String ch2, String ch3, String ch4, String background) {
		ui.textArea.setText(text);
		ui.position = position;
		ui.ch1.setVisible(false);
		ui.ch2.setText(ch2);
		ui.ch3.setText(ch3);
		ui.ch4.setText(ch4);
		ui.ch5.setVisible(false);
		ui.setBackground(background);
	}

	public void changePosition(String position, String text, String ch2, String ch3, String ch4, String background, String song) {
		ui.textArea.setText(text);
		ui.position = position;
		ui.ch1.setVisible(false);
		ui.ch2.setText(ch2);
		ui.ch3.setText(ch3);
		ui.ch4.setText(ch4);
		ui.ch5.setVisible(false);
		ui.setBackground(background);
		ui.setSong(song);
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