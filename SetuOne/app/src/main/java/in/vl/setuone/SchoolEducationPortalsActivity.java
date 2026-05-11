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

public class SchoolEducationPortalsActivity extends AppCompatActivity {

    ImageView ivCBSE;
    ImageView ivMPBSE;
    ImageView ivCISCE;
    ImageView ivKVS;
    TextView tvExploreFurtherClickHere;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_school_education_portals);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ivCBSE = findViewById(R.id.iv_cbse);
        ivMPBSE = findViewById(R.id.iv_mpbse);
        ivCISCE = findViewById(R.id.ivCISCE);
        ivKVS = findViewById(R.id.ivKVS);
        tvExploreFurtherClickHere = findViewById(R.id.tvExploreFurtherClickHere);

        ivCBSE .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadURL(SchoolEducationPortalsActivity.this , "https://www.cbse.gov.in/");
            }
        });

        ivMPBSE .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadURL(SchoolEducationPortalsActivity.this , "https://www.mpbse.nic.in/");
            }
        });

        ivCISCE .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        ivKVS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadURL(SchoolEducationPortalsActivity.this , "https://kvsangathan.nic.in/");
            }
        });

        // Start blinking animation
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        tvExploreFurtherClickHere.startAnimation(animation);

        tvExploreFurtherClickHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadURL(SchoolEducationPortalsActivity.this , "https://www.google.co.in/");
            }
        });

    }

}