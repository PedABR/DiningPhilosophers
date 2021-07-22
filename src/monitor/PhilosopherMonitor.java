package monitor;

public class PhilosopherMonitor implements Runnable {

    private int thinkingTime;
    private int eatingTime;
    private static int id = 0;
    private final Object rightFork;
    private final Object leftFork;
    private int i;

    public PhilosopherMonitor(int thinkingTime, int eatingTime, Object[] forks) {
        this.thinkingTime = thinkingTime;
        this.eatingTime = eatingTime;
        this.i = id++;
        this.leftFork = forks[i];
        this.rightFork = forks[(i + 1) % 5];
        new Thread((Runnable) this, "Philosopher" + i).start();
    }

    @Override
    public void run() {
        while (true) {
            think();
            synchronized (leftFork) {
                System.out.println("Philosopher " + i + " took the left fork");
                synchronized (rightFork) {
                    System.out.println("Philosopher " + i + " took the right fork");
                    eat();
                    System.out.println("Philosopher " + i + " returned the forks");
                }
            }
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

    public int getI() {
        return i;
    }
}
