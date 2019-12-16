package ThreadHW.MessageSender;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class MessageServer {
    private int port;
    private Map<Integer, Connection> connections = Collections.synchronizedMap(new HashMap<>());
    private LinkedBlockingDeque<Message> messages = new LinkedBlockingDeque<>();

    public MessageServer(int port){
        this.port = port;
    }

    public void start() throws IOException {
        new Thread(new Writer()).start();
        try (ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Server started...");
            Connection connection;
            //noinspection InfiniteLoopStatement
            while (true){
                Socket socket = serverSocket.accept();
                connection = new Connection(socket);
                connections.put(connection.getClientId(), connection);
                new Thread(new Reader(connection)).start();
            }
        }
    }

    class Reader implements Runnable{
        private Connection connection;

        public Reader(Connection connection) {
            this.connection = connection;
        }

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                if (connection.getSocket().isClosed()) {
                    connections.remove(connection.getClientId());
                    Thread.currentThread().interrupt();
                }
                try {
                    Message message = connection.readMessage();
                    message.setClientId(connection.getClientId());
                    messages.put(message);
                } catch (IOException | ClassNotFoundException | InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }
        }
    }

    class Writer implements Runnable {

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()){
                try {
                    Message message = messages.take();
                    for (Map.Entry<Integer, Connection> entry : connections.entrySet()){
                        if (entry.getKey() != message.getClientId() && !entry.getValue().getSocket().isClosed()) {
                            try {
                                entry.getValue().sendMessage(message);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        int port = 8090;
        MessageServer messageServer = new MessageServer(port);
        try {
            messageServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}