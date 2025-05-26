/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chatapp;

import javax.swing.JOptionPane;

/**
 *
 * @author Nikhil
 */
// Classwork [Accessed 19 April 2025]
public class ChatApp {
    
public static void main(String[] args) {
   
    String userName = JOptionPane.showInputDialog("Create a Username: \nUsername must contain an underscore (_)\nand be no longer than five characters long");
    String Password = JOptionPane.showInputDialog("""
                                                  Create a Password 
                                                  The password must be: 
                                                  At least eight characters long.
                                                  Contain a capital letter.
                                                  Contain a number.
                                                  Contain a special character.""");
    String phoneNumber = JOptionPane.showInputDialog("Enter your phone number (+27)");
    
    ChatAppUser User = new ChatAppUser (userName, Password, phoneNumber);
   
    
    String registerMessage = User.registerUser();
    JOptionPane.showMessageDialog(null, registerMessage);
    
   
    if(User.checkUserName() && User.checkPasswordComplexity() ==true)
    { 
        String LoginUserName = JOptionPane.showInputDialog("Enter your registered username");
        String loginPassword = JOptionPane.showInputDialog("Enter your registered password");
        
       boolean isLoginsuccessful =  User.LoginUser(LoginUserName,loginPassword);
       String loginStatus = User.returnLoginStatus(isLoginsuccessful);
       JOptionPane.showMessageDialog(null, loginStatus);
       //END OF PART 1
       
       
       
       //PART 2
       
       // Classwork [Accessed 26 April 2025]
       while(isLoginsuccessful == true)
       {
           String choice = JOptionPane.showInputDialog("""
                                                       welcome to QuickChat.
                                                       1. Send Messages
                                                       2. Show recently sent messages
                                                       3. Quit
                                                       """);
           
           switch (choice)
           {
               case "1":
                   
                   
                    String recipient =  JOptionPane.showInputDialog(null, "Enter your Phone Number");
                    int userNumberMessages = Integer.parseInt(JOptionPane.showInputDialog("How many messages do you want to send?"));
                    String mainMessage = JOptionPane.showInputDialog("""
                                                                     Enter your Message
                                                                     The message should not exceed 250 characters""");
                       
                       
                       Message Message = new Message(recipient,userNumberMessages,mainMessage);
                       
                       
                       
                               
                       Message.sendMessage();
                               
                       break;
               case "2":
                    
                   JOptionPane.showMessageDialog(null, "Coming Soon.");
               case "3":
                   isLoginsuccessful = false;
                   break;
      
       
       
            }
    
       }
    }
    
    
}
}
    
    





