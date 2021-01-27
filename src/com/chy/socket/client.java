package com.chy.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class client {
    public static void main(String[] args) {
        String s = null;
        Socket clientSocket;
        DataInputStream inputStream = null;
        DataOutputStream outputStream = null;
        try {
            clientSocket = new Socket("127.0.0.1", 4311);
            inputStream = new DataInputStream(clientSocket.getInputStream());
            outputStream = new DataOutputStream(clientSocket.getOutputStream());
            outputStream.writeUTF("hello client");
            while (true) {
                s = inputStream.readUTF();
                outputStream.writeUTF((int)(Math.random() * 10 + 1) + "");
                System.out.println("client receive");
                Thread.sleep(1000);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
