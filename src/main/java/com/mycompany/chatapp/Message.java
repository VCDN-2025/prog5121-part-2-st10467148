/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp;
import javax.swing.JOptionPane;
import org.json.JSONObject;
/**
 *
 * @author Nikhil
 * 
 */

// Classwork [Accessed 26 May 2025]
public class Message {
    String messageId;
    String recipientPhoneNumber;
    String userMessage;
    String messageHash;
    int numMessages; 
    
    
    
 // Classwork [Accessed 26 May 2025]   
public Message (String recipientPhoneNumber, int numMessages, String userMessage)
   
    {
        this.messageId = generateMessageID();
        this.recipientPhoneNumber = recipientPhoneNumber;
        this.userMessage = userMessage;
        this.messageHash = CreateMessageHash(messageId, messageId);
        this.numMessages = numMessages;
        
    }


// Classwork [Accessed 26 May 2025]
public String generateMessageID()
    {
        for (int i = 0; i < 10; i++)
        {
            messageId = " ";
            int digit = (int)(Math.random()*10);
            messageId += digit;
        }
            return messageId;
        
    }
    
// Classwork [Accessed 26 May 2025]
public boolean CheckmessageID()
    {
        String regexMessageId =  "^/d{10}";
        boolean isMessageIdValid = messageId.matches(regexMessageId);
        return isMessageIdValid;
    }


public boolean checkRecipientPhonenumber()
    {
        //OpenAI. (2025). ChatGPT
        //https://chatgpt.com/share/68074f73-dbf4-8010-b56a-2b7bf21c5463
        String regexPhoneNumber =  "\\+27\\d{9}";
        boolean isPhoneNumberValid = recipientPhoneNumber.matches(regexPhoneNumber);
        return isPhoneNumberValid;
    }    
    


// Classwork [Accessed 26 May 2025]
public String CreateMessageHash(String message, String id)
    {
        String extractedMessageId = message.substring(0, 2);
        String trimmedMessage = message.trim();
        String firstWord = trimmedMessage.substring(0, trimmedMessage.indexOf(" "));
        String lastWord = trimmedMessage.substring(trimmedMessage.lastIndexOf(" ") + 1);
        
        String hash = extractedMessageId+ ":" + numMessages+ ":"+ firstWord.toUpperCase() + lastWord.toUpperCase();   
        
        return hash;
    }
  




// Classwork [Accessed 26 May 2025]
public String sentMessage()
    {
        String choice = JOptionPane.showInputDialog("Message completed. Choose an option below\n"
                + "1. Send Message\n"
                + "2. Disregard Message\n"
                + "3.Store message and send later\n");
           
                switch (choice)
                {
                    case "1":
                      
                        JOptionPane.showMessageDialog(null, "Message sent");
                        break;
                    case "2":
                   
                        JOptionPane.showMessageDialog(null, "Message deleted");
                        break; 
                    case "3": 
                   
                        JOptionPane.showMessageDialog(null, "Message Stored");
                        break;
                        
                    default: 
                        JOptionPane.showMessageDialog(null, "Invalid Option");
                        break;
            }
        return choice;
    }
    

// Classwork [Accessed 26 May 2025]
public String printMessages()
    {
        
        String output = "Message ID :" +  messageId +
            "\nMessageHash: " + messageHash + 
            "\nRecipient: " + recipientPhoneNumber +
            "/n Message:" + userMessage;
                
        
        JOptionPane.showMessageDialog(null, output);
        return output;
    }
    



public int returnTotalMessages()
{
    return numMessages;  
        
}
    
//OpenAI. (2025). ChatGPT
//https://chatgpt.com/share/6834a6fa-fa54-800e-820b-70c72edf1914
/** VC Lecture Series, 21 May 2025. JSON - Java with Maven
Available at:
https://www.youtube.com/watch?v=XNjvJ-N1AJs
[Accessed 26 May 2025]. 
        */
public void storeMessage()
    {
        JSONObject jsonMessage = new JSONObject();
        jsonMessage.put("ID", messageId);
        jsonMessage.put("Number of Messages", numMessages);
        jsonMessage.put("Recipient", recipientPhoneNumber);
        jsonMessage.put("Message", userMessage);
        jsonMessage.put("Hash", messageHash);
    }
     
        
// Classwork [Accessed 26 May 2025]
public void sendMessage()
    {
        generateMessageID();
        
        if(checkRecipientPhonenumber()==false)
        {
            JOptionPane.showInputDialog(null, "Invalid Phone Number");
            return;
        }
        
        
        messageId = JOptionPane.showInputDialog("Enter your Message ID");
        if(CheckmessageID()==false)
        {
            JOptionPane.showInputDialog(null, "Invalid Message ID");
            return;
        }
        
        for (int i = 1; i <= numMessages; i++ )
        {
        
        if (userMessage.length() < 250)
        {
            JOptionPane.showMessageDialog(null, "Message should not exceed 250 characters");
        }
        
        else
        {    
        
        messageHash = CreateMessageHash(userMessage, messageId);
        printMessages();
        sentMessage(); 
        }
        
        JOptionPane.showMessageDialog(null, numMessages + " have been sent");
        }
    
              
    
}
}
