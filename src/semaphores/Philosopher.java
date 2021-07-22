package semaphores;

import java.util.concurrent.Semaphore;

public class Philosopher implements Runnable {

    private int thinkingTime;
    private int eatingTime;
    private Semaphore[] sem;
    private int num;
    private static int id = 0;
    private int i;

    Philosopher(int thinkingTime, int eatingTime, Semaphore[] sem, int num) {
        this.num = num;
        this.thinkingTime = thinkingTime;
        this.eatingTime = eatingTime;
        this.sem = sem;
        this.i = id++;
        new Thread((Runnable) this, "Philosopher " + i).start();
    }

    @Override
    public void run() {
        while (true) {
            think();
            takeForks();
            eat();
            returnForks();
        }
    }

    private void think() {
        try {
            Thread.sleep(thinkingTime);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void eat() {
        try {
            Thread.sleep(eatingTime);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void takeForks() {
        try {
            sem[i].acquire();
            System.out.println("Philosopher " + i + " took the left fork");
            sem[(i + 1) % num].acquire();
            System.out.println("Philosopher " + i + " took the right fork");
        }
        catch (InterruptedException e) {
            System.out.println("Philosopher " + i + " waiting to eat");
        }
    }

    private void returnForks() {
        sem[i].release();
        sem[(i + 1) % num].release();
        System.out.println("Philosopher " + i + " returned forks");
    }
}
