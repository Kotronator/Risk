package game;

import java.awt.Color;
import java.util.ArrayList;

import Areas.Territory;

public class Player {
	
	String name;
	Color color;
	ArrayList<Territory> territories;
	ArrayList<Card> cards;

	
	public Player(String nickname) {
		this.name=nickname;
	}
	
}
