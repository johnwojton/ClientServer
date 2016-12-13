/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networkingandconcurrency;
import java.io.*;
import java.net.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DefaultServer  
{

  

    public void listen() throws IOException
    {
        char buffer2[] = null;
      char buffer[] = {'J','o','n',' ','W','o','j','t','o','n'};
      String Buffer = "John Wojton";
        OutputStream Output;
        InputStream Input;
        ServerSocket Server = null;
       System.out.println(buffer.length);
        Server = new ServerSocket(4000);
        
        Server.setReuseAddress(true);
        Server.getLocalPort();
        Server.setSoTimeout(10000);
        while(true)
        {
          
                System.out.println("Hello");
                
                Socket socket = null;
                while(socket == null)
                {
                    
                    socket = Server.accept();
                }
                
                Input  = socket.getInputStream();
                Output = socket.getOutputStream();
                
                BufferedWriter out =
                        new BufferedWriter(
                                new OutputStreamWriter(socket.getOutputStream()));
                System.out.println("Writing");
               
                out.write(Buffer, 0, 11);
                
                out.flush();
                   PrintWriter printout =
                        new PrintWriter(socket.getOutputStream(), true);
                    printout.println(new Date().toString());
                    printout.write(Buffer, 0, 11);
                    printout.flush();
                
                System.out.println("Done");
            } 
            }
          
        }
       

    
