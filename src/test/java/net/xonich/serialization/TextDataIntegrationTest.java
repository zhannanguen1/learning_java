package net.xonich.serialization;

import net.xonich.serialization.data.TextData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextDataIntegrationTest {

    @Test
    public void testTextDataTransfer() throws Exception {
        CompletableFuture<Void> serverDone = new CompletableFuture<>();
        String firstName = "Alice";
        String lastName = "Wonderland";
        int port = 60001;

        Thread serverThread = new Thread(() -> {
            try {
                AliceText.sendTextData(port, firstName, lastName);
                serverDone.complete(null);
            } catch (IOException e) {
                serverDone.completeExceptionally(e);
            }
        });
        serverThread.start();

        Thread.sleep(200);

        TextData received = BobText.receiveTextData("127.0.0.1", port);

        serverDone.get(5, TimeUnit.SECONDS);
        serverThread.join();

        assertEquals(firstName, received.getFirstName());
        assertEquals(lastName, received.getLastName());
    }
}
