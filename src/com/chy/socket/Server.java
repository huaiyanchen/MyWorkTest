package com.chy.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args){
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        String s = null;
        DataOutputStream dataOutputStream = null;
        DataInputStream dataInputStream = null;
        try {
            serverSocket = new ServerSocket(4311);
            clientSocket = serverSocket.accept();
            dataInputStream = new DataInputStream(clientSocket.getInputStream());
            dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
            while (true) {
                s = dataInputStream.readUTF();
                dataOutputStream.writeUTF("This is service");
                dataOutputStream.writeUTF(s);
                System.out.println("service receive" + s);
                Thread.sleep (1000);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }


    }
}