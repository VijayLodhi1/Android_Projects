package in.vl.vsplayer;

import java.util.ArrayList;

public class SongsSingleton {
    private static ArrayList<Songs> staticSongsList;

    public static ArrayList<Songs> getStaticSongsList() {
        return staticSongsList;
    }

    public static void setStaticSongsList(ArrayList<Songs> songsArrayList) {
        staticSongsList = songsArrayList;
    }
}
