package com.releaseteam.channel;

import io.socket.client.IO;
import io.socket.client.Socket;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;

public class Channel {


    public Socket channel(boolean reconnect, int reconnectionAttempts, String userName, String UUID, String releaseAuthKey) {
        AtomicReference<Socket> socket = new AtomicReference<Socket>(null);
        CompletableFuture.supplyAsync(() -> {

            URI channel = URI.create("https://chat.releaseteam.de");
            IO.Options options = IO.Options.builder()
                    .setReconnection(reconnect)
                    .setSecure(true)
                    .setReconnectionAttempts(reconnectionAttempts)
                    .setExtraHeaders(Map.of("name", List.of(userName), "uuid", List.of(UUID), "releaseauth", List.of(releaseAuthKey))).build();

            socket.set(IO.socket(channel, options));
            socket.get().connect();

            return null;
        });
        return socket.get();
    }

    public Socket getChannel(Socket socket) {
        return socket;
    }

    public void closeChannel(Socket socket) {
        socket.close();
        socket.disconnect();
    }

}
