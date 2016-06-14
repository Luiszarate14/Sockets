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
public class ClienteMain {
    
    public static void main(String[] args) {
        Cliente cliente = new Cliente(9020, "localhost");
        cliente.conectar();
    }    
    
}
