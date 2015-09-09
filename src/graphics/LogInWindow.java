/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import java.awt.Color;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import communication.Client;
import communication.Server;
import debug.Debug;
import game.Player;
import game.PlayerHandler;
import graphics.lobby.LobbyWindow;


/**
 *
 * @author tamtakospc
 */
public class LogInWindow extends javax.swing.JFrame {
    /**
	 * 
	 */
    private static final long serialVersionUID = 5265610617737582087L;
    private boolean nameTextFieldIntialized=false;
    private boolean hostAddressTextFieldIntialized;
    //private boolean conected=false;
    private ImageIcon red,green;
    
    private final String greenStatusIconFileName= "icons/greenStatusIcon.gif",
            redStatusIconFileName= "icons/redStatusIcon.gif"
            ;
    private String defaultPort="81";
    
   

    /**
     * Creates new form RiskLogIn
     */
    public LogInWindow() {
    	//---------------
		 try {
	         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	             if ("Nimbus".equals(info.getName())) {
	                 javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                 break;
	             }
	         }
	     } catch (ClassNotFoundException ex) {
	         java.util.logging.Logger.getLogger(LogInWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	     } catch (InstantiationException ex) {
	         java.util.logging.Logger.getLogger(LogInWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	     } catch (IllegalAccessException ex) {
	         java.util.logging.Logger.getLogger(LogInWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	     } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	         java.util.logging.Logger.getLogger(LogInWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	     }
    	//------------------------------
    	try {
			red =new ImageIcon(ImageIO.read(game.FileLoader.loadFile(redStatusIconFileName)));
			green =new ImageIcon(ImageIO.read(game.FileLoader.loadFile(greenStatusIconFileName)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        initComponents();
        //setConected(conected.);
        setVisible(true);
        if(Debug.DEBUG)
        {
        	nameTextFieldIntialized=hostAddressTextFieldIntialized=true;
        	nameTextField.setText("J");
        	hostAddressTextField.setText("localhost");
        	
        	
        }
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    //@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        hostButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        hostAddressTextField = new javax.swing.JTextField();
        connectButton = new javax.swing.JButton();
        portTextField = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        statusLabel = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        statusTextField = new javax.swing.JTextField();
        startButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Risk Local Game");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        jLabel2.setText("Name");

        nameTextField.setForeground(new java.awt.Color(153, 153, 153));
        nameTextField.setText("Insert nickname");
        nameTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nameTextFieldMouseClicked(evt);
            }
        });
        nameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nameTextFieldKeyPressed(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Host A Game");

        hostButton.setText("Host");
        hostButton.setMaximumSize(new java.awt.Dimension(55, 25));
        hostButton.setMinimumSize(new java.awt.Dimension(55, 25));
        hostButton.setPreferredSize(new java.awt.Dimension(55, 25));
        hostButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hostButtonActionPerformed(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Join A Game");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel3.setText("IP");

        hostAddressTextField.setForeground(new java.awt.Color(153, 153, 153));
        hostAddressTextField.setText("Host Address");
        hostAddressTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hostAddressTextFieldMouseClicked(evt);
            }
        });
        hostAddressTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                hostAddressTextFieldKeyPressed(evt);
            }
        });

        connectButton.setText("Connect");
        connectButton.setMaximumSize(new java.awt.Dimension(55, 25));
        connectButton.setMinimumSize(new java.awt.Dimension(55, 25));
        connectButton.setPreferredSize(new java.awt.Dimension(55, 25));
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButtonActionPerformed(evt);
            }
        });

        portTextField.setText(defaultPort);

        jLabel4.setText("Port");

        statusLabel.setText("Status");

        statusTextField.setEditable(false);
        statusTextField.setText("Not connected");

        startButton.setText("Start");
        startButton.setEnabled(false);
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator3)
            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameTextField)
                    .addComponent(hostAddressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(portTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(startButton)
                .addGap(10, 10, 10))
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(hostButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(connectButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(75, 75, 75))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(statusLabel)))
                .addGap(60, 60, 60))
            .addComponent(statusTextField)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(hostButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(hostAddressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(connectButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(portTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(statusLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addGap(9, 9, 9)
                .addComponent(startButton))
        );

        pack();
        setLocationRelativeTo(null);
        statusLabel.setIcon(red);
    }// </editor-fold>//GEN-END:initComponents

    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed
    	//Debug.println(Server.socket.getLocalSocketAddress());
    	if(checkValidName()&& checkIP())
        {
    		Client client = new Client();
    		int res =Client.connect(getIP(),getPort(),getNickname());
        	if(res==1){
        		Thread t = new Thread(client);
        		t.start();
				System.out.println("join");
				setConected(1);
				//PlayerHandler.addPlayer(new Player(getNickname()));
			}
        	else if(res==0)
        	{
        		setConected(0);
        	}else
        		setConected(-1);
        }				//PlayerHandler.addPlayer(new Player(getNickname()));

    }//GEN-LAST:event_connectButtonActionPerformed

    private void hostButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hostButtonActionPerformed
        
        if(checkValidName()&& checkPort())
        {
        	Server server = new Server();
        	
        	if(Server.connect(getPort())){
        		Thread t = new Thread(server);
        		t.start();
        		System.out.println("host");
        		setConected(1);
                        nameTextField.setEditable(false);
        		//PlayerHandler.addPlayer(new Player(getNickname()));
                       connectButtonActionPerformed(null);
        		
        	}
        	else
        	{
        		statusTextField.setText("Can not host (try another port)");
        	}
            //TODO
        }
        
        
    }//GEN-LAST:event_hostButtonActionPerformed

    private void nameTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameTextFieldMouseClicked
        if(!nameTextFieldIntialized)
        {
            nameTextField.setText("");
            nameTextField.setForeground(Color.BLACK);
            nameTextFieldIntialized=true;
        }
    }//GEN-LAST:event_nameTextFieldMouseClicked

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        this.dispose();
        new LobbyWindow().setVisible(true);
    }//GEN-LAST:event_startButtonActionPerformed

    private void nameTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameTextFieldKeyPressed
         if(!nameTextFieldIntialized)
        {
            nameTextField.setText("");
            nameTextField.setForeground(Color.BLACK);
            nameTextFieldIntialized=true;
        }
    }//GEN-LAST:event_nameTextFieldKeyPressed

    private void hostAddressTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hostAddressTextFieldKeyPressed
        if(!hostAddressTextFieldIntialized)
        {
            hostAddressTextField.setText("");
            hostAddressTextField.setForeground(Color.BLACK);
            hostAddressTextFieldIntialized=true;
        }
    }//GEN-LAST:event_hostAddressTextFieldKeyPressed

    private void hostAddressTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hostAddressTextFieldMouseClicked
        if(!hostAddressTextFieldIntialized)
        {
            hostAddressTextField.setText("");
            hostAddressTextField.setForeground(Color.BLACK);
            hostAddressTextFieldIntialized=true;
        }
    }//GEN-LAST:event_hostAddressTextFieldMouseClicked

    /**
     * @param args the command line arguments
     */
//   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton connectButton;
    private javax.swing.JTextField hostAddressTextField;
    private javax.swing.JButton hostButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JTextField portTextField;
    private javax.swing.JButton startButton;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JTextField statusTextField;
    // End of variables declaration//GEN-END:variables

    public void setConected(int conected) {
       
        if(conected==1)
        {
        	//this.conected=true;
            statusLabel.setIcon(green);
            statusTextField.setText("conected");
            hostButton.setEnabled(false);
            connectButton.setEnabled(false);
            startButton.setEnabled(true);
        }
        else if(conected==0)
        {
        	 statusTextField.setText("nickname is not unic");
        	
        }
        else if(conected==-1)
        {
        	statusTextField.setText("conection problem");
            statusLabel.setIcon(red);
        }
    }
    
    public String getNickname()
    {
        return nameTextField.getText();
    }

    private boolean checkValidName() {
        boolean valid =!(!nameTextFieldIntialized||getNickname()==null || getNickname().equals(""));
        if(!valid)
        {
            statusTextField.setText("Ivalid Nickname");
        }
        return valid;
    }

    private boolean checkIP() {
         boolean valid =!(!hostAddressTextFieldIntialized||getIP()==null || getIP().equals(""));
        if(!valid)
        {
            statusTextField.setText("Ivalid IP");
        }
        return valid;
    }
    
    private boolean checkPort() {
         boolean valid =!(getPort()==null);
       
        if(!valid)
        {
            statusTextField.setText("Ivalid Port");
        }
        return valid;
    }

    public String getIP() {
        return hostAddressTextField.getText();
    }
    
    public Integer getPort() {
        Integer port = null;
        try {
        port = Integer.parseInt(portTextField.getText());
        }catch(NumberFormatException e)
        {
            
        }
        return port;
    }
}
