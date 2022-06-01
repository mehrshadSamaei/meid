package song;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    public Album() {
    }

    public boolean addSong(String title, double duration) {
        if (findSong(title) == null) {
            songs.add(new Song(title, duration));
//            System.out.println("successfully added to the list");
            return true;
        } else {
            System.out.println("song with name " + title + "already exist in  the list");
            return false;
        }

    }

    public Song findSong(String title) {
        for (Song checkedSong : songs) {
//            if(checkedSong.getTitle().equals(title));
            if (checkedSong.getTitle().equals(title))
                return checkedSong;
        }
        return null;
    }

    public boolean addPlayList(int trackNum, LinkedList<Song> playList) {
        int index = trackNum - 1;
        if (index > 0 && index <= this.songs.size()) {
            playList.add(this.songs.get(index));
            return true;
        }
        System.out.println("this album does not have song with trackNumber " + trackNum);
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        for (Song checkedSong : this.songs) {
            if (checkedSong.getTitle().equals(title)) {
                playList.add(checkedSong);
                return true;
            }
        }
        System.out.println(title + " there is no such song in album");
        return false;
    }
}
