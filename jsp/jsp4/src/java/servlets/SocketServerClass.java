package servlets;
/*
 * SocketServerClass.java
 *
 * Created on 19 septembrie 2007, 15:20
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author neo_qs7
 */
import java.net.*;
import java.io.*;

public class SocketServerClass {
    
    /** Creates a new instance of SocketServerClass */
    public SocketServerClass() {
    }
  
    public static void main(String[] args)
    {
        try {
            int portNumber = 1234;
            try {
                portNumber = Integer.parseInt(System.getProperty("port"));
            } catch (Exception e) {
            }
            ServerSocket serv = new ServerSocket(portNumber);

            for (;;) {
                Socket sock = serv.accept();
                InputStream inStream = sock.getInputStream();
                int ch;
                while ((ch = inStream.read()) >= 0) {
                    System.out.print((char) ch);
                }
                sock.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
