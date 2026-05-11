package in.vl.vsplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ScanSongsVideosButtonActivity extends AppCompatActivity {

    Button btnScanSongs , btnScanVideos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_songs_videos_button);

        btnScanSongs = findViewById(R.id.btn_scan_songs);
        btnScanVideos = findViewById(R.id.btn_scan_videos);

        btnScanSongs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ScanSongsVideosButtonActivity.this , SongsActivity.class);
                startActivity(intent);
            }
        });

        btnScanVideos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ScanSongsVideosButtonActivity.this , VideosActivity.class);
                startActivity(intent);
            }
        });

    }
}