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


class GameThread extends Thread { 

   private Thread t; 
   private String threadName; 
   private GameController game;
   Socket socket;

  public static final int BASE_PORT = 1250;     
  private ServerSocket serverSocket; 
    
   GameThread( GameController game){ 
       this.game = game;
       threadName = "gamethread"; 
   } 
  @Override
  public void run() { 
       
      try { 
        serverSocket = new ServerSocket(BASE_PORT); 
        server_loop(); 
     } catch (Exception e) { 
     } 
   } 

 

  public void server_loop() throws IOException { 
    while(true) { 
        socket = serverSocket.accept();   
        try { 
      handle(socket); 
        } catch (IOException e) { 
        } finally { 
      socket.close();
        }
    }
  }

private void handle(Socket socket) throws IOException { 
  BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
  BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); 
  String line; 
  for(line = in.readLine(); 
      line != null && !line.equals("quit"); 
      line = in.readLine()) { 

      if(line.trim().equals("check"+ game.thisPlayer)){
        bw.write("exist"+"\n");            
        bw.flush();
      }else if(line.trim().equals("check"+ (game.thisPlayer==1?2:1))) {
        bw.write("notexist"+"\n");            
        bw.flush();
      }else{
        btnaction(line); 
      }
  }
     
}

  public void closeServer(){
    try{
      serverSocket.close();
    } catch (IOException e) { 
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

 