package ThreadHW;

import java.util.Arrays;
import java.util.concurrent.Semaphore;

public class OptionalShipsTask {
    public static void main(String[] args) {

        Semaphore[] semaphores = new Semaphore[Docks.docks.length];
        for (int i = 0; i < Docks.docks.length; i++) {
            semaphores[i] = new Semaphore(1);
        }

        for (int i = 0; i < 10; i++) {
            new Thread(new Ship(semaphores)).start();
        }
    }

    static class Ship implements Runnable{

        private Semaphore[] semaphores;

        public Ship(Semaphore[] semaphores) {
            this.semaphores = semaphores;
        }

        @Override
        public void run() {
            while (true) {
                for (int i = 0; i < Docks.docks.length; i++) {
                    try {
                        semaphores[i].acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Корабль " + Thread.currentThread().getName() + " занял док " + i);
                    Docks.docks[i]++;
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    semaphores[i].release();
                    System.out.println(semaphores[i]);

                    System.out.println("Корабль " + Thread.currentThread().getName() + " освободил док " + i);
                    System.out.println(Arrays.toString(Docks.docks));
                }
            }
        }
    }
}

class Docks{

   static int[] docks = new int[]{0,0,0,0};
// можно просто сделать synchronize на Docks
    // либо создать семафор для дока на 4
}

//TODO почитать про Atomic классы
