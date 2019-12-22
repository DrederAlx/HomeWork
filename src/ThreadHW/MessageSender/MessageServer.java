package ThreadHW.MessageSender;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class MessageServer {
    private int port;
    private Set<Connection> connections = Collections.synchronizedSet(new HashSet<>());
    private LinkedBlockingDeque<Message> messages = new LinkedBlockingDeque<>();

    public MessageServer(int port){
        this.port = port;
    }

    public void start() throws IOException {
        new Thread(new Writer()).start();
        try (ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Server started...");
            //noinspection InfiniteLoopStatement
            while (true){
                Socket socket = serverSocket.accept();
                Connection connection = new Connection(socket);
                connections.add(connection);
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
                    connections.remove(connection);
                    Thread.currentThread().interrupt();
                }
                try {
                    Message message = connection.readMessage();
                    message.setId(connection.hashCode());
                    messages.put(message);
                } catch (IOException | ClassNotFoundException | InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Клиент " + connection.getSocket().getInetAddress() + " отключился");
                    connections.remove(connection);
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
                    for (Connection connection : connections){
                        if (connection.hashCode() != message.getId() && !connection.getSocket().isClosed()) {
                            try {
                                connection.sendMessage(message);
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