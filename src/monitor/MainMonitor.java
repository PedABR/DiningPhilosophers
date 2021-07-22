package monitor;

public class MainMonitor {

    public static void main(String[] args) {

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

        Object[] forks = new Object[5];

        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Object();
        }

        new PhilosopherMonitor(thinkingTime1, eatingTime1, forks);
        new PhilosopherMonitor(thinkingTime2, eatingTime2, forks);
        new PhilosopherMonitor(thinkingTime3, eatingTime3, forks);
        new PhilosopherMonitor(thinkingTime4, eatingTime4, forks);
        new PhilosopherMonitor(thinkingTime5, eatingTime5, forks);
    }
}
