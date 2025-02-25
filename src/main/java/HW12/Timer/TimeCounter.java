package HW12.Timer;

public class TimeCounter extends Thread{
    private long startTime;

    @Override
    public void run() {
        startTime = System.currentTimeMillis();
        while (true)
        {
            long runningTime = (System.currentTimeMillis() - startTime)/ 1000;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("running time is: " + runningTime + " seconds");
        }
    }
}
