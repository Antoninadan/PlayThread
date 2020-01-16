package com.mainacad.thread;

import com.mainacad.model.Song;

public class SongStarter extends Thread{
    Song song;

    public SongStarter(Song song) {
        this.song = song;
    }

    @Override
    public void run() {
        ThreadStopper threadStopper = new ThreadStopper(this, song.getDurationSeconds());
        threadStopper.run();
    }
}
