/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PingPong;

import java.io.*;
import java.net.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author luisza
 */
public class Ping {
    
    private int port;
    private String serverName;
    private String name;
    Socket client;

    public Ping(int port, String serverName, String name) {
        this.port = port;
        this.serverName = serverName;
        this.name = name;
        conectar();
    }
 
    private void conectar(){

      System.out.println("Conectado a " + serverName + " en el puerto " + port);
      try
      {
         client = new Socket(serverName, port);
         System.out.println("La dirección remota obtenida es " 
		 + client.getRemoteSocketAddress());
         // La coneccion se hace por un puerto especifico, pero se negocia 
         // otro para no saturar el puerto
      }catch(IOException e)
      {
         e.printStackTrace();
      }
   }
    
    private void _hablar(String texto) throws IOException{
        OutputStream outToServer = client.getOutputStream();
        DataOutputStream out = new DataOutputStream(outToServer);
        out.writeUTF(texto);
    }
    
    public void hablar(){
        Random rand = new Random();
        String[] textos = new String[]{"Ping", "Pong"};
        int seleccionado = rand.nextInt(2);
        try {
            _hablar(textos[seleccionado]);
        } catch (IOException ex) {
            Logger.getLogger(Ping.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    private void _escuchar() throws IOException{
         InputStream inFromServer = client.getInputStream();
         DataInputStream in = new DataInputStream(inFromServer);
         System.out.println("Escuchando: "+in.readUTF());
    }
    
    public void escuchar(){
        try {
            _escuchar();
        } catch (IOException ex) {
            Logger.getLogger(Ping.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cerrar(){ 
        try {
            client.close();
        } catch (IOException ex) {
            Logger.getLogger(Ping.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    public void simular_conversacion(){
        for(int x=0; x<10; x++){
            hablar();
            escuchar();
        }
    
    }
}
