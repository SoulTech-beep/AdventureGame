package Window;

import Combat.CombatUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import static java.lang.Math.log;
import static java.lang.Math.sqrt;

public class Story implements ActionListener {

	private final TravelUI travelUi;
	private final CombatUI cb = new CombatUI();
	protected CombatUI combatUI = new CombatUI();
	protected int level = 0;

	public Story (TravelUI travelUi) {
		this.travelUi = travelUi;
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		String chosen = event.getActionCommand();
		switch(travelUi.position) {
			case "entrance" :
				switch (chosen) {
					case "b1" : chooseEvent(); break;
					case "b2" : /*Inimigo 100%*/break;
					case "b3" : break;
					case "b4" : /*Fim do Jogo 100%*/break;
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
	private void holeInGround (String mainText){
		String position = "holeInGround";
		String tb2 = "TRY TO JUMP OVER";
		String tb4 = "GO AROUND THE HOLE";
		String tb5 = "CALL FOR HELP";
		//changePosition(position, mainText, tb1, tb2, tb3, tb4, tb5, null);
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

	public void changePosition(String position, String mainText, String textButton1, String textButton2, String textButton3, String textButton4, String textButton5, String textSong) {
		travelUi.mainText.setText(mainText);
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
		combatUI.updateCombatUI(travelUi.window, "background.jpg");


	}

	private double uniform(){
		return new Random().nextDouble();
	}

	//Whether or not an enemy shows up
	private double binomial (int n, int k, double p){
		int answer = 1;
		for (int i = 1; i <= k; i++) {
			answer = answer * (n - k + i);
			answer = answer / i;
		}
		return answer * (double)Math.pow(p, k) * (double)Math.pow(1 - p, n - k);
	}

	//For critical damage (double damage)
	private double negativeBinomial (int s, double p){
		assert(s >= 1);
		int sum = 0;
		for (int i = 0; i < s; i++) sum += geometric(p);
		return sum;
	}

	private int geometric( double p ) {
		assert( 0. < p && p < 1. );
		return (int) (log(uniform())/log( 1 - p ));
	}

	//The higher the player level, the higher the enemy level is; c=1
	private double triangular(double xMin, double xMax, double c){
		assert( xMin < xMax && xMin <= c && c <= xMax );
		double p = uniform(), q = 1. - p;
		if ( p <= ( c - xMin ) / ( xMax - xMin ) )
			return xMin + sqrt( ( xMax - xMin ) * ( c - xMin ) * p );
		else
			return xMax - sqrt( ( xMax - xMin ) * ( xMax - c ) * q );
	}

	//The higher the player level, the harder it is to run
	private double exponential( double a, double b ){
		assert(b > 0);
		return a - b * log(uniform());
	}


}