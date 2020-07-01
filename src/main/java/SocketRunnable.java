import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.net.Socket;

@AllArgsConstructor
public class SocketRunnable implements Runnable {
    private final Socket socket;

    @SneakyThrows
    @Override
    public void run() {
        MessageReceiver receiverFromServer = new MessageReceiver(socket.getInputStream());

        String messageFromServer;
        while ((messageFromServer = receiverFromServer.readMessage()) != null){
            System.out.println(messageFromServer);
        }
    }
}
