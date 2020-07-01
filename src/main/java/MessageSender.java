
import java.io.OutputStream;
import java.io.PrintWriter;

public class MessageSender {
    public final PrintWriter printWriter;

    public MessageSender(OutputStream outputStream) {
        this.printWriter = new PrintWriter(outputStream);
    }

    public void sendMessage(String message) {
        printWriter.println(message);
        printWriter.flush();
    }

}