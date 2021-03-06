/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics.lobby;

import communication.Client;
import game.Player;
import game.PlayerHandler;
import graphics.MapCanvas;
import graphics.PlayerColor;
import java.beans.PropertyChangeListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.plaf.basic.BasicTextUI;
import javax.swing.text.Highlighter;

/**
 *
 * @author tamtakospc
 */
public class LobbyWindow extends javax.swing.JFrame {


    public static boolean enabled=false;
    boolean gameSettingsEnabled=false;
    


    /**
     * Creates new form LobbyWindow
     */
    public LobbyWindow() {
        if(Client.player.getId()==0)
            gameSettingsEnabled=true;
        Areas.MapController.setMap(Areas.MapController.modNames.get(0));
        initComponents();
        playerPanels= new LobbyPlayerPanel[6];
        playerPanels[0]=lobbyPlayerPanel1;
        playerPanels[1]=lobbyPlayerPanel2;
        playerPanels[2]=lobbyPlayerPanel3;
        playerPanels[3]=lobbyPlayerPanel4;
        playerPanels[4]=lobbyPlayerPanel5;
        playerPanels[5]=lobbyPlayerPanel6;
        playerPanels[Client.id].model.removeElementAt(playerPanels[Client.id].model.getSize()-1);
        enabled=true;
        //loadPlayer(Client.player);
        loadPlayersNames();
        Client.sendMessageExpMe(Client.player.getName()+" joined the room");
        
    }

    public static void loadPlayersNames()
    {
        //enabled=true;
        
        for(Player p:Client.playerHandler.playerlist)
        {
               
                int id=p.getId();
                playerPanels[id].disableListener();
                p.getName();
                //playerPanels[id].equals(null);
                playerPanels[id].setName(p.getName());
                 //playerPanels[id].enableChoosing(true);
                if(Client.id==id)
                {
                    playerPanels[id].enableChoosingReady(true);
                }
//                if(playerPanels[id]==lobbyPlayerPanel1)
//                {
//                    debug.Debug.println("isa");
//                }
                playerPanels[/*Client.*/id].model.removeAllElements();
                int modelSize =playerPanels[/*Client.*/id].model.getSize();
            for (int i =0; i<PlayerHandler.availableColors.length;  i++) {
                if(PlayerHandler.availableColors[i].getPlayerID()==/*Client.*/id||PlayerHandler.availableColors[i].getPlayerID()==-1)
                {
                    playerPanels[/*Client.*/id].model.addElement(PlayerHandler.availableColors[i]);// edw
                }
            }
           //if(((PlayerColor)playerPanels[id].model.getSelectedItem()).getColorID()==Client.player.getColor().getColorID())
            playerPanels[id].setChoosed(p.getColor());
           
            for (int i = 0; i < modelSize; i++) {
                playerPanels[/*Client.*/id].model.removeElementAt(i);
            }
//            PropertyChangeListener[] ar =playerPanels[id].getPropertyChangeListeners();
//            for (int i = 0; i < ar.length; i++) {
//                playerPanels[id].removePropertyChangeListener(ar[i]);
//                
//            }
            
            
            
//             for (int i = 0; i < ar.length; i++) {
//                playerPanels[id].addPropertyChangeListener(ar[i]);
//                
//            }
            playerPanels[id].enableListener();
            
        }
                
    }
    
    
    public static void displayMessage(String msg) {
        jTextArea1.append(msg+"\n");
    }
    
//     public static void loadPlayer(Player player)
//    {
//        
//                int id=player.getId();
//                //p.getName();
//                //playerPanels[id].equals(null);
//                playerPanels[id].setName(player.getName());
//                
////                if(playerPanels[id]==lobbyPlayerPanel1)
////                {
////                    debug.Debug.println("isa");
////                }
//            playerPanels[player.getId()].model.removeAllElements();
//            for (int i =0; i<PlayerHandler.availableColors.length;  i++) {
//                if(PlayerHandler.availableColors[i].getPlayerID()==Client.id||PlayerHandler.availableColors[i].getPlayerID()==-1)
//                {
//                    playerPanels[Client.id].model.addElement(PlayerHandler.availableColors[i]);// edw
//                }
//            }
//            playerPanels[id].setChoosed(player.getColor().getColorID());
//                if(Client.id==id)
//                {
//                    playerPanels[id].enableChoosing(true);
//                }
////            
////        }
////                
//    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        styleButtonGroup = new javax.swing.ButtonGroup();
        transmition1stButtonGroup = new javax.swing.ButtonGroup();
        transmition2ndButtonGroup = new javax.swing.ButtonGroup();
        unitPlacementButtonGroup = new javax.swing.ButtonGroup();
        percentageButtonGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lobbyPlayerPanel1 = new graphics.lobby.LobbyPlayerPanel();
        lobbyPlayerPanel2 = new graphics.lobby.LobbyPlayerPanel();
        lobbyPlayerPanel3 = new graphics.lobby.LobbyPlayerPanel();
        lobbyPlayerPanel4 = new graphics.lobby.LobbyPlayerPanel();
        lobbyPlayerPanel5 = new graphics.lobby.LobbyPlayerPanel();
        lobbyPlayerPanel6 = new graphics.lobby.LobbyPlayerPanel();
        jPanel3 = new javax.swing.JPanel();
        panel1 = new java.awt.Panel();
        canvas1 = canvas1= new MapCanvas(200,200);
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        MapjComboBox = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        reinfircementsJLabel = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        wordConquerRadioButton = new javax.swing.JRadioButton();
        missionsRadioButton = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        wc75RadioButton = new javax.swing.JRadioButton();
        wc100RadioButton = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        transmition2ndjCheckBox = new javax.swing.JCheckBox();
        transmitions2ndContAreasLimitjSpinner = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        transmition1stNearBy = new javax.swing.JRadioButton();
        transmition1stContinius = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        transmitions1stContjSpinner = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        transmition2ndNearBy = new javax.swing.JRadioButton();
        transmition2ndContinius = new javax.swing.JRadioButton();
        transmitions2ndContjSpinner = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(900, 700));
        setMinimumSize(new java.awt.Dimension(900, 700));
        setPreferredSize(new java.awt.Dimension(900, 700));

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Risk Lobby Room");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(345, 345, 345))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Players");

        jLabel9.setText("Ready");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addComponent(jLabel9))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lobbyPlayerPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lobbyPlayerPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lobbyPlayerPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lobbyPlayerPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lobbyPlayerPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lobbyPlayerPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lobbyPlayerPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lobbyPlayerPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lobbyPlayerPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lobbyPlayerPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lobbyPlayerPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lobbyPlayerPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));

        canvas1.setBackground(new java.awt.Color(153, 255, 255));
        canvas1.setMaximumSize(new java.awt.Dimension(535, 401));
        canvas1.setMinimumSize(new java.awt.Dimension(535, 401));
        canvas1.setName(""); // NOI18N

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 204));

        jLabel3.setText("Chat");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setText("Send");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jLabel4.setText("Map");

        MapjComboBox.setModel(new javax.swing.DefaultComboBoxModel(Areas.MapController.modNames.toArray()));
        MapjComboBox.setEnabled(gameSettingsEnabled);
        MapjComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                MapjComboBoxItemStateChanged(evt);
            }
        });

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList1.setEnabled(gameSettingsEnabled);
        jScrollPane2.setViewportView(jList1);

        reinfircementsJLabel.setText("Reinforcements");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MapjComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(reinfircementsJLabel)
                        .addGap(0, 77, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MapjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reinfircementsJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(204, 255, 255));

        styleButtonGroup.add(wordConquerRadioButton);
        wordConquerRadioButton.setSelected(true);
        wordConquerRadioButton.setText("Workd Conquer");
        wordConquerRadioButton.setEnabled(gameSettingsEnabled);
        wordConquerRadioButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                wordConquerRadioButtonItemStateChanged(evt);
            }
        });

        styleButtonGroup.add(missionsRadioButton);
        missionsRadioButton.setText("Missions");
        missionsRadioButton.setEnabled(gameSettingsEnabled);
        missionsRadioButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                missionsRadioButtonItemStateChanged(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Style");

        percentageButtonGroup.add(wc75RadioButton);
        wc75RadioButton.setSelected(true);
        wc75RadioButton.setText("75%");
        wc75RadioButton.setEnabled(gameSettingsEnabled);

        percentageButtonGroup.add(wc100RadioButton);
        wc100RadioButton.setText("100%");
        wc100RadioButton.setEnabled(gameSettingsEnabled);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("2nd Transmition");

        transmition2ndjCheckBox.setText("Allow 2nd");
        transmition2ndjCheckBox.setEnabled(gameSettingsEnabled);
        transmition2ndjCheckBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                transmition2ndjCheckBoxItemStateChanged(evt);
            }
        });
        transmition2ndjCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transmition2ndjCheckBoxActionPerformed(evt);
            }
        });

        transmitions2ndContAreasLimitjSpinner.setModel(new javax.swing.SpinnerNumberModel(10, 10, 99, 1));
        transmitions2ndContAreasLimitjSpinner.setEnabled(false);

        jLabel7.setText("<html>  After Owning  Areas");
        jLabel7.setToolTipText("");

        transmition1stButtonGroup.add(transmition1stNearBy);
        transmition1stNearBy.setSelected(true);
        transmition1stNearBy.setText("nearby");
        transmition1stNearBy.setEnabled(gameSettingsEnabled);
        transmition1stNearBy.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                transmition1stNearByItemStateChanged(evt);
            }
        });
        transmition1stNearBy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transmition1stNearByActionPerformed(evt);
            }
        });

        transmition1stButtonGroup.add(transmition1stContinius);
        transmition1stContinius.setText("continius");
        transmition1stContinius.setEnabled(gameSettingsEnabled);
        transmition1stContinius.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                transmition1stContiniusItemStateChanged(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Unit Placement");

        unitPlacementButtonGroup.add(jRadioButton8);
        jRadioButton8.setSelected(true);
        jRadioButton8.setText("Random");
        jRadioButton8.setEnabled(gameSettingsEnabled);

        unitPlacementButtonGroup.add(jRadioButton9);
        jRadioButton9.setText("Pick");
        jRadioButton9.setEnabled(gameSettingsEnabled);
        jRadioButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton9ActionPerformed(evt);
            }
        });

        transmitions1stContjSpinner.setModel(new javax.swing.SpinnerNumberModel(2, 2, 5, 1));
        transmitions1stContjSpinner.setToolTipText("hi all");
        transmitions1stContjSpinner.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Transmition");

        transmition2ndButtonGroup.add(transmition2ndNearBy);
        transmition2ndNearBy.setSelected(true);
        transmition2ndNearBy.setText("nearby");
        transmition2ndNearBy.setEnabled(false);
        transmition2ndNearBy.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                transmition2ndNearByItemStateChanged(evt);
            }
        });
        transmition2ndNearBy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transmition2ndNearByActionPerformed(evt);
            }
        });

        transmition2ndButtonGroup.add(transmition2ndContinius);
        transmition2ndContinius.setText("continius");
        transmition2ndContinius.setEnabled(false);
        transmition2ndContinius.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                transmition2ndContiniusItemStateChanged(evt);
            }
        });
        transmition2ndContinius.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                transmition2ndContiniusStateChanged(evt);
            }
        });

        transmitions2ndContjSpinner.setModel(new javax.swing.SpinnerNumberModel(2, 2, 5, 1));
        transmitions2ndContjSpinner.setEnabled(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(transmition1stContinius)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(transmitions1stContjSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(transmition1stNearBy)))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(wordConquerRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(wc100RadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(wc75RadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(missionsRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jRadioButton9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jRadioButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(45, 45, 45))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(transmitions2ndContAreasLimitjSpinner))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(transmition2ndContinius, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(transmitions2ndContjSpinner))
                                    .addComponent(transmition2ndjCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(transmition2ndNearBy))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 214, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(wordConquerRadioButton)
                            .addComponent(jRadioButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton9)
                            .addComponent(wc75RadioButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(wc100RadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(missionsRadioButton))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(transmition2ndjCheckBox))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(transmition2ndNearBy))
                .addGap(3, 3, 3)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(transmition1stNearBy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(transmition1stContinius)
                            .addComponent(transmitions1stContjSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(transmition2ndContinius)
                            .addComponent(transmitions2ndContjSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(transmitions2ndContAreasLimitjSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        if(evt.getKeyCode()==10&&!jTextField1.getText().trim().equals(""))
        {
            String message =jTextField1.getText();
            jTextField1.setText("");
            //jTextArea2.setRows(0);
            Client.sendMessage(Client.player.getName()+": "+message);
          
            //debug.Debug.println("("+message+")");
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        if(evt.getKeyCode()==10)
        {
            jTextField1.setText("");
            
        }
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton9ActionPerformed

    private void transmition1stNearByActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transmition1stNearByActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_transmition1stNearByActionPerformed

    private void transmition2ndjCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transmition2ndjCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_transmition2ndjCheckBoxActionPerformed

    private void transmition2ndNearByActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transmition2ndNearByActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_transmition2ndNearByActionPerformed

    private void missionsRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_missionsRadioButtonItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED)
        {
            
            wc75RadioButton.setEnabled(false);
            wc100RadioButton.setEnabled(false);
            
        }
            
    }//GEN-LAST:event_missionsRadioButtonItemStateChanged

    private void wordConquerRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_wordConquerRadioButtonItemStateChanged
        if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED)
        {
            wc75RadioButton.setEnabled(true);
            wc100RadioButton.setEnabled(true);   
        }
    }//GEN-LAST:event_wordConquerRadioButtonItemStateChanged

    private void transmition1stNearByItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_transmition1stNearByItemStateChanged
        if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED)
        {
            transmitions1stContjSpinner.setEnabled(false);
        }
    }//GEN-LAST:event_transmition1stNearByItemStateChanged

    private void transmition1stContiniusItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_transmition1stContiniusItemStateChanged
        if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED)
        {
            transmitions1stContjSpinner.setEnabled(true);
        }
    }//GEN-LAST:event_transmition1stContiniusItemStateChanged

    private void transmition2ndjCheckBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_transmition2ndjCheckBoxItemStateChanged
        if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED)
        {
           transmition2ndContinius.setEnabled(true);
           transmition2ndNearBy.setEnabled(true);
           transmitions2ndContAreasLimitjSpinner.setEnabled(true);
        }
        else if (evt.getStateChange() == java.awt.event.ItemEvent.DESELECTED)
        {
           transmition2ndContinius.setEnabled(false);
           transmition2ndNearBy.setEnabled(false);
           transmitions2ndContAreasLimitjSpinner.setEnabled(false);
        }
    }//GEN-LAST:event_transmition2ndjCheckBoxItemStateChanged

    private void transmition2ndNearByItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_transmition2ndNearByItemStateChanged
        if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED)
        {
            transmitions2ndContjSpinner.setEnabled(false);
        }
    }//GEN-LAST:event_transmition2ndNearByItemStateChanged

    private void transmition2ndContiniusItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_transmition2ndContiniusItemStateChanged
        //debug.Debug.println("radio bytton_____---------------------");
        if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED)
        {
            transmitions2ndContjSpinner.setEnabled(true);
        }
    }//GEN-LAST:event_transmition2ndContiniusItemStateChanged

    private void transmition2ndContiniusStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_transmition2ndContiniusStateChanged
       if(!transmition2ndContinius.isEnabled())
           transmitions2ndContjSpinner.setEnabled(false);
       else if(transmition2ndContinius.isEnabled()&&transmition2ndContinius.isSelected())
           transmitions2ndContjSpinner.setEnabled(true);
    }//GEN-LAST:event_transmition2ndContiniusStateChanged

    private void MapjComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_MapjComboBoxItemStateChanged
        // TODO add your handling code here:
        String mod = (String) evt.getItem();
        debug.Debug.println(mod+"000000000000000000000000000000000");
        Areas.MapController.setMap(mod);
        //canvas1=new MapCanvas(200, 200);
        canvas1.repaint();
//        canvas1.revalidate();
        
    }//GEN-LAST:event_MapjComboBoxItemStateChanged

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(LobbyWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(LobbyWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(LobbyWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(LobbyWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new LobbyWindow().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox MapjComboBox;
    private java.awt.Canvas canvas1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private static javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private static graphics.lobby.LobbyPlayerPanel lobbyPlayerPanel1;
    private static graphics.lobby.LobbyPlayerPanel lobbyPlayerPanel2;
    private static graphics.lobby.LobbyPlayerPanel lobbyPlayerPanel3;
    private static graphics.lobby.LobbyPlayerPanel lobbyPlayerPanel4;
    private static graphics.lobby.LobbyPlayerPanel lobbyPlayerPanel5;
    private static graphics.lobby.LobbyPlayerPanel lobbyPlayerPanel6;
    private javax.swing.JRadioButton missionsRadioButton;
    private java.awt.Panel panel1;
    private javax.swing.ButtonGroup percentageButtonGroup;
    private javax.swing.JLabel reinfircementsJLabel;
    private javax.swing.ButtonGroup styleButtonGroup;
    private javax.swing.ButtonGroup transmition1stButtonGroup;
    private javax.swing.JRadioButton transmition1stContinius;
    private javax.swing.JRadioButton transmition1stNearBy;
    private javax.swing.ButtonGroup transmition2ndButtonGroup;
    private javax.swing.JRadioButton transmition2ndContinius;
    private javax.swing.JRadioButton transmition2ndNearBy;
    private javax.swing.JCheckBox transmition2ndjCheckBox;
    private javax.swing.JSpinner transmitions1stContjSpinner;
    private javax.swing.JSpinner transmitions2ndContAreasLimitjSpinner;
    private javax.swing.JSpinner transmitions2ndContjSpinner;
    private javax.swing.ButtonGroup unitPlacementButtonGroup;
    private javax.swing.JRadioButton wc100RadioButton;
    private javax.swing.JRadioButton wc75RadioButton;
    private javax.swing.JRadioButton wordConquerRadioButton;
    // End of variables declaration//GEN-END:variables
    protected static graphics.lobby.LobbyPlayerPanel playerPanels[];//= {lobbyPlayerPanel1,lobbyPlayerPanel2,lobbyPlayerPanel3,lobbyPlayerPanel4,lobbyPlayerPanel5,lobbyPlayerPanel6};
    //http://www.java2s.com/Code/Java/Swing-JFC/UseJListcomponenttodisplaycustomobjectswithListCellRenderer.htm
}
