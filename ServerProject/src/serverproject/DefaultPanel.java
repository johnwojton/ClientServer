/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverproject;
import javax.swing.JPanel;
import javax.swing.*;
/**
 *
 * @author Admin
 */

public class DefaultPanel extends JPanel
{ 
   public JLabel Label;
   DefaultPanel()
   {
       super();
      Label = new JLabel("Label");
       this.add(Label);
   }
}
