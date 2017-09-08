/*
Tic Tac Toe Multiplayer 
Author: E/14/009 Adikari A.M.H.I @ EFAC, University of Peradeniya
Date:30/08/2017
*/
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;


public class GameController{
    int thisPlayer; //gets when logged
    boolean isServer; //gets when logged
    String host;
    int player = 1; //this change
    int clicks = 0;
    JFrame frame;
    GameView contentPane;
    GameThread T1;
    ClientThread T2;

    GameController(boolean isServer,int thisPlayer,String host){
        this.host=host;
        this.isServer=isServer;
        this.thisPlayer=thisPlayer;
        if(isServer){
            createServer();
        }else{
            beClient();
        }
        frame = new JFrame("Player"+thisPlayer);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new java.awt.Dimension(600, 600));
        frame.setResizable(false);

        contentPane = new GameView();
        contentPane.setOpaque(true); //content panes must be opaque
        contentPane.getBtn1();
        frame.setContentPane(contentPane);
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        addListeners();
        frame.setLocationRelativeTo(null); 
    }   
 


    private void createServer(){
         T1 = new GameThread(this); 
         T1.startt();
    }
    private void beClient(){
        T2 = new ClientThread(this,host,1250); 
        T2.startt();
    }

    private void addListeners() {

        contentPane.getBtn1().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if(thisPlayer==player){
                    try{
                        sendAction(1);  
                        btn1ActionPerformed();
                    }catch (NullPointerException npException) {
                        JOptionPane.showMessageDialog(null, "Must have a client to play");
                    }
                }
            }
        });

        contentPane.getBtn2().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if(thisPlayer==player){
                    try{
                        sendAction(2);  
                        btn2ActionPerformed();
                    }catch (NullPointerException npException) {
                        JOptionPane.showMessageDialog(null, "Must have a client to play");
                    }
                }
            }
        });

        contentPane.getBtn3().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if(thisPlayer==player){
                    try{
                        sendAction(3);  
                        btn3ActionPerformed();
                    }catch (NullPointerException npException) {
                        JOptionPane.showMessageDialog(null, "Must have a client to play");
                    }
                }
            }
        });

        contentPane.getBtn4().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if(thisPlayer==player){
                    try{
                        sendAction(4);  
                        btn4ActionPerformed();
                    }catch (NullPointerException npException) {
                        JOptionPane.showMessageDialog(null, "Must have a client to play");
                    }
                }
            }
        });

        contentPane.getBtn5().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if(thisPlayer==player){
                    try{
                        sendAction(5);
                        btn5ActionPerformed();
                    }catch (NullPointerException npException) {
                        JOptionPane.showMessageDialog(null, "Must have a client to play");
                    }
                }
            }
        });

        contentPane.getBtn6().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if(thisPlayer==player){
                    try{
                        sendAction(6);  
                        btn6ActionPerformed();
                    }catch (NullPointerException npException) {
                        JOptionPane.showMessageDialog(null, "Must have a client to play");
                    }
                }
            }
        });

        contentPane.getBtn7().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if(thisPlayer==player){
                    try{
                        sendAction(7);  
                        btn7ActionPerformed();
                    }catch (NullPointerException npException) {
                        JOptionPane.showMessageDialog(null, "Must have a client to play");
                    }
                }
            }
        });

        contentPane.getBtn8().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if(thisPlayer==player){
                    try{
                        sendAction(8);  
                        btn8ActionPerformed();
                    }catch (NullPointerException npException) {
                        JOptionPane.showMessageDialog(null, "Must have a client to play");
                    }
                }
            }
        });

        contentPane.getBtn9().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if(thisPlayer==player){
                    try{
                        sendAction(9);
                        btn9ActionPerformed(); 
                    }catch (NullPointerException npException) {
                        JOptionPane.showMessageDialog(null, "Must have a client to play");
                    }
                }
            }
        });

    }          


    public void btn1ActionPerformed() {   
        contentPane.getBtn1().setText(""+player);
        anybtnclicked(); 

    }  
    public void btn2ActionPerformed() {   
        contentPane.getBtn2().setText(""+player);
        anybtnclicked();   
    }  
    public void btn3ActionPerformed() {  
        contentPane.getBtn3().setText(""+player);
        anybtnclicked();   
    }  
    public void btn4ActionPerformed() {   
        contentPane.getBtn4().setText(""+player);
        anybtnclicked(); 
    }  
    public void btn5ActionPerformed() {   
        contentPane.getBtn5().setText(""+player);
        anybtnclicked();  
    }  
    public void btn6ActionPerformed() {   
        contentPane.getBtn6().setText(""+player);    
        anybtnclicked(); 
    }          
    public void btn7ActionPerformed() {    
        contentPane.getBtn7().setText(""+player); 
        anybtnclicked();  
    }  
    public void btn8ActionPerformed() {   
        contentPane.getBtn8().setText(""+player);
        anybtnclicked(); 
    }  
    public void btn9ActionPerformed() {   
        contentPane.getBtn9().setText(""+player);
        anybtnclicked();   
    }  


    private void anybtnclicked() {   
        player = player==1 ?2:1;   
        clicks++;
        makeEnable();
        if(checkVictory(contentPane,"1")){
            Result result= new Result(host,isServer);
            result.setTitle(isServer?"Server":"Client");
            result.getPlayertxt().setText("Player 1");
            result.getResulttxt().setText("Won the Game");
            result.setVisible(true);
            frame.dispose();
            if(isServer){
                T1.interrupt();
                T1.closeServer();
            }else{
                T2.interrupt();
            }
        }else if(checkVictory(contentPane,"2")){
            Result result= new Result(host,isServer);
            result.setTitle(isServer?"Server":"Client");
            result.getPlayertxt().setText("Player 2");
            result.getResulttxt().setText("Won the Game");
            result.setVisible(true);
            frame.dispose();
            if(isServer){
                T1.interrupt();
                T1.closeServer();
            }else{
                T2.interrupt();
            }
        }else if(clicks==9){
            Result result= new Result(host,isServer);
            result.setTitle(isServer?"Server":"Client");
            result.getPlayertxt().setText("Game Draw");
            result.getResulttxt().setText("");
            result.setVisible(true);
            frame.dispose();
            if(isServer){
                T1.interrupt();
                T1.closeServer();
            }else{
                T2.interrupt();
            }
        }
    }

    private void sendAction(int value) throws NullPointerException{
        System.out.println("going to send data");
        Socket other;
        if(isServer){
          other = T1.socket;
        }else{
          other = T2.client; 
        }
        System.out.println("finished getting socket");
        System.out.println("is server"+isServer);
        try {
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(other.getOutputStream()));
          bw.write(""+value+"\n");            
          bw.flush(); 
          System.out.println("finished writting "+ value);
        } catch (IOException iOException) {

        }

    }

    private void makeEnable(){
        if(!contentPane.getBtn1().getText().trim().equals("")){
            contentPane.getBtn1().setEnabled(false);
        }else{
            contentPane.getBtn1().setEnabled(true);
        }
        if(!contentPane.getBtn2().getText().trim().equals("")){
            contentPane.getBtn2().setEnabled(false);
        }else{
            contentPane.getBtn2().setEnabled(true);
        }
        if(!contentPane.getBtn3().getText().trim().equals("")){
            contentPane.getBtn3().setEnabled(false);
        }else{
            contentPane.getBtn3().setEnabled(true);
        }
        if(!contentPane.getBtn4().getText().trim().equals("")){
            contentPane.getBtn4().setEnabled(false);
        }else{
            contentPane.getBtn4().setEnabled(true);
        }
        if(!contentPane.getBtn5().getText().trim().equals("")){
            contentPane.getBtn5().setEnabled(false);
        }else{
            contentPane.getBtn5().setEnabled(true);
        }
        if(!contentPane.getBtn6().getText().trim().equals("")){
            contentPane.getBtn6().setEnabled(false);
        }else{
            contentPane.getBtn6().setEnabled(true);
        }
        if(!contentPane.getBtn7().getText().trim().equals("")){
            contentPane.getBtn7().setEnabled(false);
        }else{
            contentPane.getBtn7().setEnabled(true);
        }
        if(!contentPane.getBtn8().getText().trim().equals("")){
            contentPane.getBtn8().setEnabled(false);
        }else{
            contentPane.getBtn8().setEnabled(true);
        }
        if(!contentPane.getBtn9().getText().trim().equals("")){
            contentPane.getBtn9().setEnabled(false);
        }else{
            contentPane.getBtn9().setEnabled(true);
        }
    }


    private boolean checkVictory(GameView contentPane, String player) {
        boolean match=false;
        if(
            (contentPane.getBtn1().getText().equals(player) && contentPane.getBtn2().getText().equals(player) && contentPane.getBtn3().getText().equals(player)) || 
            (contentPane.getBtn4().getText().equals(player) && contentPane.getBtn5().getText().equals(player) && contentPane.getBtn6().getText().equals(player)) ||
            (contentPane.getBtn7().getText().equals(player) && contentPane.getBtn8().getText().equals(player) && contentPane.getBtn9().getText().equals(player)) ||
            (contentPane.getBtn1().getText().equals(player) && contentPane.getBtn4().getText().equals(player) && contentPane.getBtn7().getText().equals(player)) ||
            (contentPane.getBtn2().getText().equals(player) && contentPane.getBtn5().getText().equals(player) && contentPane.getBtn8().getText().equals(player)) ||
            (contentPane.getBtn3().getText().equals(player) && contentPane.getBtn6().getText().equals(player) && contentPane.getBtn9().getText().equals(player)) ||
            (contentPane.getBtn1().getText().equals(player) && contentPane.getBtn5().getText().equals(player) && contentPane.getBtn9().getText().equals(player)) ||
            (contentPane.getBtn3().getText().equals(player) && contentPane.getBtn5().getText().equals(player) && contentPane.getBtn7().getText().equals(player))
            )
        {
            match=true;
        }
        return match;
    }

}
