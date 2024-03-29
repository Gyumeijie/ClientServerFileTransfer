import java.net.*;
import java.io.*;
import java.util.*;
import java.util.logging.Logger;
public class FileServer {

    private static ServerSocket serverSocket;
    private static Socket clientSocket = null;

    public static void main(String[] args) throws IOException {

        try {
            serverSocket = new ServerSocket(25444);
            System.out.println("Heyy!! Server started.");
        } catch (Exception e) {
            System.err.println("Port already in use.");
            System.exit(1);
        }
   
  
        while (true) {
            try {
                // serverSocket accept时会返回一个客户端的sockect
                clientSocket = serverSocket.accept();
                System.out.println("Accepted connection : " + clientSocket);

                Thread t = new Thread(new ServiceClient(clientSocket));

                t.start();

            } catch (Exception e) {
                System.err.println("Error in connection attempt.");
            }
        }
    }
}
