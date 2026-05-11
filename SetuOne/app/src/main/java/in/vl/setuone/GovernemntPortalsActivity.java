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

public class GovernemntPortalsActivity extends AppCompatActivity {

    ImageView ivMPTAAS;
    ImageView ivMPOnlineLimited;
    ImageView ivMPDTE;
    ImageView ivSamagraPortal;
    TextView tvExploreFurtherClickHere;
    Animation animation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_governemnt_portals);

        ivMPTAAS = findViewById(R.id.ivMPTAAS);
        ivMPOnlineLimited = findViewById(R.id.ivMPOnlineLimited);
        ivMPDTE = findViewById(R.id.ivMPDTE);
        ivSamagraPortal = findViewById(R.id.ivSamagraPortal);
        tvExploreFurtherClickHere = findViewById(R.id.tvExploreFurtherClickHere);

        ivMPTAAS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadURL(GovernemntPortalsActivity.this , "https://www.tribal.mp.gov.in/mptaas/");
            }
        });

        ivMPOnlineLimited.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadURL(GovernemntPortalsActivity.this , "https://www.mponline.gov.in/");
            }
        });

        ivMPDTE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadURL(GovernemntPortalsActivity.this , "https://dte.mponline.gov.in/");
            }
        });

        ivSamagraPortal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadURL(GovernemntPortalsActivity.this , "https://samagra.gov.in/");
            }
        });

        // Start blinking animation
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        tvExploreFurtherClickHere.startAnimation(animation);

        tvExploreFurtherClickHere.setOnClickListener(v -> {
            loadURL(GovernemntPortalsActivity.this , "https://www.google.co.in/");
        });

    }

}