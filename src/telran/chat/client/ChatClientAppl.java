package telran.chat.client;

import telran.chat.client.task.MessageReceiver;
import telran.chat.client.task.MessageSender;

import java.io.IOException;
import java.net.Socket;

public class ChatClientAppl {
    public static void main(String[] args) {
        String serverHost = args[0];
        int serverPort = Integer.parseInt(args[1]);
        try {
            Socket socket = new Socket(serverHost, serverPort);
            new MessageReceiver(socket);
            new Thread(new MessageSender(socket)).start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
