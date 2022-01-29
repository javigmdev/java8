package com.java.lambdas;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Lambda_007_Callable {

    public static void main(String[] args) throws Exception {
        log("Starting...");

        /*
         *  Callable Java < 8
         */
        Callable<Integer> callablePreJava8 = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                log("INSIDE CALLABLE");
                return 69 * 127;
            }
        };

        /*
         * Callable Java 8
         */
        Callable<Integer> callableJava8 = () -> 69 * 127;

        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<Integer> future = service.submit(callablePreJava8);
       // Future<Integer> future = service.submit(callableJava8);

        log("UNLOCKED INSTRUCTIONS");
        log("UNLOCKED INSTRUCTIONS");
        /*
         * With a delay of 100ms it can be seen that the execution is multi-threaded and concurrent.
         */
        Thread.sleep(100);
        log("UNLOCKED INSTRUCTIONS");
        log("UNLOCKED INSTRUCTIONS");
        log("UNLOCKED INSTRUCTIONS");

        Integer result = future.get();

        log("RESULT:" + result);
    }

    private static void log(Object o) {
        System.out.println(Thread.currentThread().getName() + " " + o);
    }
}
