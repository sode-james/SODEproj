/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package loginsystem;
import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
       
        // Maximum number of users that can be registered
        try (Scanner sc = new Scanner(System.in)) {
            // Maximum number of users that can be registered
            final int MAX_USERS = 10;
            String[][] users = new String[MAX_USERS][2]; // [][0] = username, [][1] = password
            int userCount = 0;
            
            boolean running = true;
            
            while (running) {
                System.out.println("==== LOGIN SYSTEM ====");
                System.out.println("[1] Login");
                System.out.println("[2] Register");
                System.out.println("[3] Exit");
                System.out.print("Choose an option: ");
                String choice = sc.nextLine();
                
                switch (choice) {
                    case "1" -> {
                        // LOGIN
                        System.out.print("Enter username: ");
                        String loginUser = sc.nextLine();
                        System.out.print("Enter password: ");
                        String loginPass = sc.nextLine();
                        
                        boolean found = false;
                        for (int i = 0; i < userCount; i++) {
                            if (users[i][0].equals(loginUser) && users[i][1].equals(loginPass)) {
                                System.out.println("Hello, " + loginUser + "!");
                                found = true;
                                break;
                            }
                        }
                        
                        if (!found) {
                            System.out.println("Invalid username or password!");
                        }
                        System.out.println();
                    }
                    
                    case "2" -> {
                        // REGISTER
                        System.out.print("Enter new username: ");
                        String newUser = sc.nextLine();
                        
                        // Check if username already exists
                        boolean exists = false;
                        for (int i = 0; i < userCount; i++) {
                            if (users[i][0].equals(newUser)) {
                                exists = true;
                                break;
                            }
                        }
                        
                        if (exists) {
                            System.out.println("Username already exists!");
                        } else {
                            System.out.print("Enter password: ");
                            String newPass = sc.nextLine();
                            System.out.print("Confirm password: ");
                            String confirmPass = sc.nextLine();
                            
                            if (!newPass.equals(confirmPass)) {
                                System.out.println("Passwords do not match!");
                            } else {
                                users[userCount][0] = newUser;
                                users[userCount][1] = newPass;
                                userCount++;
                                System.out.println("Registration successful!");
                            }
                        }
                        System.out.println();
                    }

                    case "3" -> {
                        // EXIT
                        System.out.println("Goodbye!");
                        running = false;
                    }
                    
                    default -> System.out.println("Invalid option! Please try again.\n");
                }
            }
        }
    }
}