/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverproject;

//import import java.awt.Color;
import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.xml.bind.JAXBException;

/**
 *
 * @author Admin
 */
public class ServerProject {
  public static UserInformation CustomerInfo;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         ServerThread[] ServerThreadArray;
           ServerThreadArray = new ServerThread[10];
                   
                ServerThreadArray[0] = new ServerThread();
               ServerThreadArray[0].start();
        // TODO code application logic here
    }
    
    public static JFrame InitSetUpFrame(JFrame Frame)
    {
            Frame = new JFrame("SERver");
            Frame.setBackground(Color.yellow);
            Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Frame.setVisible(true);
            Frame.setBounds(250, 250, 250, 250);
            return Frame;
    }
    public static ContainerPanel InitSetUpPanel(ContainerPanel Panel, JFrame Frame)
    {
          //  Panel = new DefaultPanel();
            
            Panel = new ContainerPanel(Frame);
            Panel.setBackground(Color.yellow);
            Panel.setVisible(true);
            Frame.add(Panel);
            return Panel;
            
    }
     public static class ServerThread extends Thread 
    {
        @Override
        public void run()
        {
           String FileName = "C:\\Users\\Admin\\Documents\\GitHub\\ServerProject\\src\\serverproject\\ServerXML.xml";
           CustomerInfo = new UserInformation();
           CustomerInfo.Name = "Jill Stein";
           CustomerInfo.age  = 6245;
           XMLFileController.XMLWrite(CustomerInfo, FileName);
            JFrame Frame = null;
            ContainerPanel Panel = null;
            
            Frame =   InitSetUpFrame(Frame);
            Panel =   InitSetUpPanel(Panel,Frame);
           
            //Panel.Label.setText("Server");
            UserInformation OtherInfo = new UserInformation();
            try {
             OtherInfo =  XMLFileController.XMLReader(FileName);
            } catch (JAXBException ex) {
                Logger.getLogger(ServerProject.class.getName()).log(Level.SEVERE, null, ex);
            }
         DefaultServer Server = new DefaultServer();
            try {
                Server.listen();
            } catch (IOException ex) {
                Logger.getLogger(ServerProject.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("here is what is in the file");
             System.out.println(OtherInfo.Name);
              System.out.println(OtherInfo.age);
        }
        
    }
}
