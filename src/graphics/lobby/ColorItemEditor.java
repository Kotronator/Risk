/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics.lobby;

import graphics.PlayerColor;
import java.awt.Component;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicComboBoxEditor;

/**
 *
 * @author tsipiripo
 */
public class ColorItemEditor  extends BasicComboBoxEditor {
    private JPanel panel = new JPanel();
    private JLabel labelItem = new JLabel();
    private PlayerColor selectedValue;

    public ColorItemEditor() {
         panel.add(labelItem);
    }
    
    public Component getEditorComponent() {
        return this.panel;
    }
     
    public Object getItem() {
        return this.selectedValue;
    }
     
    public void setItem(Object item) {
        if (item == null) {
            return;
        }
       
        selectedValue = (PlayerColor) item;
        //labelItem.setText(selectedValue);
        labelItem.setIcon(((PlayerColor)item).getIcon());      
    }  
    
}
