/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.chatapp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Nikhil
 */
public class ChatAppUserTest {
    
    public ChatAppUserTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of checkUserName method, of class ChatAppUser.
     */
    
    //Classwork [Accessed 19 April 2025]
    
    /** Coding with John., 18 Jan 2022. Java Unit Testing with Junit - Tutorial - How to create and use unit Tests
        Available at:
        <https://www.youtube.com/watch?v=vZm0lHciFsQ&t=355s> 
        [Accessed 19 April 2025]. 
        */
    @Test
    public void testCheckUserName_Valid() {
         ChatAppUser User = new ChatAppUser("kyl_1", "", "");
         assertTrue(User.checkUserName());
        
       
    }
    
    @Test
    public void testCheckUserName_Invalid() {
        ChatAppUser User = new ChatAppUser("kyle!!!!!!!", "", "");
        assertFalse(User.checkUserName());
       
    }

    /**
     * Test of checkPasswordComplexity method, of class ChatAppUser.
     */
    @Test
    public void testCheckPasswordComplexityValid() {
        ChatAppUser User = new ChatAppUser("", "Ch&&sec@ke99!", "");
        assertTrue(User.checkPasswordComplexity());
         
        
    }
    
    @Test
    public void testCheckPasswordComplexityInvalid() {
        ChatAppUser User = new ChatAppUser("", "password", "");
        assertFalse(User.checkPasswordComplexity());
        
    }

    /**
     * Test of checkCellPhonenumber method, of class ChatAppUser.
     */
    @Test
    public void testCheckCellPhonenumberValid() {
       ChatAppUser User = new ChatAppUser("", "", "+27726496449");
       assertTrue(User.checkCellPhonenumber());
    }
    
    
     @Test
    public void testCheckCellPhonenumberInvalid() {
        
        ChatAppUser User = new ChatAppUser("", "", "08966553");
        assertFalse(User.checkCellPhonenumber());
    }

    /**
     * Test of registerUser method, of class ChatAppUser.
     */
    @Test
    public void testRegisterUser_Valid() {
        
        ChatAppUser User = new ChatAppUser("kyl_1", "Ch&&sec@ke99!","+27838968976");
        String expected = "Username and Password have been registered successfully.";
        assertEquals(expected, User.registerUser());
    }
    
    public void testRegisterUser_Invalid() {
        
        ChatAppUser User = new ChatAppUser("kyle!!!!!!", "password","08966553");
        String expected =   "Username is not\n" +
                            "correctly formatted,\n" +
                            "please ensure that\n" +
                            "your username\n" +
                            "contains an\n" +
                            "underscore and is no\n" +
                            "more than five\n" +
                            "characters in length.\" ";
        assertEquals(expected, User.registerUser());
    }

    /**
     * Test of LoginUser method, of class ChatAppUser.
     */
    @Test
    public void testLoginUser_True() {
     ChatAppUser User = new ChatAppUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
     assertTrue(User.LoginUser("kyl_1","Ch&&sec@ke99!"));
        
    }
    
    @Test
    public void testLoginUser_False() {
     ChatAppUser User = new ChatAppUser("kyl_1", "WrongPassword", "08966553");
     assertFalse(User.LoginUser("kyl1","WrongPassword"));
        
    }

    /**
     * Test of returnLoginStatus method, of class ChatAppUser.
     */
    @Test
    public void testReturnLoginStatus_True() {
        ChatAppUser User = new ChatAppUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        String expected = "Welcome kyl_1 It is great to see you again.";
        assertEquals(expected, User.returnLoginStatus(true));
        
    }
    
    public void testReturnLoginStatus_False() {
        ChatAppUser User = new ChatAppUser("kyle!!!!!!!", "password", "08966553");
        String expected = "Username or password is incorrect, please try again";
        assertEquals(expected, User.returnLoginStatus(false));
        
        
    }
    
}
