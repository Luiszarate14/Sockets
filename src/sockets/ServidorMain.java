/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;

/**
 *
 * @author luisza
 */
public class ServidorMain {

    public static void main(String[] args) {
        Servidor server = new Servidor(9020);
        server.correr();
    }
    
}
