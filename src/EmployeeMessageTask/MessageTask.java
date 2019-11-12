package EmployeeMessageTask;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class MessageTask {
    public static void countEachPriority(List<Message> messageList) {

        int countLOW = 0;
        int countMED = 0;
        int countHIGH = 0;
        int countURG = 0;

        for (Message message: messageList) {
            if (message.getPriority().equals(MessagePriority.LOW)) {
                countLOW++;
            }
            else if (message.getPriority().equals(MessagePriority.MEDIUM)) {
                countMED++;
            }
            else if (message.getPriority().equals(MessagePriority.HIGH)) {
                countHIGH++;
            }
            else if (message.getPriority().equals(MessagePriority.URGENT)) {
                countURG++;
            }
        }

        System.out.println("Количество сообщений с приоритетом LOW: " + countLOW);
        System.out.println("Количество сообщений с приоритетом MEDIUM: " + countMED);
        System.out.println("Количество сообщений с приоритетом HIGH: " + countHIGH);
        System.out.println("Количество сообщений с приоритетом URGENT: " + countURG);

    }

    public static void countEachCode(List<Message> messageList) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        int count5 = 0;
        int count6 = 0;
        int count7 = 0;
        int count8 = 0;
        int count9 = 0;

        for (Message message: messageList) {
            if (message.getCode() == 0) {
                count0++;
            }
            else if (message.getCode() == 1) {
                count1++;
            }
            else if (message.getCode() == 2) {
                count2++;
            }
            else if (message.getCode() == 3) {
                count3++;
            }
            else if (message.getCode() == 4) {
                count4++;
            }
            else if (message.getCode() == 5) {
                count5++;
            }
            else if (message.getCode() == 6) {
                count6++;
            }
            else if (message.getCode() == 7) {
                count7++;
            }
            else if (message.getCode() == 8) {
                count8++;
            }
            else if (message.getCode() == 9) {
                count9++;
            }
        }

        System.out.println("Количество сообщений с кодом 0: " + count0);
        System.out.println("Количество сообщений с кодом 1: " + count1);
        System.out.println("Количество сообщений с кодом 2: " + count2);
        System.out.println("Количество сообщений с кодом 3: " + count3);
        System.out.println("Количество сообщений с кодом 4: " + count4);
        System.out.println("Количество сообщений с кодом 5: " + count5);
        System.out.println("Количество сообщений с кодом 6: " + count6);
        System.out.println("Количество сообщений с кодом 7: " + count7);
        System.out.println("Количество сообщений с кодом 8: " + count8);
        System.out.println("Количество сообщений с кодом 9: " + count9);
    }

    private static void uniqueMessageCount(List<Message> messageList) {

        HashSet<Message> uniqueMessages = new HashSet<>(messageList);
        System.out.println("Количество уникальных сообщений: " + uniqueMessages.size());

    }

    public static List<Message> uniqueMessagesInOriginalOrder(List<Message> messageList){
        HashSet<Message> uniqueMessages = new HashSet<>();

        Iterator<Message> messageIterator = messageList.listIterator();
        while (messageIterator.hasNext()) {
            Message m = messageIterator.next();
            if (!uniqueMessages.contains(m)) {
                uniqueMessages.add(m);
            } else messageIterator.remove();
        }

        return messageList;
    }

    public static void removeEach(List<Message> messageList, MessagePriority priority){
        System.out.println("Давай удалим все с приоритетом " + priority.name() + "\n" + messageList);

        Iterator<Message> messageIterator = messageList.listIterator();
        while (messageIterator.hasNext()) {
            Message m = messageIterator.next();
            if (m.getPriority().equals(priority)) {
                messageIterator.remove();
            }
        }

        System.out.println("Удалены все с приоритетом " + priority.name() + "\n" + messageList);

    }

    public static void removeOther(List<Message> messageList, MessagePriority priority){
        System.out.println("Давай удалим все, кроме тех, что с приоритетом  " + priority.name() + "\n" + messageList);

        Iterator<Message> messageIterator = messageList.listIterator();
        while (messageIterator.hasNext()) {
            Message m = messageIterator.next();
            if (!m.getPriority().equals(priority)) {
                messageIterator.remove();
            }
        }

        System.out.println("Удалены все, кроме тех, что с приоритетом " + priority.name() + "\n" + messageList);


    }

    public static void main(String[] args) {
        // вызов методов
        List<Message> messages = MessageGenerator.generate(34);
        System.out.println(messages);
        countEachPriority(messages);
        countEachCode(messages);
        uniqueMessageCount(messages);
        System.out.println(messages);
        System.out.println(uniqueMessagesInOriginalOrder(messages));
        removeEach(messages, MessagePriority.HIGH);
        removeOther(messages, MessagePriority.LOW);

    }
}