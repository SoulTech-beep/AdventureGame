import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Story implements ActionListener {

	private UI ui;

	public Story (UI ui) {
		this.ui=ui;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String chosen = event.getActionCommand();
		switch(ui.position) {
			case "castleEntrance" :
				switch (chosen) {
					case "c1" : dungeonsEntrance(); break;
					case "c2" : break;
					case "c3" : break;
				}
			case "dungeonEntrance":
				switch (chosen){
					case "c1": break;
					case "c2": break;
					case "c3": castleEntranceAgain(); break;
				}
		}
	}

	private void dungeonsEntrance(){
		String position = "dungeonEntrance";
		String text = "You are now in the entrance to the dungeons of the castle";
		String ch1 = "Go up";
		String ch2 = "Go down";
		String ch3 = "Go back";
		String background = "b1.jpg";
		changePosition(position, text, ch1, ch2, ch3, background);
	}

	private void castleEntranceAgain(){
		String position = "castleEntrance";
		String text = "You are now at the entrance of the castle";
		String ch1 = "Go left";
		String ch2 = "Go up the stairs";
		String ch3 = "Go right";
		String background = "b0.jpg";
		changePosition(position, text, ch1, ch2, ch3, background);
	}


	public void changePosition(String position, String text, String ch1, String ch2, String ch3, String background) {
		ui.textArea.setText(text);
		ui.position = position;
		ui.ch1.setText(ch1);
		ui.ch2.setText(ch2);
		ui.ch3.setText(ch3);
		ui.setBackground(background);
	}

	public void changePosition(String position, String text, String ch1, String ch2, String ch3, String background, String song) {
		ui.textArea.setText(text);
		ui.position = position;
		ui.ch1.setText(ch1);
		ui.ch2.setText(ch2);
		ui.ch3.setText(ch3);
		ui.setBackground(background);
		ui.setSong(song);
	}


	/*Modelo
	* 	String position = "";
		String text = "";
		String ch1 = "";
		String ch2 = "";
		String ch3 = "";
		String background = "";
		changePosition(position, text, ch1, ch2, ch3, background);
		* */

}