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
					case "c1" : break;
					case "c2" : break;
					case "c3" : break;
				}
		}
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




}