import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MessageReceiver {
    private final BufferedReader reader;

    public MessageReceiver(InputStream inputStream) {
        this.reader = new BufferedReader(new InputStreamReader(inputStream));
    }

    @SneakyThrows
    public String readMessage() {
        return reader.readLine();
    }
}