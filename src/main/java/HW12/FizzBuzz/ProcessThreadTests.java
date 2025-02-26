package HW12.FizzBuzz;

import java.util.ArrayList;
import java.util.List;

public class ProcessThreadTests {
    public static void main(String[] args) throws InterruptedException {
        ProcessThread FizzBuzz = new ProcessThread((n) -> {
            if (n % 15 == 0) {
                System.out.println("FizzBuzz");
            }
        });
        ProcessThread Buzz = new ProcessThread((n) -> {
            if (n % 3 == 0) {
                System.out.println("Fizz");
            }
        });
        ProcessThread Fizz = new ProcessThread((n) -> {
            if (n % 5 == 0) {
                System.out.println("Buzz");
            }
        });
        ProcessThread n = new ProcessThread(number -> {
            if (number % 3 != 0 && number % 5 != 0) {
                System.out.println(number);
            }
        });
        List<ProcessThread> threads = new ArrayList<>();
        threads.add(FizzBuzz);
        threads.add(Fizz);
        threads.add(Buzz);
        threads.add(n);
        for (ProcessThread thread : threads) {
            thread.start();
        }
        for (int i = 1; i <= 18; i++) {
            for (ProcessThread thread : threads) {
                thread.process(i);
            }

                while (true) {
                    int processedCount = 0;
                    for (ProcessThread thread : threads) {
                        if (thread.isProcessed()) {
                            processedCount++;
                        }
                    }
                    if (processedCount == threads.size()) {
                        break;
                    }
                }
            }
        System.exit(0);
    }
}



