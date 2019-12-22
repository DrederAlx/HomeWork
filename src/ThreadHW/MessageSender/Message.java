package ThreadHW.MessageSender;

import java.io.Serializable;

public class Message implements Serializable {
    private String sender;
    private String text;
    private int id;

    public Message(String sender, String messageText) {
        setSender(sender);
        setText(messageText);
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
