/*
Tic Tac Toe Multiplayer 
Author: E/14/009 Adikari A.M.H.I @ EFAC, University of Peradeniya
Date:30/08/2017
*/

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Result extends javax.swing.JFrame {

    String host;
    boolean isServer;
    
    public Result(String host,boolean isServer) {
        initComponents();
        this.host=host;
        this.isServer=isServer;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new java.awt.Dimension(600, 600));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }                       
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        resulttxt = new javax.swing.JLabel();
        playertxt = new javax.swing.JLabel();
        playbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        resulttxt.setFont(new java.awt.Font("Old English Text MT", 0, 65)); // NOI18N
        resulttxt.setForeground(new java.awt.Color(0, 153, 0));
        resulttxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        resulttxt.setText("f");

        playertxt.setFont(new java.awt.Font("Tahoma", 0, 75)); // NOI18N
        playertxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playertxt.setText("f");

        playbtn.setText("Play Again");
        playbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(playertxt, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(resulttxt, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(playbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(playertxt, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(resulttxt, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(playbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
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
    }// </editor-fold>                        
    public JLabel getResulttxt() {
        return resulttxt;
    }

    public JButton getPlaybtn() {
        return playbtn;
    }

    public JLabel getPlayertxt() {
        return playertxt;
    }

    private void playbtnActionPerformed(java.awt.event.ActionEvent evt) {                                        
        this.dispose();
        ChoosePlayer cp= new ChoosePlayer(host,isServer);
        cp.setVisible(true);

    } 

    // Variables declaration - do not modify                     
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel resulttxt;
    private javax.swing.JButton playbtn;
    private javax.swing.JLabel playertxt;
    // End of variables declaration                   

}
