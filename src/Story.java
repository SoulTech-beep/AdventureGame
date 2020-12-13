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
	
	
	
}
