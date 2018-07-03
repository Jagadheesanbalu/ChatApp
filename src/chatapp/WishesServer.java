/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp;

import java.io.BufferedReader;
import java.net.ServerSocket;            
import java.net.Socket;            
import java.io.InputStream;
import java.io.DataInputStream;
import java.io.InputStreamReader;

public class WishesServer
{
   public static void main(String args[]) throws Exception
   {
     ServerSocket sersock = new ServerSocket(5000); 
     System.out.println("server is ready");  //  message to know the server is running

     Socket sock = sersock.accept();               
                                                                                          
     InputStream istream = sock.getInputStream();  
     BufferedReader receiveReader = new BufferedReader(new InputStreamReader(istream));
     
     
     //DataInputStream dstream = new DataInputStream(istream);

     String message2 = receiveReader.readLine();
     System.out.println(message2);
     //dstream .close();
     receiveReader.close();
     istream.close();
     sock.close();
     sersock.close();
  }
}
