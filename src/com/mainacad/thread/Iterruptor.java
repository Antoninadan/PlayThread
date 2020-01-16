package com.mainacad.thread;

import java.util.Scanner;

public class Iterruptor extends Thread {
    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        String stopWord = sc.nextLine();
        if (stopWord != null) {
            this.interrupt();
        }
    }
}
