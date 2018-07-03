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
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author Jagadheesan Balu
 */
public class ServerWindow {
    
    public static void main(String args[]) throws UnknownHostException, IOException {
        
        ServerSocket servSocket = new ServerSocket(5000);
        System.out.println("Server ready to chat");
        Socket socket = servSocket.accept();
        
        //Read from keyboard
        BufferedReader keyReader = new BufferedReader(new InputStreamReader(System.in));
        
        //send to server
        OutputStream outStream = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(outStream, true);
        
        //receive from server
        InputStream inStream = socket.getInputStream();
        BufferedReader receiveReader = new BufferedReader(new InputStreamReader(inStream));
        
        String sendMsg,recieiveMsg;
              
        //System.out.println("Stest :"+receiveReader.readLine());
        while(true) {
            //receive
            if((recieiveMsg = receiveReader.readLine()) !=null ) {
                System.out.println("Received Msg :"+recieiveMsg);
            }
            
            //send
            sendMsg= keyReader.readLine();
            writer.println(sendMsg);
            //writer.flush();
        }   
        
    }
}