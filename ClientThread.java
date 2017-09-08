/*
Tic Tac Toe Multiplayer 
Author: E/14/009 Adikari A.M.H.I @ EFAC, University of Peradeniya
Date:30/08/2017
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class ClientThread extends Thread { 

   private Thread t; 
   private String threadName; 
   private GameController game;
   private String host;
   private int port;
   Socket client;

  public static final int BASE_PORT = 1250;     
  private ServerSocket serverSocket; 
    
   ClientThread( GameController game,String host,int port){ 
       this.game = game;
       threadName = "clientThread"; 
       this.host=host;
       this.port=port;
   } 
  @Override
  public void run() { 
       
      try { 
        client_loop(); 
     } catch (Exception e) { 
     } 
   } 

 

  public void client_loop() throws IOException { 
    try {
          client = new Socket(host, port);
          BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream())); 
          String line;  
          for(line = br.readLine(); 
            line != null && !line.equals("quit"); 
            line = br.readLine()) { 
            btnaction(line);  
          } 
    } catch (IOException iOException) {
    }finally { 
      client.close();
    }
  }
   
 public void startt () 
   { 
      if (t == null) 
      { 
         t = new Thread (this, threadName); 
         t.start (); 
      } 
   }


   private void btnaction(String key){

      switch(key){
           case "1" :  if(game.contentPane.getBtn1().isEnabled()){
                           game.btn1ActionPerformed();
                        }
                        break;
           case "2" :  if(game.contentPane.getBtn2().isEnabled()){
                         game.btn2ActionPerformed();
                       }
                       break;
           case "3" :  if(game.contentPane.getBtn3().isEnabled()){
                         game.btn3ActionPerformed();
                       }
                       break;
           case "4" :  if(game.contentPane.getBtn4().isEnabled()){
                         game.btn4ActionPerformed();
                       }
                       break;
           case "5" :  if(game.contentPane.getBtn5().isEnabled()){
                         game.btn5ActionPerformed();
                       }
                       break;
           case "6" :  if(game.contentPane.getBtn6().isEnabled()){
                         game.btn6ActionPerformed();
                       }
                       break;
           case "7" :  if(game.contentPane.getBtn7().isEnabled()){
                         game.btn7ActionPerformed();
                       }
                       break;
           case "8" :  if(game.contentPane.getBtn8().isEnabled()){
                         game.btn8ActionPerformed();
                       }
                       break;
           case "9" :  if(game.contentPane.getBtn9().isEnabled()){
                         game.btn9ActionPerformed();
                       }
                       break;
      }
   } 

 
} 

 