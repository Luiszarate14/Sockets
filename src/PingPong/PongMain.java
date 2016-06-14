/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PingPong;


/**
 *
 * @author luisza
 */
public class PongMain {

        public static void main(String[] args) {
        Pong server = new Pong(9020);
        server.correr();
    }
    
}
