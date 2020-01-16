package com.mainacad.thread;

import com.mainacad.model.Song;

public class SongStarter extends Thread{
    Song song;

    public SongStarter(Song song) {
        this.song = song;
    }

    @Override
    public void run() {
        System.out.println(song.getName() + "  " + song.getAuthor());

        ThreadStopper threadStopper = new ThreadStopper(this, song.getDurationSeconds());
        threadStopper.run();
    }
}
