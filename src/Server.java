
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        System.out.println("SERVER SOCKET: Waiting for Connection");
        int PORT = 12345; 
                       
        try {
            ServerSocket server = new ServerSocket(PORT); // Create the server socket
            
            Socket socket = server.accept(); // Get the socket object and socket connection
            
            InputStream is = socket.getInputStream(); // Setting up the Input Stream (Standard Code)
            BufferedInputStream bis = new BufferedInputStream(is);
            DataInputStream dis = new DataInputStream(bis);

            String fromClient = dis.readUTF(); // Create a string to read and store from the input

            while (!fromClient.equalsIgnoreCase("close") && fromClient != null) { //Run this loop while input is not "close"
                
                System.out.println("Recieved message from client: " + fromClient); // Processs the message
                fromClient = dis.readUTF(); // Read the next line from the input stream
            }
            
            System.out.println("Connection Terminated");
            socket.close(); // Always close the socket after all input/output
            
            // The following method is used when you know how many times the user will send to server
            
            /*String msg = dis.readUTF();
            System.out.println("Message recieved --> " + msg);
            String msg2 = dis.readUTF();
            System.out.println("Message recieved --> " + msg2);
            socket.close();*/
            
        } catch (IOException e) {
            System.out.println("IO Error");
        }
    }
}