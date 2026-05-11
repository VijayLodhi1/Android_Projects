package in.vl.vsplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ListView;

import java.util.ArrayList;

public class VideosActivity extends AppCompatActivity {

    ListView videosListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);

        videosListView = findViewById(R.id.videos_list_view);

        VideosCustomAdapterActivity videosCustomAdapterActivity = new VideosCustomAdapterActivity(this , loadVideos());
        videosListView.setAdapter(videosCustomAdapterActivity);

    }

    private ArrayList<Videos> loadVideos()
    {
        ArrayList<Videos> videosArrayList = new ArrayList<>();
        ContentResolver videosContentResolver = getContentResolver();
        Uri videosUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        Cursor videosCursor = videosContentResolver.query(videosUri , null , null , null , null , null);
        if(videosCursor != null && videosCursor.moveToNext())
        {
            int videosTitleColumn = videosCursor.getColumnIndex(MediaStore.Video.Media.TITLE);
            int videosUriColumn = videosCursor.getColumnIndex(MediaStore.Video.Media.DATA);
            do
            {
                Videos videos = new Videos();
                String videoName = videosCursor.getString(videosTitleColumn);
                videos.setVideoName(videoName);
                String videoUri = videosCursor.getString(videosUriColumn);
                videos.setVideoUri(Uri.parse(videoUri));
                videosArrayList.add(videos);
            }while(videosCursor.moveToNext());
        }

        return videosArrayList;
    }

}