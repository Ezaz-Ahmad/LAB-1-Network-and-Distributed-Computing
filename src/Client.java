import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 4000;

        System.out.println("Attempting to connect to server at " + host + " on port " + port);

        try (Socket socket = new Socket(host, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            System.out.println("Connection Established Successfully");

            out.println("HELLO");
            System.out.println("Sent to server: HELLO");

            String serverResponse = in.readLine();
            System.out.println("Received from server: " + serverResponse);

        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + host);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + host);
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
}
