package sendfile;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
    public static void main(String[] args) {

        int PORT = 12000;

        try { 
            ServerSocket server = new ServerSocket(PORT); // Setup the Server
            Socket sc = server.accept();
            System.out.println("Awaiting Connection...");
            

            DataInputStream dis = new DataInputStream(new BufferedInputStream(sc.getInputStream())); // Setup the IO Streams

            System.out.println("Recieving Information...");
            
            String line = dis.readUTF(); 
            while (!line.equalsIgnoreCase("EOF") && line != null) {

                System.out.println("Got: --> " + line);
                line = dis.readUTF();
            }

            sc.close();
            System.out.println("Connection Terminated...");
    
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }
}
