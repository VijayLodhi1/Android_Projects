package in.vl.vsplayer;

import android.net.Uri;

public class Songs {
    private String songName;
    private Uri songUri;

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public Uri getSongUri() {
        return songUri;
    }

    public void setSongUri(Uri songUri) {
        this.songUri = songUri;
    }
}
