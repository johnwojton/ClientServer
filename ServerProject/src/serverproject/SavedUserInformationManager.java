package serverproject;


import serverproject.UserInformation;
import java.io.File;
import java.net.URL;
import javax.xml.bind.JAXBException;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wojton
 * This class is to handle any interactions for information saved by the user..
 * examples: weight, height, age, ect...
 */
public class SavedUserInformationManager 
{
    SavedUserInformationManager()
    {
                
    }
    void SaveUserInfo(UserInformation customer) throws JAXBException
    {
        URL location = SavedUserInformationManager.class.getProtectionDomain().getCodeSource().getLocation();
           String FilePath =  location.getPath();
           FilePath += "UserData/";
           System.out.println(FilePath);
           
    File dir = new File(FilePath);
     boolean successful = false;
    if (dir.exists())
    {
        System.out.println("Directory Exists");
    }
    else
    {
       successful = dir.mkdir();
    }
    // attempt to create the directory here
    
    if (successful)
    {
      // creating the directory succeeded
      System.out.println("directory was created successfully");
    }
    else
    {
      // creating the directory failed
      System.out.println("failed trying to create the directory");
    }
   int CheckFileReturn = CheckFilesForUserData(FilePath, customer);
   int NumberOfFiles = getNumberofFiles (FilePath);
   if (CheckFileReturn == -1)
   {
       if (NumberOfFiles == 0)
       {
           FilePath += "UserData_" + 0;
           XMLFileController.XMLWrite(customer, FilePath);
       }
       else
       {
           FilePath += "UserData_" + (NumberOfFiles - 1);
           XMLFileController.XMLWrite(customer, FilePath);
       }
   }
   else
   {
       FilePath += "UserData_" + CheckFileReturn;
           XMLFileController.XMLWrite(customer, FilePath);
   }
  }
    /***
     @param Returns int for which file customer is in... -1 for not found
     **/
   int CheckFilesForUserData(String SourcePath, UserInformation customer) throws JAXBException
   {
       UserInformation CustomerInFile;
        
       int NumberOfFiles = 0;
       File path = new File(SourcePath);
       NumberOfFiles = getNumberofFiles(SourcePath);
       System.out.println(NumberOfFiles);
       if(NumberOfFiles == 0)
       {
           return -1;
       }
       for(int i = 0; i < NumberOfFiles; i++)
       {
           SourcePath += "UserData_" + i;
           CustomerInFile = XMLFileController.XMLReader(SourcePath);
          if(CustomerInFile.UserName.equalsIgnoreCase(customer.UserName))
          {
              return i;
          }
          else
          {
              return 5;
          }
           
       }
       return -1;
   }
  
   int getNumberofFiles (String path)
   {
       File Path = new File(path);
       return Path.listFiles().length;
    }
   
}
    
    

