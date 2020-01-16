package com.mainacad.service;

import com.mainacad.model.Song;
import com.mainacad.thread.Iterruptor;
import com.mainacad.thread.SongStarter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
//    String nameInsertPosition;
//    int deletePosition;
    List<Song> mediaPlayer = new ArrayList<Song>() {{
        add(new Song("M. Jackson", "Billie Jean", 2));
        add(new Song("M. Jackson", "Earth Song", 3));
        add(new Song("M. Jackson", "Smooth Criminal", 10));
        add(new Song("Metallica", "Load", 30));
        add(new Song("Metallica", "The Unforgiven", 40));
    }};
    public void work() {
        Player mediaAll = new Player();
        String choice = "";
        System.out.println("");
        System.out.println("This is interactive multi media player");
        System.out.println("1- add new song, 2- list of songs in the player, 3 - play song, 4 - play all songs, 5 - add song after song name = , 6 - delete song name =, 7- exit");

        Scanner sc1 = new Scanner(System.in);

        while (!(choice.equals("7"))) {
            System.out.println();
            System.out.print("Input your choice = ");
            choice = sc1.nextLine();

            switch (choice) {
                case "1": {
                    songNew();
                    sc1.reset();
                    break;
                }

                case "2": {
                    outputListOfSong();
                    sc1.reset();
                    break;
                }

                case "3": {
                    playSong();
                    sc1.reset();
                    break;
                }

                case "4": {
                    //TODO
                    sc1.reset();
                    break;
                }

                case "5": {
                    findSongAndAdd();
                    sc1.reset();
                    break;
                }

                case "6": {
                    deleteSong();
                    sc1.reset();
                    break;
                }

                case "7": {
                    sc1.reset();
                    break;
                }

            }
        }
    }

    public void findSongAndAdd() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input name of song after which add a new one = ");
        String songName = sc.nextLine();
        boolean isFoundSong = false;
        for (int i = 0; i < mediaPlayer.size(); i++) {
            Song song1 = new Song("", "", 0);
            song1 = mediaPlayer.get(i);
            if (song1.getName().equals(songName)) {
                songNew(i);
                System.out.println("Song have added!!!");
                isFoundSong = true;
                break;
            }
        }
        if (isFoundSong == false) System.out.println("This song absent in media player");
    }

    public void songNew(int index) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input Author name = ");
        String songAuthor = sc.nextLine();
        System.out.print("Input Song name = ");
        String songName = sc.nextLine();
        System.out.print("Input song length (s) = ");
        int songLength = sc.nextInt();
        mediaPlayer.add(index+1, new Song(songAuthor, songName, songLength));
    }

    public void songNew() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input Author name = ");
        String songAuthor = sc.nextLine();
        System.out.print("Input Song name = ");
        String songName = sc.nextLine();
        System.out.print("Input song length (s) = ");
        int songLength = sc.nextInt();
        mediaPlayer.add(new Song(songAuthor, songName, songLength));
    }

    public void deleteSong(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input name of delete song = ");
        String songName = sc.nextLine();
        boolean isFoundSong = false;
        for (int i = 0; i < mediaPlayer.size(); i++) {
            Song song1 = new Song("", "", 0);
            song1 = mediaPlayer.get(i);
            if (song1.getName().equals(songName)) {
                mediaPlayer.remove(i);
                System.out.println("Song have deleted!!!");
                isFoundSong = true;
                break;
            }
        }
        if (isFoundSong == false) System.out.println("This song absent in media player");
    }

    public void outputListOfSong(){
        int indexQueue = 0;
        for (Song song : mediaPlayer) {
            System.out.println("#" + indexQueue + " = " + song.toString());
            indexQueue++;
        }
        System.out.println();
    }

    public void playSong(){

        System.out.print("Input number of song for play = ");
        Scanner sc = new Scanner(System.in);
        int songIndex = 0;
        try {
            songIndex = sc.nextInt();
        } catch (Exception e) {
            System.out.println("wrong number of song");
        }
        if (songIndex <= mediaPlayer.size()) {
            System.out.println(mediaPlayer.get(songIndex).toString() + "playing...");
            Player.work(mediaPlayer.get(songIndex));

            SongStarter songStarter = new SongStarter(mediaPlayer.get(songIndex));
            Iterruptor iterruptor = new Iterruptor();

            songStarter.start();
            iterruptor.start();

            while ((songStarter.getState() != Thread.State.TERMINATED) && (iterruptor.getState() != Thread.State.TERMINATED)) {
            }

            songStarter.interrupt();
            iterruptor.interrupt();

        }else{
            System.out.println("wrong number of song");
        }
    }
}
