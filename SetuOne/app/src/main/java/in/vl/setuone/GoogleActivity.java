package in.vl.setuone;

import static in.vl.setuone.setuone_functions.Functions.*;

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

public class GoogleActivity extends AppCompatActivity {

    ImageView ivGoogle;
    ImageView ivYotube;
    ImageView ivGmail;
    ImageView ivGoogleDrive;
    TextView tvExploreFurtherClickHere;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_google);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ivGoogle = findViewById(R.id.ivGoogle);
        ivYotube = findViewById(R.id.ivYoutube);
        ivGmail = findViewById(R.id.ivGmail);
        ivGoogleDrive = findViewById(R.id.ivGoogleDrive);
        tvExploreFurtherClickHere = findViewById(R.id.tvExploreFurtherClickHere);

        ivGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadURL(GoogleActivity.this , "https://www.google.co.in/");
            }
        });

        ivYotube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadURL(GoogleActivity.this , "https://www.youtube.com/");
            }
        });

        ivGmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadURL(GoogleActivity.this , "https://mail.google.com/mail/u/0/#inbox");
            }
        });

        ivGoogleDrive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadURL(GoogleActivity.this , "https://drive.google.com/drive/u/0/home");
            }
        });

        // Start blinking animation
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        tvExploreFurtherClickHere.startAnimation(animation);

        tvExploreFurtherClickHere.setOnClickListener(v -> {
            loadURL(GoogleActivity.this , "https://www.google.co.in/");
        });

    }

}