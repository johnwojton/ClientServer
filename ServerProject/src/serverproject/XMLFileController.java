/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
package serverproject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import serverproject.UserInformation;


public class XMLFileController 
{
    public static void XMLWrite()
    {
     ////   Date DOB = null;
      //  DOB.setTime(1243);
       // DOB.setDate(2452);
     UserInformation customer = new UserInformation();
      customer.setName("jack");
      customer.setDOB(null);
      customer.setAge(34);

      try {

        File file = new File("C:\\Users\\Admin\\Documents\\GitHub\\ServerProject\\src\\serverproject\\ServerXML.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(UserInformation.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        // output pretty printed
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        jaxbMarshaller.marshal(customer, file);
        jaxbMarshaller.marshal(customer, System.out);

          } catch (JAXBException e) {
        e.printStackTrace();
          }

    }
    public static UserInformation XMLReader(String FileName) throws JAXBException
    {
            JAXBContext jc = JAXBContext.newInstance(UserInformation.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        UserInformation USERInfo;
        USERInfo = (UserInformation) unmarshaller.unmarshal(new File(FileName));

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(USERInfo, System.out);
        System.out.println(USERInfo.Name);
        System.out.println(USERInfo.age);
       return USERInfo;
    }
          
    }

