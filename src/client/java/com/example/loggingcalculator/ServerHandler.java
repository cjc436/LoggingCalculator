package com.example.loggingcalculator;

import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class ServerHandler {
    public static void sendMessage(String msg) {
        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), 9876);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(msg);
            oos.close();

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void sendClose() {
        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), 9876);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeBoolean(false);
            oos.close();

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
