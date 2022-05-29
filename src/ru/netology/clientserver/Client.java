package ru.netology.clientserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        final String HOST = "localhost";
        final int PORT = 9090;

        try (Socket clientSocket = new Socket(HOST, PORT);
             PrintWriter sockOut = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader bufRead = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            sockOut.println("User");

            String resp = bufRead.readLine();
            System.out.println(resp);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
