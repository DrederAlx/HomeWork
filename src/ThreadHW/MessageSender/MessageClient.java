package ThreadHW.MessageSender;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;

public class MessageClient {
    private String server;
    private int port;
    private Scanner scanner;

    public MessageClient(String server, int port) {
        this.server = server;
        this.port = port;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        String messageText;
        System.out.println("Введите сообщение или exit для выхода");
        try (Connection connection = new Connection(new Socket(server, port))) {
            Thread readThread = new Thread(new Reader(connection));
            readThread.setDaemon(true);
            readThread.start();
            while (true) {
                messageText = scanner.nextLine();
                if ("exit".equals(messageText)) break;
                if (messageText != null && !messageText.isEmpty()) {
                    Message message = new Message(name, messageText);
                        connection.sendMessage(message);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            //TODO обработать здесь
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
                try {
                    Message message = connection.readMessage();
                    System.out.println("Сообщение от " + message.getSender() + ": " + message.getText());
                    } catch (IOException | ClassNotFoundException e) {
                        Thread.currentThread().interrupt();
                    System.out.println("Сервер завершил свою работу");
                    }

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
            MessageClient messageClient = new MessageClient(server, port);
            messageClient.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


