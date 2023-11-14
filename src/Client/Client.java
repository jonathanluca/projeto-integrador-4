package Client;

import Server.Server;
import java.io.IOException;
import java.net.Socket;

public class Client {
    private final String DEFAULT_HOST = "localhost";
    private Socket clientSocket;

    public void run() throws IOException {
        clientSocket = new Socket(DEFAULT_HOST, Server.DEFAULT_PORT);
    }

    public static void main(String[] args) {
        try {
            Client client = new Client();
            client.run();
        } catch (IOException e) {
//            throw new RuntimeException(e);
            System.out.println("Error starting client : " + e.getMessage());
        }
    }
}
