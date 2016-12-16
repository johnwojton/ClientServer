/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package networkingandconcurrency;


import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import javax.swing.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import networkingandconcurrency.NetworkingAndConcurrency.ServerThread.ClientThread;

/**
 *
 * @author Admin
 */
public class NetworkingAndConcurrency 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
          // ServerThread[] ServerThreadArray;
         //  ServerThreadArray = new ServerThread[10];
      
           ClientThread CThread = new ClientThread();
         //  ClientThread CThread1 = new ClientThread();
          // for(int i = 0; i< 1; i++)
                     
               // ServerThreadArray[0] = new ServerThread();
              // ServerThreadArray[0].start();
                
           CThread.start();
       
         
          
           
        // TODO code application logic here
    }
    public static JFrame InitSetUpFrame(JFrame Frame)
    {
            Frame = new JFrame("NEtworking and stuff");
            Frame.setBackground(Color.yellow);
            Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Frame.setVisible(true);
            Frame.setBounds(250, 250, 250, 250);
            return Frame;
    }
    public static DefaultPanel InitSetUpPanel(DefaultPanel Panel, JFrame Frame)
    {
            Panel = new DefaultPanel();
            Panel.setBackground(Color.yellow);
            Panel.setVisible(true);
            Frame.add(Panel);
            return Panel;
            
    }
    static void networking()
    {
        
    }
    public static class ServerThread extends Thread 
    {
        public void run()
        {
           
            JFrame Frame = null;
            DefaultPanel Panel = null;
            
            Frame =   InitSetUpFrame(Frame);
            Panel =   InitSetUpPanel(Panel,Frame);
            Panel.Label.setText("Server");
                 
     /*    DefaultClient Server = new DefaultClient();
            try {
                Server.listen();
            } catch (IOException ex) {
                Logger.getLogger(NetworkingAndConcurrency.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }*/
        
    }
         public static class test
    {
           
        test()
        {
            int x  = 0;
            String  my = "Adfas";
        }
    }
     public static class ClientThread extends Thread 
    {
            
         
         Socket s;
         InputStream Input;
        String Buffer = "John Wojton";
        char buffer[] = new char[1000];
        public void run()
        {
            //try {
                SocketAddress SA;
                //   SA = new InetSocketAddress(InetAddress.getLocalHost().getHostAddress(), 4000);
                String you = "Hello Mr. Server";
                JFrame Frame = null;
                DefaultPanel Panel = null;
                
                Frame =   InitSetUpFrame(Frame);
                Panel =   InitSetUpPanel(Panel,Frame);
                Panel.Label.setText("Client");
                try {
                    
                    
                    OutputStream Output;
                    
                    s = new Socket(InetAddress.getLocalHost().getHostAddress(), 4000);
                    //s.connect(new InetSocketAddress("192.168.1.9", 4000), 1000);
                    
                    //  s.connect(SA);
                    
                    Input = s.getInputStream();
                    
                    BufferedReader in =
                            new BufferedReader(
                                    new InputStreamReader(s.getInputStream()));
                    boolean result;
                    result = in.ready();
                    System.out.println(result);
                    
                    int read;
                    System.out.println("Reading");
                    read = in.read(buffer, 0, 1000);
                    System.out.println("Done Reading");
                    
                    
                    
                    
                    
                    Input  = s.getInputStream();
                    Output = s.getOutputStream();
                    
                    BufferedWriter out =
                            new BufferedWriter(
                                    new OutputStreamWriter(s.getOutputStream()));
                    System.out.println("Writing");
                    s.setSendBufferSize(20);
                    out.write(Buffer, 0, 11);
                   
                    out.flush();
                    System.out.println("ADFSADF");
                    
                    //  System.out.println(read);
                    System.out.println(buffer);
                    
                } catch (IOException ex) {
                    Logger.getLogger(NetworkingAndConcurrency.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            /*    test a = new test();
                
                File file = new File("C:\\Users\\Admin\\Documents\\GitHub\\ServerProject\\src\\serverproject\\file.xml");
                JAXBContext jaxbContext = JAXBContext.newInstance(a.getClass());
                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
                
                // output pretty printed
                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                
                jaxbMarshaller.marshal(a, file);
                jaxbMarshaller.marshal(a, System.out);
                /*     for(int i = 0; i <11; i++)
                {
                System.out.println(i);
                System.out.println(buffer[i]);
                }*/
             /*
            catch (JAXBException ex) {
                Logger.getLogger(NetworkingAndConcurrency.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        }
        
    }
    }
   
}
    

