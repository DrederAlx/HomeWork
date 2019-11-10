package EmployeeMessageTask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


enum MessagePriority {
    LOW, MEDIUM, HIGH, URGENT;

    public static EmployeeMessageTask.MessagePriority getPriority(int ord){
        for (EmployeeMessageTask.MessagePriority mp: values()){
            if (ord == mp.ordinal()) {
                return mp;
            }
        }
        throw new AssertionError("Wrong ordinal: " + ord);
    }
}


public class Message {
    private int code;
    private EmployeeMessageTask.MessagePriority priority;

    public Message(int code, EmployeeMessageTask.MessagePriority priority) {
        this.code = code;
        this.priority = priority;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public EmployeeMessageTask.MessagePriority getPriority() {
        return priority;
    }

    public void setPriority(EmployeeMessageTask.MessagePriority priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeMessageTask.Message message = (EmployeeMessageTask.Message) o;

        if (code != message.code) return false;
        return priority == message.priority;
    }

    @Override
    public int hashCode() {
        int result = code;
        result = 31 * result + (priority != null ? priority.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Message{" +
                "code=" + code +
                ", priority=" + priority +
                '}';
    }

    public static void main(String[] args) {
        List<EmployeeMessageTask.Message> messages = EmployeeMessageTask.MessageGenerator.generate(34);
        System.out.println(messages);
    }
}

class MessageGenerator {
    public static List<EmployeeMessageTask.Message> generate(int num){
        if (num <= 0) {
            return Collections.emptyList();
        }

        Random random = new Random();
        List<EmployeeMessageTask.Message> messages = new ArrayList<>(num);

//        values() - вернет массив констант
        int typesCount = EmployeeMessageTask.MessagePriority.values().length;

        for (int i = 0; i < num; i++){
            messages.add(new EmployeeMessageTask.Message(random.nextInt(10), EmployeeMessageTask.MessagePriority.getPriority(random.nextInt(typesCount))));
        }

        return messages;
    }
}