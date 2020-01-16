package com.mainacad.thread;

public class ThreadStopper extends Thread{
    Thread thread;
    Integer durationSeconds;

    public ThreadStopper(Thread thread, Integer durationSeconds) {
        this.thread = thread;
        this.durationSeconds = durationSeconds;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        long now = System.currentTimeMillis();

        while ((now - start) <= durationSeconds*1000) {
            now = System.currentTimeMillis();
        }
        thread.interrupt();
    }
}
