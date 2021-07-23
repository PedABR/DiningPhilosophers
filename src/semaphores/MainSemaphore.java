package semaphores;

import java.util.concurrent.Semaphore;

public class MainSemaphore {

    public static void main(String[] args) {

        final int num = 5;

        final int thinkingTime0 = 100;
        final int thinkingTime1 = 150;
        final int thinkingTime2 = 200;
        final int thinkingTime3 = 80;
        final int thinkingTime4 = 300;

        final int eatingTime0 = 120;
        final int eatingTime1 = 100;
        final int eatingTime2 = 200;
        final int eatingTime3 = 400;
        final int eatingTime4 = 150;

        Semaphore[] semaphores = new Semaphore[num];
        for (int i = 0; i < num; i++) {
            semaphores[i] = new Semaphore(1);
        }

        new Philosopher(thinkingTime0, eatingTime0, semaphores, num);
        new Philosopher(thinkingTime1, eatingTime1, semaphores, num);
        new Philosopher(thinkingTime2, eatingTime2, semaphores, num);
        new Philosopher(thinkingTime3, eatingTime3, semaphores, num);
        new Philosopher(thinkingTime4, eatingTime4, semaphores, num);
    }
}
