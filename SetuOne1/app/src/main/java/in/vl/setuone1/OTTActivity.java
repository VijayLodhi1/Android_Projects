package in.vl.setuone1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OTTActivity extends AppCompatActivity {

    TextView tvWelcome;
    ImageView ivhotstar , ivSonyLiv , ivYouTube , ivAmzonPrimeVideo , ivMXPlayer , ivZee5 , ivNetflix ,
            ivDiscoveryPlus , ivCrunchyroll , ivRakutenViki , ivErosNow , ivShemaroo , ivAha , ivCuriosity ,
            ivUNext , ivVidio , ivShowmax , ivChorki , ivStan , ivStarZ , ivYouTubeTV;
    TextView tvExploreFurtherClickHere;
    Animation animation;
    Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ottactivity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets; // return statement must be the last in the lambda
        });

        tvWelcome = findViewById(R.id.tvWelcome);
        ivhotstar = findViewById(R.id.iv_hotstar);
        ivSonyLiv = findViewById(R.id.iv_sonyliv);
        ivYouTube = findViewById(R.id.iv_youtube);
        ivAmzonPrimeVideo = findViewById(R.id.iv_amazon_prime_video);
        ivMXPlayer = findViewById(R.id.ivMXPlayer);
        ivZee5 = findViewById(R.id.iv_zee5);
        ivNetflix = findViewById(R.id.iv_netflix);
        ivCrunchyroll = findViewById(R.id.ivCrunchyroll);
        ivRakutenViki = findViewById(R.id.ivRakutenViki);
        ivErosNow = findViewById(R.id.ivErosNow);
        ivShemaroo = findViewById(R.id.ivShemaroo);
        ivAha = findViewById(R.id.ivAha);
        ivCuriosity = findViewById(R.id.ivCuriosity);
        ivUNext = findViewById(R.id.ivUNext);
        ivVidio = findViewById(R.id.ivVidio);
        ivShowmax = findViewById(R.id.ivShowmax);
        ivChorki = findViewById(R.id.ivChorki);
        ivStan = findViewById(R.id.ivStan);
        ivStarZ = findViewById(R.id.ivStarZ);
        ivYouTubeTV = findViewById(R.id.ivYouTubeTV);
        tvExploreFurtherClickHere = findViewById(R.id.tvExploreFurtherClickHere);
        btnLogout = findViewById(R.id.btnLogOut);

        String pushID = getIntent().getStringExtra("pushID");
        // Set welcome message
        String username = getIntent().getStringExtra("username");
        tvWelcome.setText("Welcome " + (username != null ? username : "User"));

        ivhotstar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadURL("https://www.hotstar.com/in/");
            }
        });

        ivSonyLiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadURL("https://www.sonyliv.com/");
            }
        });

        ivYouTube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadURL("https://www.youtube.com/");
            }
        });

        ivAmzonPrimeVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadURL("https://www.primevideo.com/");
            }
        });

        ivMXPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadURL("https://www.mxplayer.in/");
            }
        });

        ivZee5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadURL("https://www.zee5.com/");
            }
        });

        ivNetflix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadURL("https://www.netflix.com/in/");
            }
        });

        ivCrunchyroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadURL("https://www.crunchyroll.com/");
            }
        });

        ivRakutenViki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadURL("https://www.viki.com/");
            }
        });

        ivErosNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadURL("https://erosnow.com/");
            }
        });

        ivShemaroo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadURL("https://shemarooent.com/");
            }
        });

        ivAha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadURL("https://www.aha.video/");
            }
        });

        ivCuriosity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadURL("https://curiositystream.com/");
            }
        });

        ivUNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadURL("https://video.unext.jp/");
            }
        });

        ivVidio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadURL("https://www.vidio.com/");
            }
        });

        ivShowmax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadURL("https://www.showmax.com/");
            }
        });

        ivChorki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadURL("http://www.chorki.com/");
            }
        });

        ivStan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadURL("https://www.stan.com.au/");
            }
        });

        ivStarZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadURL("https://www.starz.com/");
            }
        });

        ivYouTubeTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadURL("https://www.showmax.com/https://tv.youtube.com/");
            }
        });

        // Start blinking animation
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        tvExploreFurtherClickHere.startAnimation(animation);

        tvExploreFurtherClickHere.setOnClickListener(v -> {
            Intent intent = new Intent(this, BrowserActivity.class);
            intent.putExtra("URL", "https://www.google.co.in/");
            startActivity(intent);
        });

        btnLogout.setOnClickListener(v -> {
            startActivity(new Intent(this, LoginActivity.class));
            finish(); // Close this activity to prevent back navigation
        });

    }

    private void loadURL(String URL)
    {
        Intent intent = new Intent(OTTActivity.this , BrowserActivity.class);
        intent.putExtra("URL" , URL);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Exit App")
                .setMessage("Are you sure you want to exit?")
                .setPositiveButton("Yes", (dialog, which) -> {
                    super.onBackPressed();
                })
                .setNegativeButton("No", null)
                .show();
    }

}