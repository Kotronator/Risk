/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics.lobby;

import graphics.PlayerColor;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

/**
 *
 * @author tsipiripo
 */
public class ColorItemRenderer extends JPanel implements ListCellRenderer {
    
    private JLabel labelItem = new JLabel();
    
     public ColorItemRenderer() {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1.0;
        constraints.insets = new Insets(2, 2, 2, 2);
         
        labelItem.setOpaque(true);
        labelItem.setHorizontalAlignment(JLabel.CENTER);
         
//        labelItem.addMouseListener(new java.awt.event.MouseAdapter() {
//
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                debug.Debug.println("clikara thn lista !!!!++++++++++=====");
//            }
//            
//        });
        add(labelItem, constraints);
        setBackground(Color.LIGHT_GRAY);
        
        
    }
    
    @Override
    public Component getListCellRendererComponent(JList list, Object value,
            int index, boolean isSelected, boolean cellHasFocus) {
       
        //labelItem.setIcon(((JLabel)value).getIcon());
        labelItem.setIcon(((PlayerColor)value).getIcon());
        labelItem.setText("");
//        if (isSelected) {
//            setEnabled(false);
//        } else {
//            setEnabled(false);
//        }
        return this;
    }
    
}
