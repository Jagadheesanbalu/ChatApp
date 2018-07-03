/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;


public class WishesClient
{
   public static void main(String args[]) throws Exception
   {
     Socket sock = new Socket("127.0.0.1", 5000);       
     String message1 = "Accept Best Wishes, Serverji";

     //Read from keyboard
        BufferedReader keyReader = new BufferedReader(new InputStreamReader(System.in));
        
     message1 = keyReader.readLine();
        
     OutputStream ostream = sock.getOutputStream();      
     PrintWriter writer = new PrintWriter(ostream, true);
     writer.print(message1);
     //DataOutputStream dos = new DataOutputStream(ostream);
     
     //dos.writeBytes(message1);
     writer.close();
     //dos.close();                            
     ostream.close();   
     //sock.close();
  }
}