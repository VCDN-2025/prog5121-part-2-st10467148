/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp;


/**
 *
 * @author Nikhil
 */
// Classwork [Accessed 19 April 2025]
public class ChatAppUser {
   
  String userUserName;
  String userPassword;
  String userPhoneNumber;
    
    // Classwork [Accessed 19 April 2025]
    public ChatAppUser(String userUserName, String userPassword, String userPhoneNumber )
   
    {
        this.userUserName = userUserName;
        this.userPassword = userPassword;
        this.userPhoneNumber = userPhoneNumber;
    }
    
    public boolean checkUserName()
    {
        /** Ram N Java., 19 Nov 2017. How to Write a Regex to Validate Usernames? | Java Regex | Regex in java.
        Available at:
        <https://www.youtube.com/watch?v=xYCbzomotRk>
        [Accessed 19 April 2025]. 
        */
        
        String regexUsername = "^(?=.*_).{1,5}$";
        boolean isUserNameValid = userUserName.matches(regexUsername);
        return isUserNameValid;  
    }
    
   
     
    public boolean checkPasswordComplexity()
    {
        
        /** Tech Tv., 19 Apr 2020. JAVA PASSWORD REGEX VALIDATION FOR BEGINNERS IN STEP BY STEP
        Available at:
        <https://www.youtube.com/watch?v=51kucM2SMp8> 
        [Accessed 19 April 2025]. 
        */
        
        String regexPassword = "^(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+-={}:;\"'<>,.?/~`|]).{8,}$";
        boolean isPasswordValid = userPassword.matches(regexPassword);
        return isPasswordValid;
    }    
   
    
    public boolean checkCellPhonenumber()
    {
        //OpenAI. (2025). ChatGPT
        //https://chatgpt.com/share/68074f73-dbf4-8010-b56a-2b7bf21c5463
        String regexPhone =  "\\+27\\d{9}";
        boolean isPhoneValid = userPhoneNumber.matches(regexPhone);
        return isPhoneValid;
    }    
    
    // Classwork [Accessed 19 April 2025]
    public String registerUser()
    {
         if (checkUserName()==true)
         {
             
             if (checkPasswordComplexity()==true)
             {
                 if (checkCellPhonenumber()==true)
                 {
                     return "Username and Password have been registered successfully.";
                 }
                
                 else
                 {
                     return "Cellphone number is not formatted correctely or is not a South African Number";
                    
             
                 }
                
             }
             
             else
             {
                 return "Password is not\n" +
                        "correctly formatted,\n" +
                        "please ensure that\n" +
                        "At least eight characters long.\n" +
                        "Contain a capital letter.\n" +
                        "Contain a number.\n" +
                        "Contain a special character.";   
             }
         }
         
         else
         {
             return "Username is not\n" +
                    "correctly formatted,\n" +
                    "please ensure that\n" +
                    "your username\n" +
                    "contains an\n" +
                    "underscore and is no\n" +
                    "more than five\n" +
                    "characters in length.\" ";
         }    
    } 
    
   
    // Classwork [Accessed 19 April 2025]
    public boolean LoginUser(String UsernameInput, String PasswordInput)
{
        boolean usernameMatch = userUserName.equals (UsernameInput);
        boolean passwordMatch = userPassword.equals (PasswordInput);

        if (usernameMatch && passwordMatch == true)
    
        {
        return true;
        }                        
          else
        {  
        return false;
        }
}

// Classwork [Accessed 19 April 2025]
public String returnLoginStatus(boolean loginsuccessful)
        
        
{
        if (loginsuccessful == true)   
        { 
        return "Welcome " + userUserName + " It is great to see you again."  ;  
        }
        else
 
        return "Username or password is incorrect, please try again";
   
}

}  
