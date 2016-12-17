/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverproject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.*;
/**
 *
 * @author Admin
 */

public class DefaultPanel extends JPanel implements ActionListener
{ 
   enum Gender 
           { 
               male, female
           };
                   
    
   public JLabel Label;
   public JLabel Gender;
   public JLabel Age;
   public JLabel weight;
   
   public JRadioButton Male;
   public JRadioButton Female;
   Gender gender;
   DefaultPanel()
   {
       super();
       
      Label  = new JLabel ("Label");
      Gender = new JLabel("Gender");
      Age    = new JLabel   ("Age");
      weight = new JLabel("Weight");
      
      Gender.setVisible(true);
      Age.setVisible(true);
      weight.setVisible(true);
      
      Gender.setBounds(50, 50, 50, 50);
      Age.setBounds(50, 70, 50, 50);
      weight.setBounds(50, 90, 50, 50);
      
      Male   = new JRadioButton  ("Male");
      Female = new JRadioButton("Female");
      
      Male.setVisible(true);
      Female.setVisible(true);
      
      Male.setBounds(100, 50, 65, 30);
      Male.setText("Male");
      Male.setSelected(true);
      Female.setBounds(175, 50, 75, 30);
      Female.setText("Female");
      Female.setSelected(false);
      
      Male.addActionListener(this);
      Female.addActionListener(this);
      
      ButtonGroup BG = new ButtonGroup();
      
      BG.add(Male);
      BG.add(Female);
      
      
       this.add(Label);
       this.add(Gender);
       this.add(Age);
       this.add(weight);
       this.setLayout(null);
       
      
       this.add(Male);
       this.add(Female);
       System.out.println("the width is " + this.getWidth());
       
   }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        Object source = ae.getSource();
        if(source == Male)
        {
            gender = gender.male;
            System.out.println("Male");
            ServerProject.CustomerInfo.gender = ServerProject.CustomerInfo.gender.male;
            XMLFileController.XMLWrite(ServerProject.CustomerInfo, "C:\\Users\\Admin\\Documents\\GitHub\\ServerProject\\src\\serverproject\\ServerXML.xml");
        }
        else if (source == Female)
        {
            
            gender = gender.female;
            System.out.println("Female");
            ServerProject.CustomerInfo.gender = ServerProject.CustomerInfo.gender.female;
            XMLFileController.XMLWrite(ServerProject.CustomerInfo, "C:\\Users\\Admin\\Documents\\GitHub\\ServerProject\\src\\serverproject\\ServerXML.xml");
       
        }
    }
}
