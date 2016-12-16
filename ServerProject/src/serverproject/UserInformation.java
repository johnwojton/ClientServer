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
    
}
