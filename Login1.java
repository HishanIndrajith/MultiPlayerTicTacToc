/*
Tic Tac Toe Multiplayer 
Author: E/14/009 Adikari A.M.H.I @ EFAC, University of Peradeniya
Date:30/08/2017
*/

public class Login1 extends javax.swing.JFrame {


    public Login1() {
        initComponents(); 
        this.setLocationRelativeTo(null); 
        iptxt.setEnabled(false);
        btn.setEnabled(false);
    }

                          
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Clientradio = new javax.swing.JRadioButton();
        Serverradio = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        iptxt = new javax.swing.JTextField();
        btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Play as");

        buttonGroup1.add(Clientradio);
        Clientradio.setForeground(new java.awt.Color(255, 255, 255));
        Clientradio.setBackground(new java.awt.Color(102, 102, 102));
        Clientradio.setText("Client");
        Clientradio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClientradioActionPerformed(evt);
            }
        });

        buttonGroup1.add(Serverradio);
        Serverradio.setForeground(new java.awt.Color(255, 255, 255));
        Serverradio.setBackground(new java.awt.Color(102, 102, 102));
        Serverradio.setText("Server");
        Serverradio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ServerradioActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Server IP address (Only if you are Client)");

        

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
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Clientradio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Serverradio))
                    .addComponent(iptxt, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                    .addComponent(btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Clientradio)
                    .addComponent(Serverradio))
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(iptxt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
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

    private void ServerradioActionPerformed(java.awt.event.ActionEvent evt) {                                            
        if(Clientradio.isSelected()){
           iptxt.setEnabled(true);
       }else{
           iptxt.setEnabled(false);
       } 
        
       if(Clientradio.isSelected() || Serverradio.isSelected()){
           btn.setEnabled(true);
       }else{
           btn.setEnabled(false);
       }
    }                                           
                                  

    private void ClientradioActionPerformed(java.awt.event.ActionEvent evt) {                                            
       if(Clientradio.isSelected()){
           iptxt.setEnabled(true);
       }else{
           iptxt.setEnabled(false);
       } 
       if(Clientradio.isSelected() || Serverradio.isSelected()){
           btn.setEnabled(true);
       }else{
           btn.setEnabled(false);
       }
    }      

    private void btnActionPerformed(java.awt.event.ActionEvent evt) {   
        String host = iptxt.getText();
        boolean isServer= Serverradio.isSelected() ? true : false;
        ChoosePlayer cp=new ChoosePlayer(host,isServer);
        cp.setVisible(true);
        this.dispose();
    }                                     

   

    // Variables declaration - do not modify                     
    private javax.swing.JRadioButton Clientradio;
    private javax.swing.JRadioButton Serverradio;
    private javax.swing.JButton btn;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField iptxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration                   
}
