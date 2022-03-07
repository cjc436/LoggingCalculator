package Server;

import java.io.*;
import java.net.Socket;
import java.util.List;

public class RequestHandler extends Thread {
    private Socket clientSocket;
    private List<String> localLogs;

    public RequestHandler(Socket client, List<String> logs) {
        clientSocket = client;
        localLogs = logs;
    }

    public void run() {
        try {
            ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
            try {
                if (!ois.readBoolean()); {
                    System.out.println("\nClient Closed:\nThere were " + localLogs.size() + " successful log(s). Here are the logs:");
                    for (String log : localLogs) {
                        System.out.println(log);
                    }
                    localLogs.clear();
                }
            } catch(Exception e) {
                String log = (String) ois.readObject();
                System.out.println(log);
                localLogs.add(log);

                clientSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
