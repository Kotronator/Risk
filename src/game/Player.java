package game;

import java.util.ArrayList;

import Areas.Territory;
import graphics.PlayerColor;

public class Player {

   
	
    private String name;
    private PlayerColor color;
    private ArrayList<Territory> territories;
    private ArrayList<Card> cards;
    private int id;

     public Player(String name, int id, PlayerColor color) {
        this.name = name;
        this.color = color;
        this.color.setPlayerID(id);
        this.id = id;
    }
    
    public Player(String nickname) {
            this.name=nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerColor getColor() {
        return color;
    }

    public void setColor(PlayerColor color) {
        if(this.color!=null)
        {
            this.color.setPlayerID(-1);
        }
        this.color = color;
        this.color.setPlayerID(id);
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
