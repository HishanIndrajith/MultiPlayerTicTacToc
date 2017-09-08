/*
Tic Tac Toe Multiplayer 
Author: E/14/009 Adikari A.M.H.I @ EFAC, University of Peradeniya
Date:30/08/2017
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

public class ChoosePlayer extends javax.swing.JFrame {

    private String host;
    private boolean isServer;
    
    public ChoosePlayer(String host, boolean isServer) {
        this.host=host;
        this.isServer=isServer;
        initComponents(); 
        this.setLocationRelativeTo(null); 
        btn.setEnabled(false);
    }

                          
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        player1radio = new javax.swing.JRadioButton();
        player2radio = new javax.swing.JRadioButton();
        btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Choose Player");

        buttonGroup1.add(player1radio);
        player1radio.setForeground(new java.awt.Color(255, 255, 255));
        player1radio.setBackground(new java.awt.Color(102, 102, 102));
        player1radio.setText("Player 1");
        player1radio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player1radioActionPerformed(evt);
            }
        });

        buttonGroup1.add(player2radio);
        player2radio.setForeground(new java.awt.Color(255, 255, 255));
        player2radio.setBackground(new java.awt.Color(102, 102, 102));
        player2radio.setText("Player 2");
        player2radio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                player2radioActionPerformed(evt);
            }
        });

        btn.setText("Go >>");
        btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(player2radio, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(player1radio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(43, 43, 43)
                .addComponent(btn, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(115, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(player1radio)
                        .addGap(18, 18, 18)
                        .addComponent(player2radio))
                    .addComponent(btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }                      

    private void player1radioActionPerformed(java.awt.event.ActionEvent evt) {                                             
        if(player1radio.isSelected() || player2radio.isSelected()){
            btn.setEnabled(true);
        }else{
            btn.setEnabled(false);
        }
    }                                            

    private void player2radioActionPerformed(java.awt.event.ActionEvent evt) {                                             
        if(player1radio.isSelected() || player2radio.isSelected()){
            btn.setEnabled(true);
        }else{
            btn.setEnabled(false);
        }
    }                                            
    private void btnActionPerformed(java.awt.event.ActionEvent evt) { 
        try{
            if(!isPlayerExist()){                                  
            GameController GC =new GameController(isServer,(player1radio.isSelected() ? 1 : 2),host);
            this.dispose();
            } else{
               JOptionPane.showMessageDialog(null, "The player you choosed is already there. Choose the other Player.");
            }
        } catch (IOException iOException) {

        }catch (NullPointerException npException) {
             JOptionPane.showMessageDialog(null, "Requested server program doesn't exist. Run the server game first and insert correct host address");
        }
    }


    private boolean isPlayerExist() throws IOException{
        boolean returnval=false;
        if(isServer)
            return false;
        Socket socket=null;
        try {
          socket = new Socket(host, 1250);
          BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
          bw.write("check"+(player1radio.isSelected() ? 1 : 2 )+"\n");            
          bw.flush();
          String line=br.readLine();
          if(line.trim().equals("notexist"))
            returnval= false;
          else
            returnval= true;
        }catch (IOException iOException) {
        }finally { 
          socket.close();
        }
        return returnval;
    }
    

    // Variables declaration - do not modify                     
    private javax.swing.JButton btn;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton player1radio;
    private javax.swing.JRadioButton player2radio;
    // End of variables declaration                   
}
