import lombok.SneakyThrows;

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

            registration(messageConsoleReceiver, messageSender);

            new Thread(new SocketRunnable(socket)).start();

            String messageFromConsole;
            while ((messageFromConsole = messageConsoleReceiver.readMessage()) != null) {
                messageSender.sendMessage(messageFromConsole);
            }
        }
    }

    public void registration(MessageReceiver messageReceiver, MessageSender messageSender) {
        System.out.println("----------------------------------");
        System.out.println("Добро пожаловать в наш Чат!");
        System.out.println("----------------------------------");

        System.out.println("Введите имя");
        String name = messageReceiver.readMessage();
        System.out.println("Введите пароль");
        String password = messageReceiver.readMessage();

        messageSender.sendMessage("Registration " + name + " " + password);
    }
}
