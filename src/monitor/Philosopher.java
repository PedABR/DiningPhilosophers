package monitor;

import java.util.concurrent.Semaphore;

public class Philosopher implements Runnable {

    private int thinkingTime;
    private int eatingTime;
    private Semaphore[] sem;
    private static int id = 0;

    Philosopher(int thinkingTime, int eatingTime, Semaphore[] sem) {
        this.thinkingTime = thinkingTime;
        this.eatingTime = eatingTime;
        this.sem = sem;
        id++;
        new Thread((Runnable) this, "Philosopher" + id).start();
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

    synchronized private void takeForks() {

    }

    synchronized private void returnForks() {

    }
}
