import java.io.*;
import java.net.*;
import java.util.Random;

public class Server {
    public static void main(String[] args) {
        Random random = new Random();
        int port = 4000;

        System.out.println("Server listening on port: " + port);

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    System.out.println("CONNECTION OPEN");

                    String clientMessage = in.readLine();
                    System.out.println("Received from client: " + clientMessage);

                    if ("HELLO".equals(clientMessage)) {
                        out.println("HI, HOW ARE YOU");
                        System.out.println("Sent to client: HI, HOW ARE YOU");
                    }

                    System.out.println("CONNECTION CLOSED");
                } catch (IOException e) {
                    System.out.println("Exception caught when trying to listen on port " + port + " or listening for a connection");
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Could not listen on port " + port);
            System.out.println(e.getMessage());
        }
    }
}
