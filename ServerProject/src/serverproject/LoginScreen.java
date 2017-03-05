/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverproject;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.*;
import javax.xml.bind.JAXBException;


public class LoginScreen extends JPanel implements ActionListener, KeyListener
{
    JTextField EnterUserName;
    JTextField EnterPassword;
    String CurrentUserName = "";
    String CurrentPassword = "";
    String  User;
    String  PassWd;
    UserInformation customer;
    ContainerPanel CP;
     String FileName = "C:\\Users\\wojton\\Documents\\GitHub\\ClientServer\\ClientServer\\ServerProject\\src\\serverproject\\User02.xml";
  public LoginScreen(JFrame Frame, ContainerPanel CP)
   {
        super();
        this.CP = CP;
        customer = new UserInformation();
        this.setBackground(Color.MAGENTA);
        JLabel Title    = new JLabel("BMI Calculator!");
        JLabel UserName = new JLabel("User Name");
        JLabel Password = new JLabel("Password");

        EnterUserName = new JTextField(30);
        EnterUserName.setFocusable(true);
        EnterUserName.setEditable(true);

        EnterPassword = new JTextField(30);
        EnterPassword.setFocusable(true);
        EnterPassword.setEditable(true);
                
        this.setLayout(new FlowLayout());
        
        
        this.add(Title);
        this.add(UserName);
        this.add(EnterUserName);
        this.add(Password);
        this.add(EnterPassword);
        EnterUserName.addActionListener(this);
        EnterPassword.addActionListener(this);
        this.setSize(Frame.getHeight() - 400, Frame.getWidth());
   }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
           
    Object source;
      source =ae.getSource();
      if(source.equals(EnterUserName))
      {
          System.out.println("num 1");
          User = EnterUserName.getText();
          customer.UserName = User;
          System.out.println(User);
        try {
            customer =   XMLFileController.XMLReader(FileName);
        } catch (JAXBException ex) {
            Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
      else if (source.equals(EnterPassword))
      {
        try {
            User = EnterUserName.getText();
            customer.UserName = User;
            System.out.println("num 2");
            PassWd = EnterPassword.getText();
            System.out.println(PassWd);
            customer.Password = PassWd;
            
            customer =   XMLFileController.XMLReader(FileName);
            
            
            if (PassWd.equals(customer.Password) && User.equals(customer.UserName))
            {
                 System.out.println("num 4");
             //  this.remove(LS);
              // this.add(DP);
              this.CP.LoggingIn();
              this.CurrentUserName = User;
              this.CurrentPassword = PassWd;
              CP.CurrentUser = User;
              CP.CurrentPassword = PassWd;
            }
            else
            {
                 System.out.println("i am locked out");
            }
                          } catch (JAXBException ex) {
              Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
  
      }
   
          
     
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  
 
    
    
    }

    @Override
    public void keyTyped(KeyEvent ke) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
       System.out.println("KeyPRessed");
        int source;
      source =ke.getKeyCode();
      switch(source)
      {
          case KeyEvent.VK_ENTER:
              System.out.println("num 3");
          User = EnterUserName.getText();
          System.out.println("this is the user " + User);         
          PassWd = EnterPassword.getText();
          System.out.println("This is the Password " + PassWd);
          customer.Password = PassWd;
          customer.UserName = User;
           System.out.println("KeyPRessed01");
         
        {
            try {
                customer =   XMLFileController.XMLReader(FileName);
            } catch (JAXBException ex) {
                Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
      
           break;
        
      }
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   

    
}
