package Server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class LoggingCalculatorServer {

    public static void main(String[] args) throws Exception {
        List<String> logs = new ArrayList<>();
        ServerSocket server = new ServerSocket(9876);
        while (true) {
            Socket client = server.accept();

            RequestHandler rh = new RequestHandler(client,logs);
            rh.start();
        }

    }
}
