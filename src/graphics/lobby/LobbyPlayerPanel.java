/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics.lobby;

import communication.Client;
import game.PlayerHandler;
import graphics.PlayerColor;
import java.awt.Color;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author tamtakospc
 */
public class LobbyPlayerPanel extends javax.swing.JPanel {

    JLabel[] col={new JLabel("hi")};
    Icon notConnectedIcona = new ImageIcon(getClass().getResource("/resources/icons/icon5.png"));
    PlayerColor notConnectedIcon = new PlayerColor(-1, Color.WHITE, notConnectedIcona);
    Icon[] icons = new Icon[4];
    protected  DefaultComboBoxModel model;
    boolean actionlistenerEnabled=true;
    
    //http://www.codejava.net/java-se/swing/create-custom-gui-for-jcombobox
    /**
     * Creates new form LobbyPlayerPanel
     */
    public LobbyPlayerPanel() {
    
        model = new DefaultComboBoxModel<>();
        //icons[0]= notConnectedIcon;
//        icons[1]= blueIcon;
//        icons[2]= redIcon;
//        icons[3]= greenIcon
        
//        for(int i=0; i<PlayerHandler.availableColors.length; i++)
//        {
//            model.addElement(PlayerHandler.availableColors[i]);//edw
//        }
        model.addElement(notConnectedIcon);
//        for (Icon icon : icons) {
//            model.addElement(icon);
//        }
        
        initComponents();
       
        model.setSelectedItem(model.getElementAt(model.getSize()-1));
        jComboBox1.setEnabled(false);
        
        
       
    }
    
    
    public void setName(String name)
    {
        NameLabel.setText(name);
    }
    public void enableListener()
    {
      actionlistenerEnabled=true;
    }
    
     public void disableListener()
    {
      actionlistenerEnabled=false;
    }
    
    public void enableChoosing(boolean enabled)
    {
       this.jComboBox1.setEnabled(enabled);
    }
    
    public void setChoosed(PlayerColor col)
    {
         //model.setSelectedItem(model.getElementAt(index));
         model.setSelectedItem(col);
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        NameLabel = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        NameLabel.setText("Not Connected");

        jComboBox1.setEditable(true);
        jComboBox1.setModel(model
        );
        jComboBox1.setEditor(new ColorItemEditor());
        jComboBox1.setRenderer(new ColorItemRenderer());
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
        
        //evt.getStateChange()
        if  (   actionlistenerEnabled
                &&evt.getStateChange()==java.awt.event.ItemEvent.SELECTED
                && Client.player != null
                && LobbyWindow.playerPanels != null
                && LobbyWindow.playerPanels[Client.player.getId()] != null
                && LobbyWindow.playerPanels[Client.player.getId()]==(this)
                && ((PlayerColor)evt.getItem()).getColorID()!=Client.player.getColor().getColorID()
            )
        {
            
            debug.Debug.println("_-_-!boxitemstateChanged!-_---------ALLAKSE--------"+System.currentTimeMillis());
            debug.Debug.println("apo "+   Client.player.getColor().getColorID());
            debug.Debug.println("se "+   ((PlayerColor)evt.getItem()).getColorID());
            debug.Debug.println("toy "+  Client.player.getId());
            debug.Debug.println("end");
            debug.Debug.println("klhsh setColor apo Plpanel ac listener");
            Client.player.setColor(((PlayerColor)evt.getItem()));
            Client.informAboutPlayerColorChange(((PlayerColor)evt.getItem()));
            
//            PlayerColor pc =(PlayerColor)evt.getItem();
//             debug.Debug.println("item"+ pc.getColorID());
//             debug.Debug.println("Clienr"+ Client.player.getColor().getColorID());
            
        }
           
    }//GEN-LAST:event_jComboBox1ItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NameLabel;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
