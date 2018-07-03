/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author Jagadheesan Balu
 */
public class ClientWindow {
    
    public static void main(String args[]) throws UnknownHostException, IOException {
        
        Socket socket = new Socket("127.0.0.1", 5000);
        
        //Read from keyboard
        BufferedReader keyReader = new BufferedReader(new InputStreamReader(System.in));
        
        //send to server
        OutputStream outStream = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(outStream, true);
        
        //receive from server
        InputStream inStream = socket.getInputStream();
        BufferedReader receiveReader = new BufferedReader(new InputStreamReader(inStream));
        
        System.out.println("Start the chitchat, type and press Enter key");
        
        String sendMsg,recieiveMsg;
           
        while(true) {
            //send
            sendMsg= keyReader.readLine();
            writer.println(sendMsg);
            //writer.flush();

            //receive
            if((recieiveMsg = receiveReader.readLine()) !=null ) {
                System.out.println("Received Msg :"+recieiveMsg);
            }
        }   
        
    }
}
