/**

    Aryan Ranjane 
    Kunal Kamble

    Topic:- develop a program to send username and password through client and server and server will send message to client that the client is authenticated or not

**/ 

import java.io.*;
import java.net.*;

public class server {
    private static final String VALID_USERNAME = "ram";
    private static final String VALID_PASSWORD = "password123";

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server is listening on port 12345...");
            
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Connection established with client: " + socket.getInetAddress());

                // Input streams to receive data from the client
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

                // Read username and password from client
                String data = input.readLine();
                String[] credentials = data.split(",");
                String username = credentials[0];
                String password = credentials[1];

                // Authenticate
                String response;
                if (VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password)) {
                    response = "Authentication successful";
                } else {
                    response = "Authentication failed";
                }

                // Send response to client
                output.println(response);

                // Close connection
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
