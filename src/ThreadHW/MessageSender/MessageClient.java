package ThreadHW.MessageSender;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;

public class MessageClient {
    private Scanner scanner;
    private Connection connection;

    public MessageClient(Connection connection) {
        this.connection = connection;
        this.scanner = new Scanner(System.in);
    }

    public void start(){
        Thread readThread = new Thread(new Reader(connection));
        readThread.setDaemon(true);
        readThread.start();
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        String messageText;
        while (true){
            System.out.println("Введите сообщение или exit для выхода");
            messageText = scanner.nextLine();
            if ("exit".equals(messageText)) break;
            if (messageText != null && !messageText.isEmpty()) {
                Message message = new Message(name, messageText, connection.getClientId());
                try {
                    connection.sendMessage(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Reader implements Runnable {
        private Connection connection;

        public Reader(Connection connection) {
            this.connection = connection;
        }

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                Message message = null;
                try {
                    message = connection.readMessage();
                    } catch (IOException | ClassNotFoundException e) {
                        Thread.currentThread().interrupt();
                        e.printStackTrace();
                    }
                    System.out.println(message);
                }
            }
        }


    public static void main(String[] args) {
        try (InputStream inputStream = MessageClient.class.getClassLoader().getResourceAsStream("config.properties")){

            Properties properties = new Properties();
            if (inputStream != null) {
                properties.load(inputStream);
            }

            String server = properties.getProperty("server");//"127.0.0.1";
            int port = Integer.parseInt(properties.getProperty("port")); //8090;
            System.out.println(server);
            Connection connection = new Connection(new Socket(server, port));
            MessageClient messageClient = new MessageClient(connection);
            messageClient.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


