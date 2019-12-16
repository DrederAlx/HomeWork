package ThreadHW.MessageSender;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Message implements Serializable {
    private String sender;
    private String text;
    private int clientId;
    private LocalDateTime dateTime;

    public Message(String sender, String messageText) {
        setSender(sender);
        setText(messageText);
        dateTime = LocalDateTime.now();
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        if (sender != null && !"".equals(sender)) {
            this.sender = sender;
        }
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        if (text != null && !"".equals(text)) {
            this.text = text;
        }
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "Message{" +
                "sender='" + sender + '\'' +
                ", text='" + text + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}
