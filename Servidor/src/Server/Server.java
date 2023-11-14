package Server;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    public final static int DEFAULT_PORT = 4001;
    private ServerSocket serverSocket;

    public void run() throws IOException {
        System.out.println("Server running on port: " + DEFAULT_PORT);
        serverSocket = new ServerSocket(DEFAULT_PORT);
        clientConnection();
    }

    private void clientConnection() throws IOException {
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client: " + clientSocket.getRemoteSocketAddress() + "connected.");
        }
    }

    public static void main (String[] args) {
        try {
            Server server = new Server();
            server.run();
        } catch (IOException e) {
//            throw new RuntimeException(e);
            System.out.println("Error starting server: " + e.getMessage());
        }
//        if (args.length > 1) {
//            System.err.println("Uso esperado: java Server [DEFAULT_PORT]\n");
//            return;
//        }
//
//        Int port = DEFAULT_PORT;
//
//        if (args.length == 1) port = args[0];
//
//        // ArrayList<>
        System.out.println("Server closed.");
    }
}
