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

    public PlayerColor(Color color, Icon icon) {
        this.color = color;
        this.icon = icon;
    }
     

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }
   
    
}
