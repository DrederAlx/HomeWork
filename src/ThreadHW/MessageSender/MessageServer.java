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

                for (int i = -1; i < connections.size(); i++) {
                    if (!connections.containsKey(i+1)) {
                        connections.put(i+1, connection);
                        new Thread(new Reader(i+1)).start();
                        break;
                    }
                }
                System.out.println(connections.entrySet());
            }
        }
    }

    class Reader implements Runnable{
        private int key;

        public Reader(int key) {
            this.key = key;
        }

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                if (connections.get(key).getSocket().isClosed()) {
                    connections.remove(key);
                    Thread.currentThread().interrupt();
                }
                try {
                    Message message = connections.get(key).readMessage();
                    message.setId(key);
                    messages.put(message);
                } catch (IOException | ClassNotFoundException | InterruptedException e) {
                    System.out.println("Клиент " + key + " отключился");
                    connections.remove(key);
                    Thread.currentThread().interrupt();
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
                        if (entry.getKey() != message.getId() && !entry.getValue().getSocket().isClosed()) {
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