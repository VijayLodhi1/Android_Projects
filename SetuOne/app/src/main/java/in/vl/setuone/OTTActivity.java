package in.vl.setuone;

import static in.vl.setuone.setuone_functions.Functions.loadURL;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OTTActivity extends AppCompatActivity {

    ImageView ivhotstar , ivSonyLiv , ivYouTube , ivAmzonPrimeVideo , ivMXPlayer , ivZee5 , ivNetflix;
    TextView tvExploreFurtherClickHere;
    Animation animation;

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

            ivhotstar = findViewById(R.id.iv_hotstar);
            ivSonyLiv = findViewById(R.id.iv_sonyliv);
            ivYouTube = findViewById(R.id.iv_youtube);
            ivAmzonPrimeVideo = findViewById(R.id.iv_amazon_prime_video);
            ivMXPlayer = findViewById(R.id.ivMXPlayer);
            ivZee5 = findViewById(R.id.iv_zee5);
            ivNetflix = findViewById(R.id.iv_netflix);
            tvExploreFurtherClickHere = findViewById(R.id.tvExploreFurtherClickHere);

            ivhotstar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    loadURL(OTTActivity.this ,"https://www.hotstar.com/in/");
                }
            });

            ivSonyLiv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    loadURL(OTTActivity.this ,"https://www.sonyliv.com/");
                }
            });

            ivYouTube.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    loadURL(OTTActivity.this ,"https://www.youtube.com/");
                }
            });

            ivAmzonPrimeVideo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    loadURL(OTTActivity.this ,"https://www.primevideo.com/");
                }
            });

        ivMXPlayer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    loadURL(OTTActivity.this ,"https://www.mxplayer.in/");
                }
            });

            ivZee5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    loadURL(OTTActivity.this ,"https://www.zee5.com/");
                }
            });

            ivNetflix.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    loadURL(OTTActivity.this ,"https://www.netflix.com/in/");
                }
            });

        // Start blinking animation
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        tvExploreFurtherClickHere.startAnimation(animation);

        tvExploreFurtherClickHere.setOnClickListener(v -> {
            loadURL(OTTActivity.this ,"https://www.google.co.in/");
        });

    }

}