package ru.netology.clientserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        System.out.println("Server started!");
        final int PORT = 9090;

        while (true) {
            try (ServerSocket serverSocket = new ServerSocket(PORT);
                 Socket clientSocket = serverSocket.accept();
                 PrintWriter sockOut = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader bufRead = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                System.out.println("New connection accepted");

                final String name = bufRead.readLine();
                sockOut.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
