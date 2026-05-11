package in.vl.setuone;

import static in.vl.setuone.setuone_functions.Functions.loadURL;

import android.content.Intent;
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

public class RGPVActivity extends AppCompatActivity {

    ImageView ivRGPVDiploma;
    ImageView ivUITRGPV;
    ImageView ivRGPV;
    TextView tvExploreFurtherClickHere;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rgpvactivity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ivRGPVDiploma = findViewById(R.id.ivRGPVDiploma);
        ivUITRGPV = findViewById(R.id.ivUITRGPV);
        ivRGPV = findViewById(R.id.ivRGPV);
        tvExploreFurtherClickHere = findViewById(R.id.tvExploreFurtherClickHere);

        ivRGPVDiploma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadURL(RGPVActivity.this , "https://www.rgpvdiploma.in/");
            }
        });

        ivUITRGPV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadURL(RGPVActivity.this , "https://www.uitrgpv.ac.in/");
            }
        });

        ivRGPV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadURL(RGPVActivity.this , "https://www.rgpv.ac.in/");
            }
        });

        // Start blinking animation
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        tvExploreFurtherClickHere.startAnimation(animation);

        tvExploreFurtherClickHere.setOnClickListener(v -> {
            Intent intent = new Intent(this, BrowserActivity.class);
            loadURL(RGPVActivity.this , "https://www.google.co.in/");
            startActivity(intent);
        });

    }

}