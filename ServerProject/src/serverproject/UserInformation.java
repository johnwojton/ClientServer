/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverproject;

import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@XmlRootElement
public class UserInformation 
{
     //@XmlElement(name="Name")
    String Name;
     //@XmlElement(name="DOB")
     Date DOB;
      // @XmlElement(name="age")
    int age;
     // @XmlElement(name="weight")
    int weight;
    // @XmlElement(name="height")
    int height;
    // @XmlElement(name="UserName")
    String UserName;
    // @XmlElement(name="Password")
    String Password;
    
    enum Gender
    {
        male, female
    };
    Gender gender;
    public void setWeight(int weight)
    {
        this.weight = weight;
    }
    public void setHeight(int height)
    {
        this.height = height;
    }
    public void setUserName(String UserName)
    {
        this.UserName = UserName;
    }
    public void setPassword(String Password)
    {
        this.Password = Password;
    }
    public void setGender(Gender gender)
    {
        this.gender = gender;
    }
    public void setName(String Tname)
    {
        Name = Tname;
    }
    public void setDOB(Date TDOB)
    {
        this.DOB = TDOB;
    }
    public void setAge (int TAge)
    {
        this.age = TAge;
    }
    public String getName()
    {
        return this.Name;
    }
    public Date getDOB()
    {
        return this.DOB;
    }
    public int getAge()
    {
        return this.age;
    }
    public Gender getGender()
    {
        return this.gender;
    }
     public String getUserName()
    {
       return this.UserName;
    }
    public String getPassword()
    {
       return this.Password;
    }
    public int getHeight()
    {
        return this.height;
    }
    public int getWeight()
    {
        return this.weight;
    }
    
}
