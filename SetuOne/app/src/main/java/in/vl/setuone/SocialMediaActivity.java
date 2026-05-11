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

public class SocialMediaActivity extends AppCompatActivity {

    ImageView ivFacebook , ivInstagram , ivTwitter , ivThread;
    TextView tvExploreFurtherClickHere;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_social_media);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ivFacebook = findViewById(R.id.iv_facebook);
        ivInstagram = findViewById(R.id.iv_instagram);
        ivTwitter = findViewById(R.id.iv_twitter);
        ivThread = findViewById(R.id.iv_thread);
        tvExploreFurtherClickHere = findViewById(R.id.tvExploreFurtherClickHere);

        ivFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadURL(SocialMediaActivity.this , "https://www.facebook.com/");
            }
        });

        ivInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadURL(SocialMediaActivity.this , "https://www.instagram.com/?hl=en");
            }
        });

        ivTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadURL(SocialMediaActivity.this , "https://twitter.com/?lang=en-in");
            }
        });

        ivThread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadURL(SocialMediaActivity.this , "https://www.threads.net/login");
            }
        });

        // Start blinking animation
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        tvExploreFurtherClickHere.startAnimation(animation);

        tvExploreFurtherClickHere.setOnClickListener(v -> {
            loadURL(SocialMediaActivity.this , "https://www.google.co.in/");
        });

    }

}