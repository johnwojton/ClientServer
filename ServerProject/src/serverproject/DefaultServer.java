/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverproject;
import java.io.*;
import java.net.*;
import java.net.ServerSocket;
import java.io.File;
import java.io.IOException;
import javax.xml.*;



public class DefaultServer  
{
    
  

    public void listen() throws IOException
    {
        char buffer2[] = new char[1000];
      char buffer[] = {'J','o','n',' ','W','o','j','t','o','n'};
      String Buffer = "John Wojton";
        OutputStream Output;
        InputStream Input;
        ServerSocket Server = null;
       System.out.println(buffer.length);
        Server = new ServerSocket(4000);
        
        Server.setReuseAddress(true);
        Server.getLocalPort();
        Server.setSoTimeout(0);
        while(true)
        {
            System.out.println("Hello");
           
            Socket socket = null;
            while(socket == null)
            {
                
               socket = Server.accept();
               boolean isConnected = socket.isConnected();
               System.out.println(isConnected);
            
            }
           
            
            Input  = socket.getInputStream();
            Output = socket.getOutputStream();
              
           BufferedWriter out =
           new BufferedWriter(
           new OutputStreamWriter(socket.getOutputStream()));
           System.out.println("Writing");
           socket.setSendBufferSize(20);
           out.write(Buffer, 0, 11);
           out.flush();
           
           Socket s;
           
              s = new Socket(InetAddress.getLocalHost().getHostAddress(), 4000);
                  //s.connect(new InetSocketAddress("192.168.1.9", 4000), 1000);
                    
                //  s.connect(SA);
               
                Input = socket.getInputStream();
                
                 BufferedReader in =
                 new BufferedReader(
                 new InputStreamReader(socket.getInputStream()));
               boolean result;
                result = in.ready();
                System.out.println(result);
               
                 int read;
                 System.out.println("Reading");
                read = in.read(buffer2, 0, 10);
                
                System.out.println("Done Reading");
             
                
                System.out.println(read);
                System.out.println(buffer2);
           
           
           
           
           System.out.println("Done");
          
        }
       

    }
}