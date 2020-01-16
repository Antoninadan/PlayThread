package com.mainacad.service;

import com.mainacad.model.Song;
import com.mainacad.thread.Iterruptor;
import com.mainacad.thread.SongStarter;

import java.util.concurrent.TimeUnit;

public class Player {

    public static void work(Song song) {
        SongStarter songStarter = new SongStarter(song);
        Iterruptor iterruptor = new Iterruptor();

        songStarter.start();
        iterruptor.start();

        while ((songStarter.getState() != Thread.State.TERMINATED) && (iterruptor.getState() != Thread.State.TERMINATED)) {
        }

        songStarter.interrupt();
        iterruptor.interrupt();

        System.out.println("Call main menu");
    }
}
