package in.vl.vsplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaySongsActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    ImageView btnPrevious, btnPlay , btnPause , btnNext;
    TextView tvSongName , tvSongDuration;
    SeekBar songProgress;
    Thread updateSongProgress;
    ArrayList<Songs> songsArrayList;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_songs);

        btnPrevious = findViewById(R.id.previous_button);
        btnPause = findViewById(R.id.pause_button);
        btnNext = findViewById(R.id.next_button);
        tvSongName = findViewById(R.id.song_name);
        songProgress = findViewById(R.id.song_progress);

        Intent intent = getIntent();
        songsArrayList = SongsSingleton.getStaticSongsList();
        i = intent.getIntExtra("i" , 0);

        playSong(i);

        songProgress.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(songProgress.getProgress());
            }
        });

        updateSongProgress = new Thread()
        {
            @Override
            public void run() {
                try
                {
                    while(mediaPlayer != null && mediaPlayer.isPlaying())
                    {
                        int currentPosition = mediaPlayer.getCurrentPosition();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                songProgress.setProgress(currentPosition);
                            }
                        });
                        Thread.sleep(1000); // Update progress every second
                    }
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        };
        updateSongProgress.start();

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pauseSong();
            }
        });

        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                previousSong();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextSong();
            }
        });

    }

    private void playSong(int i)
    {
        tvSongName.setText(songsArrayList.get(i).getSongName());
        tvSongName.setSelected(true);

        mediaPlayer = new MediaPlayer();

        mediaPlayer = MediaPlayer.create(getApplicationContext() , songsArrayList.get(i).getSongUri());

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                playNextSong();
            }
        });

        mediaPlayer.start();
        songProgress.setProgress(0);
        songProgress.setMax(mediaPlayer.getDuration());
        btnPause.setImageResource(R.drawable.pause);
    }

    private void pauseSong()
    {
        if(mediaPlayer.isPlaying())
        {
            btnPause.setImageResource(R.drawable.play);
            mediaPlayer.pause();
        }
        else
        {
            btnPause.setImageResource(R.drawable.pause);
            mediaPlayer.start();
        }
    }

    private void previousSong()
    {
        if(mediaPlayer.isPlaying() && mediaPlayer != null)
        {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
        i = (i != 0) ? (i - 1) : (songsArrayList.size() - 1);
        playSong(i);
    }

    private void nextSong()
    {
        if(mediaPlayer.isPlaying() && mediaPlayer != null)
        {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
        i = (i < songsArrayList.size() - 1) ? (i + 1) : 0;
        playSong(i);
    }

    private void playNextSong()
    {
        i = (i < songsArrayList.size() - 1) ? (i + 1) : 0;
        playSong(i);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        mediaPlayer.release();
        updateSongProgress.interrupt();
    }

}