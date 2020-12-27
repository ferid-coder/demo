/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpserver;

import java.io.*;
import java.net.*;

/**
 *
 * @author ferid
 */
public class TCPServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        ServerSocket ourFirstSocket = new ServerSocket(6788);

        while (true) {
            Socket connection = ourFirstSocket.accept();
            InputStream is = connection.getInputStream();
            InputStreamReader reader = new InputStreamReader(is);
            BufferedReader bReader = new BufferedReader(reader);
            String messageFromClient = bReader.readLine();
            System.out.println("Message: " + messageFromClient);
        }
    }

}
