/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverproject;
import java.awt.Color;
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
    int age_int;
    int weight_int;
   enum Gender 
           { 
               male, female
           };
                   
    
   public JLabel height;
   public JLabel Label;
   public JLabel Gender;
   public JLabel Age;
   public JLabel weight;
   
   public JRadioButton Male;
   public JRadioButton Female;
   public JButton      Calculate;
   
   public JTextField HeightText;
   public JTextField AgeText;
   public JTextField WeightText;
   Gender gender;
   
   
   DefaultPanel(JFrame Frame)
   {
       super();
     this.initVariables();
     this.addVariables();
      this.setBackground(Color.WHITE);
       System.out.println("the width is " + this.getWidth());
        this.setSize(Frame.getHeight() - 400, Frame.getWidth());
       repaint();
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
        else if (source == Calculate)
        {
          age_int    = Integer.parseInt(Age.getText());
          weight_int = Integer.parseInt(weight.getText());
        }
    }
    
    
    
    
    void initVariables()
    {
          
      Label      = new     JLabel ("Label");
      Gender     = new     JLabel("Gender");
      Age        = new     JLabel   ("Age");
      weight     = new     JLabel("Weight");
      WeightText = new         JTextField();
      AgeText    = new         JTextField();  
      Calculate  = new JButton("Calculate");
      HeightText = new         JTextField();
      height     = new     JLabel("Height");
      
      Calculate.setVisible(true);
      AgeText.setVisible(true);
      WeightText.setVisible(true);
      Gender.setVisible(true);
      Age.setVisible(true);
      weight.setVisible(true);
      HeightText.setVisible(true);
      height.setVisible(true);
      
      
      Calculate.setBounds(130, 150, 150, 50);
      WeightText.setBounds(110,  105, 50, 20);
      AgeText.setBounds(110, 85, 50, 20);
      Gender.setBounds(50, 50, 50, 50);
      Age.setBounds(50, 70, 50, 50);
      weight.setBounds(50, 90, 50, 50);
      height.setBounds(50, 110, 50, 50);
      HeightText.setBounds(110, 125, 50, 20);
      
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
      WeightText.addActionListener(this);
      AgeText.addActionListener(this);
      Calculate.addActionListener(this);
      
      ButtonGroup BG = new ButtonGroup();
      
      BG.add(Male);
      BG.add(Female);
      
      
    }
    void addVariables()
    {
       this.add(Calculate);
       this.add(Label);
       this.add(Gender);
       this.add(Age);
       this.add(weight);
       this.setLayout(null);
       this.add(AgeText);
       this.add(WeightText);
       this.add(Male);
       this.add(Female);
       this.add(height);
       this.add(HeightText);
    }
    
    
    
    
}




    