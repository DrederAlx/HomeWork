package ThreadHW;

public class OptionalThreadNameTask {
    static volatile boolean orderFlag = true;

    // Два потока должны по очереди выводить свое имя в консоль

    public static void main(String[] args) {
        Thread thread1 = new Thread(new SomeThread(true));
        Thread thread2 = new Thread(new SomeThread(false));
        thread1.setName("Поток 1");
        thread2.setName("Поток 2");
        thread1.start();
        thread2.start();
    }
}

class SomeThread implements Runnable {
    boolean flag;

    public SomeThread(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        while (true) {
            if (flag == OptionalThreadNameTask.orderFlag) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
                OptionalThreadNameTask.orderFlag = !flag;
                Thread.yield();
            }
        }
    }
}
