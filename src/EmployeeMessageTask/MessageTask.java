package EmployeeMessageTask;

import java.util.*;

public class MessageTask {
    public static void countEachPriority(List<Message> messageList) {

        Map<Enum, Integer> priorityMap = new HashMap<>();

        for (Message message : messageList) {
            if (!priorityMap.containsKey(message.getPriority())) {
                priorityMap.put(message.getPriority(), 1);
            }
            else {
                priorityMap.put(message.getPriority(), priorityMap.get(message.getPriority()) + 1);
            }
        }
        for (Map.Entry<Enum, Integer> entry : priorityMap.entrySet()) {
            System.out.println("Количество сообщений с приоритетом " + entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void countEachCode(List<Message> messageList) {

        Map<Integer, Integer> codesMap = new HashMap<>();
        for (Message message : messageList) {
            if (!codesMap.containsKey(message.getCode())) {
                codesMap.put(message.getCode(), 1);
            }
            else {
                codesMap.put(message.getCode(), codesMap.get(message.getCode()) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : codesMap.entrySet()) {
            System.out.println("Количество сообщений с кодом " + entry.getKey() + ": " + entry.getValue());
        }
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