/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverproject;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.*;


public class LoginScreen extends JPanel
{
  public LoginScreen(JFrame Frame)
   {
        super();
        this.setBackground(Color.MAGENTA);
        JLabel Title    = new JLabel("BMI Calculator!");
        JLabel UserName = new JLabel("User Name");
        JLabel Password = new JLabel("Password");

        JTextField EnterUserName = new JTextField(30);
        JTextField EnterPassword = new JTextField(30);
        this.setLayout(new FlowLayout());
        
        this.add(Title);
        this.add(UserName);
        this.add(EnterUserName);
        this.add(Password);
        this.add(EnterPassword);
        
        this.setSize(Frame.getHeight() - 400, Frame.getWidth());
   }
   

    
}
