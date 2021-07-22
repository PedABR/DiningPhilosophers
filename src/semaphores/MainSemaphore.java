package semaphores;

import java.util.concurrent.Semaphore;

public class MainSemaphore {

    public static void main(String[] args) {

        final int num = 5;

        final int thinkingTime1 = 100;
        final int thinkingTime2 = 150;
        final int thinkingTime3 = 200;
        final int thinkingTime4 = 80;
        final int thinkingTime5 = 300;

        final int eatingTime1 = 120;
        final int eatingTime2 = 100;
        final int eatingTime3 = 200;
        final int eatingTime4 = 400;
        final int eatingTime5 = 150;

        Semaphore[] semaphores = new Semaphore[num];
        for (int i = 0; i < num; i++) {
            semaphores[i] = new Semaphore(1);
        }

        new Philosopher(thinkingTime1, eatingTime1, semaphores, num);
        new Philosopher(thinkingTime2, eatingTime2, semaphores, num);
        new Philosopher(thinkingTime3, eatingTime3, semaphores, num);
        new Philosopher(thinkingTime4, eatingTime4, semaphores, num);
        new Philosopher(thinkingTime5, eatingTime5, semaphores, num);
    }
}
