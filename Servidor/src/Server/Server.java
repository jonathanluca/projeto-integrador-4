package Server;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    public final static int DEFAULT_PORT = 4001;

    public static void main(String[] args) {
        try {
            System.out.println("Server running on port: " + DEFAULT_PORT);
            ServerSocket serverSocket = new ServerSocket(DEFAULT_PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                ServerThread serverThread = new ServerThread(clientSocket);
                serverThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}