package HW12.Timer;

public class FiveSecondTimer extends Thread{
    @Override
    public void run() {
        while (true)
        {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("five second have past ");
        }
    }
}
