package HW12.FizzBuzz;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class ProcessThread extends Thread  {
    private int number;
    private AtomicBoolean procesed = new AtomicBoolean(true);
    private NumberProcessor processor;

    public ProcessThread(NumberProcessor processor){
        this.processor = processor;
    }

    public void process(int number){
        this.number = number;
        procesed.set(false);
    }
    public boolean isProcessed(){
        return procesed.get();
    }
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
           if (procesed.get()){
               continue;
           }
           processor.process(number);
           procesed.set(true);
        }
    }
}