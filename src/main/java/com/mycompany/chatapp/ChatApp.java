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
    String Password = JOptionPane.showInputDialog("Create a Password \nThe password must be: \n" +
        "At least eight characters long.\n" +
        "Contain a capital letter.\n" +
        "Contain a number.\n" +
        "Contain a special character.");
    String phoneNumber = JOptionPane.showInputDialog("Enter your phone number (+27)");
    
    ChatAppUser User = new ChatAppUser (userName, Password,phoneNumber);
   
    
    String registerMessage = User.registerUser();
    JOptionPane.showMessageDialog(null, registerMessage);
    
   
    if(User.checkUserName() && User.checkPasswordComplexity() ==true)
    { 
        String LoginUserName = JOptionPane.showInputDialog("Enter your registered username");
        String loginPassword = JOptionPane.showInputDialog("Enter your registered password");
        
       boolean isLoginsuccessful =  User.LoginUser(LoginUserName,loginPassword);
       String loginStatus = User.returnLoginStatus(isLoginsuccessful);
       JOptionPane.showMessageDialog(null, loginStatus);
    }
    
    }




}
