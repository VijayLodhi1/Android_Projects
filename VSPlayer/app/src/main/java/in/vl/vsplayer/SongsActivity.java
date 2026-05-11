package in.vl.vsplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class SongsActivity extends AppCompatActivity {

    ListView songsListView;
    SearchView songsSearchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);

        songsListView = findViewById(R.id.songs_list_view);
        songsSearchView = findViewById(R.id.songs_serchview);

        SongsCustomAdapter songsCustomAdapter = new SongsCustomAdapter(this , loadSongs());
        songsListView.setAdapter(songsCustomAdapter);

        songsSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

    }

    private ArrayList<Songs> loadSongs()
    {
        ArrayList<Songs> songsArrayList = new ArrayList<>();
        Cursor songsCursor = getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI , null , null , null , null , null);
        while (songsCursor.moveToNext())
        {
            Songs songs = new Songs();
            String songTitle = songsCursor.getString(songsCursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
            songs.setSongName(songTitle);
            String songUri = songsCursor.getString(songsCursor.getColumnIndex(MediaStore.Audio.Media.DATA));
            songs.setSongUri(Uri.parse(songUri));
            songsArrayList.add(songs);
        }

        songsCursor.close();

        return songsArrayList;
    }

}