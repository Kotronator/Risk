package game;

import java.awt.Color;
import java.util.ArrayList;

import Areas.Territory;

public class Player {
	
    private String name;
    private Color color;
    private ArrayList<Territory> territories;
    private ArrayList<Card> cards;
    private int id;

    public Player(String nickname) {
            this.name=nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public ArrayList<Territory> getTerritories() {
        return territories;
    }

    public void setTerritories(ArrayList<Territory> territories) {
        this.territories = territories;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
	
}
