/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import java.awt.Color;
import javax.swing.Icon;

/**
 *
 * @author tsipiripo
 */
public class PlayerColor {
    
    Color color;
    Icon icon;
    int playerID=-1;
    private int colorID;
    
    public PlayerColor(){}
    
    public PlayerColor(int colorID,Color color, Icon icon)
    {
        this.colorID=colorID;
        this.color=color;
        this.icon=icon;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }
     

    public Color getColor() {
        return color;
    }

//    public void setColor(Color color) {
//        this.color = color;
//    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public int getColorID() {
        return colorID;
    }

    public void setColorID(int colorID) {
        this.colorID = colorID;
    }
   
    
}
