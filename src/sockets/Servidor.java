package sockets;


import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luisza
 */
public class Servidor {
    private ServerSocket serverSocket;
    private int port;

    public Servidor(int port) {
      this.port = port;
      inicializar_servidor();
    }
    
    private void inicializar_servidor(){
        try {
            
            
            serverSocket = new ServerSocket(port);
            //serverSocket.setSoTimeout(10000); 
        
        
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void correr_con_throws() throws IOException{
        System.out.println("Waiting for client on port " +
        serverSocket.getLocalPort() + "...");
        
        while(true){
            Socket server = serverSocket.accept();
            System.out.println("Just connected to "
                  + server.getRemoteSocketAddress());
            DataInputStream in =
                  new DataInputStream(server.getInputStream());
            
            System.out.println(in.readUTF());
            
            DataOutputStream out =
                 new DataOutputStream(server.getOutputStream());
            
            out.writeUTF("Thank you for connecting to "
              + server.getLocalSocketAddress() + "\nGoodbye!");
            
            server.close();
        }
 
    }
    
    
    public void correr(){
        try {
            correr_con_throws();
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
