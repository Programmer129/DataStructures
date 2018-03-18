package strings.multithreading;

import strings.substring_search.RabinKarp;

public class SingleThreadSingleAlgorithm {

    private String text;
    private String pattern;

    public SingleThreadSingleAlgorithm(final String text, final String pattern){

        this.text = text;
        this.pattern = pattern;

        try {
            runAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void runAll() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            long startTime = System.currentTimeMillis();

            RabinKarp.containPattern(this.text, this.pattern);

            long endTime = System.currentTimeMillis();

            System.out.println(Thread.currentThread().getName() + " takes " + (double) (endTime - startTime) / 1000.0);

        }, "thread 1");


        Thread t2 = new Thread(() -> {
            long startTime = System.currentTimeMillis();

            RabinKarp.containPattern(this.text, this.pattern);

            long endTime = System.currentTimeMillis();

            System.out.println(Thread.currentThread().getName() + " takes " + (double) (endTime - startTime) / 1000.0);

        }, "thread 2");

        Thread t3 = new Thread(() -> {
            long startTime = System.currentTimeMillis();

            RabinKarp.containPattern(this.text, this.pattern);

            long endTime = System.currentTimeMillis();

            System.out.println(Thread.currentThread().getName() + " takes " + (double) (endTime - startTime) / 1000.0);

        }, "thread 3");


        t1.start();

        t1.join();

        t2.start();
        t3.start();
    }

}
