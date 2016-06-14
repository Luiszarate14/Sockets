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
public class PingMain {

    public static void main(String[] args) {
        Ping cliente = new Ping(9020, "localhost", "demo");
        cliente.simular_conversacion();
    }       
}
