package ThreadHW;

import java.util.concurrent.LinkedBlockingDeque;

public class OptionalRestaurantTask {
    public static void main(String[] args) {

        LinkedBlockingDeque<Order> clientOrders = new LinkedBlockingDeque<>(2);
        LinkedBlockingDeque<Order> waiterOrders = new LinkedBlockingDeque<>(5);
        LinkedBlockingDeque<Order> cookOrders = new LinkedBlockingDeque<>(10);

        for (int i = 0; i < 10; i++) {
            new Thread(new Client(clientOrders, cookOrders)).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(new Waiter(clientOrders, waiterOrders)).start();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(new Cook(waiterOrders, cookOrders)).start();
        }

    }
}

class Client implements Runnable{

    private LinkedBlockingDeque<Order> clientOrders;
    private LinkedBlockingDeque<Order> cookOrders;

    public Client(LinkedBlockingDeque<Order> clientOrders, LinkedBlockingDeque<Order> cookOrders) {
        this.clientOrders = clientOrders;
        this.cookOrders = cookOrders;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("Клиент " + (int)(Math.random()*100)+1);
        while (!Thread.currentThread().isInterrupted()) {
            Order order = createOrder();
            try {
                Thread.sleep(2000);
                System.out.println("Поток " + Thread.currentThread().getName() + " создал заказ номер " + order.getOrderNumber());
                clientOrders.put(order);
                cookOrders.take();
                System.out.println("Заказов в очереди клиента " + (clientOrders.size()));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }

    public Order createOrder (){
       Order order = new Order((int)(Math.random()*500)+1);
        return order;
    }
}

class Waiter implements Runnable {

    private LinkedBlockingDeque<Order> clientOrders;
    private LinkedBlockingDeque<Order> waiterOrders;
    private Order order;

    public Waiter(LinkedBlockingDeque<Order> clientOrders, LinkedBlockingDeque<Order> waiterOrders) {
        this.clientOrders = clientOrders;
        this.waiterOrders = waiterOrders;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("Официант " + (int)(Math.random()*100)+1);
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(4000);
                order = clientOrders.take();
                System.out.println("Поток " + Thread.currentThread().getName() + " взял заказ номер " + order.getOrderNumber());
                waiterOrders.put(order);
                System.out.println("Заказов в очереди официанта " + (waiterOrders.size()));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}

class Cook implements Runnable {

    private LinkedBlockingDeque<Order> waiterOrders;
    private LinkedBlockingDeque<Order> cookOrders;
    private Order order;

    public Cook(LinkedBlockingDeque<Order> waiterOrders, LinkedBlockingDeque<Order> cookOrders) {
        this.waiterOrders = waiterOrders;
        this.cookOrders = cookOrders;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("Повар " + (int)(Math.random()*100)+1);
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(6000);
                order = waiterOrders.take();
                System.out.println("Поток " + Thread.currentThread().getName() + " взял заказ номер " + order.getOrderNumber());
                cookOrders.put(order);
                System.out.println("Заказов в очереди повара " + (cookOrders.size()));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}

class Order {

    int orderNumber;

    public Order(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

}



