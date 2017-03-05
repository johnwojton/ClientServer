/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.xml.bind.JAXBException;
import java.awt.CardLayout;

public class ContainerPanel extends JPanel implements KeyListener, ActionListener
{
    boolean LogInSuccessful = false;
     LoginScreen LS;
     DefaultPanel DP;
     JFrame Frame;
     CardLayout cardLayout;
     String CurrentUser = "";
     String CurrentPassword = "";
    public ContainerPanel(JFrame Frame)
    {
        super();
        repaint();
        this.Frame = Frame;
        this.setLayout(new CardLayout());
        LS = new LoginScreen(Frame, this);
         LS.EnterUserName.addActionListener(LS);
         LS.EnterPassword.addActionListener(LS);
         LS.EnterPassword.addKeyListener(LS);
         LS.EnterUserName.addKeyListener(LS);
        
        this.add(LS, "LogIn");
        cardLayout = (CardLayout) this.getLayout();
        cardLayout.show(this, "LogIn");
        repaint();
        
        
    }

    @Override
    public void keyTyped(KeyEvent ke) {
          int source;
      source =ke.getKeyCode();
      switch(source)
      {
          case KeyEvent.VK_ENTER:
              System.out.println("num 7");
          LS.User = LS.EnterUserName.getText();
          System.out.println(LS.User);         
          LS.PassWd = LS.EnterPassword.getText();
          System.out.println(LS.PassWd);
          LS.customer.Password = LS.PassWd;
          LS.customer.UserName = LS.User;
        {
            try {
                LS.customer =   XMLFileController.XMLReader(LS.FileName);
            } catch (JAXBException ex) {
                Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (LS.PassWd.equals(LS.customer.Password) && LS.User.equals(LS.customer.UserName))
        {
            System.out.println("num 4");
            this.remove(LS);
            this.add(DP);
        }
        else
        {
            System.out.println("i am locked out");
        }
           break;
        
      }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    @Override
    public void keyPressed(KeyEvent ke) {
          int source;
      source =ke.getKeyCode();
      switch(source)
      {
          case KeyEvent.VK_ENTER:
              System.out.println("num 7");
          LS.User = LS.EnterUserName.getText();
          System.out.println(LS.User);         
          LS.PassWd = LS.EnterPassword.getText();
          System.out.println(LS.PassWd);
          LS.customer.Password = LS.PassWd;
          LS.customer.UserName = LS.User;
        {
            try {
                LS.customer =   XMLFileController.XMLReader(LS.FileName);
            } catch (JAXBException ex) {
                Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (LS.PassWd.equals(LS.customer.Password) && LS.User.equals(LS.customer.UserName))
        {
            System.out.println("num 4");
            this.remove(LS);
          
            this.add(DP);
        }
        else
        {
            System.out.println("i am locked out");
        }
           break;
        
      }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

   }

    @Override
    public void keyReleased(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   public void LoggingIn()
    {
            System.out.println("logging out");
            this.remove(LS);
              DP = new DefaultPanel(this.Frame);
            DP.setVisible(true);
           DP.setBounds( this.getBounds());
           DP.setEnabled(true);
          
            this.add(DP, "DefaultPanel");
            cardLayout = (CardLayout) this.getLayout();
            cardLayout.show(this, "DefaultPanel");
            //DP.validate();
            //DP.revalidate();
            repaint();
    }
            
}
