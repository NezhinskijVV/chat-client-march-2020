import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private final static String IP = "localhost";
    private final static int PORT = 8080;

    @SneakyThrows
    public void start() {
        Socket socket = new Socket(IP, PORT);

        if (socket.isConnected()) {
            MessageReceiver messageConsoleReceiver = new MessageReceiver(System.in);
            MessageSender messageSender = new MessageSender(socket.getOutputStream());

            new Thread(new SocketRunnable(socket)).start();

            String messageFromConsole;
            while ((messageFromConsole = messageConsoleReceiver.readMessage()) != null) {
               messageSender.sendMessage(messageFromConsole);
            }
        }

    }
}
