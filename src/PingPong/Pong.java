/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PingPong;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import sockets.Servidor;

/**
 *
 * @author luisza
 */
public class Pong {

    private ServerSocket serverSocket;
    private int port;
    private boolean seguir;

    public Pong(int port) {
        this.port = port;
        seguir = true;
        inicializar_servidor();
    }

    private void inicializar_servidor() {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String get_respuesta(Socket server) {
        String respuesta = null;
        DataInputStream in;
        try {
            in = new DataInputStream(server.getInputStream());
            String leido = in.readUTF();
            System.out.println("Recibido: " + leido);
            if (leido.equals("Ping")) {
                respuesta = "Pong";
            } else {
                respuesta = "Ping";
            }
        } catch (Exception ex) {
            respuesta = null;
        }
        return respuesta;
    }

    private void correr_con_throws() throws IOException {
        System.out.println("Esperando clientes en el puerto: "
                + serverSocket.getLocalPort() + "...");

        Socket server = serverSocket.accept();
        while (seguir) {
            String respuesta = get_respuesta(server);
            if (respuesta != null) {
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                out.writeUTF(respuesta);
            } else {
                seguir = false;
            }
        }
        server.close();

    }

    public void correr() {
        try {
            correr_con_throws();
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void parar() {
        seguir = false;
    }

}
