/**

	Aryan Ranjane 
	Kunal Kamble

	Topic:- develop a program to send username and password through client and server and server will send message to client that the client is authenticated or not

**/ 

import java.io.*;
import java.net.*;

public class client {
    
    public static void main(String[] args) {
        
        try (Socket socket = new Socket("localhost", 12345)) {

            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Input username and password
            System.out.print("Enter username: ");
            String username = consoleInput.readLine();
            System.out.print("Enter password: ");
            String password = consoleInput.readLine();

            // Send username and password to server
            output.println(username + "," + password);

            // Receive response from server
            String response = input.readLine();
            System.out.println(response);

        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
