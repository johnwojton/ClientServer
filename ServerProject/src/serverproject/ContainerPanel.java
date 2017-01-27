/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverproject;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.xml.bind.JAXBException;


public class ContainerPanel extends JPanel implements KeyListener
{
    boolean LogInSuccessful = false;
     LoginScreen LS;
     DefaultPanel DP;
    public ContainerPanel(JFrame Frame)
    {
        super();
        LS = new LoginScreen(Frame);
        DP = new DefaultPanel();
        this.add(LS);
        
        
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
          int source;
      source =ke.getKeyCode();
      switch(source)
      {
          case KeyEvent.VK_ENTER:
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
            this.remove(LS);
            this.add(DP);
        }
           break;
        
      }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

   }

    @Override
    public void keyReleased(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
