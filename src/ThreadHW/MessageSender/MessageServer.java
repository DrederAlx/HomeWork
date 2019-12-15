package ThreadHW.MessageSender;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class MessageServer {
    private int port;
    private Connection connection;
    private Map<Integer, Connection> connections = Collections.synchronizedMap(new HashMap<>());
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
                connection = new Connection(socket);
                connections.put(connection.getClientId(), connection);
                new Thread(new Reader(connection)).start();
                // printMessage(connection.readMessage());
                // connection.sendMessage(new Message("server", "сообщение получено", 123));
            }
        }
    }

    private void printMessage(Message message){
        System.out.println("получено сообщение: " + message);
    }


    class Reader implements Runnable{
        private Connection connection;
        private int connectionId;

        public Reader(Connection connection) {
            this.connection = connection;
        }

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                Message message = null;
                try {
                    message = connection.readMessage();
                    messages.put(message);
                } catch (IOException | ClassNotFoundException | InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(message);
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
                        if (!entry.getKey().equals(message.getClientId())) {
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