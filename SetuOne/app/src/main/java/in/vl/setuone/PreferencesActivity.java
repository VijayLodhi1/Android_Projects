package in.vl.setuone;

import static in.vl.setuone.setuone_functions.Functions.*;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class PreferencesActivity extends AppCompatActivity {

    TextView tvWelcome;
    Button btnGoogle, btnGovernmentPortals, btnRGPV, btnSchoolEducationPortals,
            btnShopping, btnAI, btnSocialMedia, btnOTT, btnLogout;
    TextView tvExploreFurtherClickHere;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_preferences);

        tvWelcome = findViewById(R.id.tvWelcome);
        btnGoogle = findViewById(R.id.btnGoogle);
        btnGovernmentPortals = findViewById(R.id.btnGovernmentPortals);
        btnRGPV = findViewById(R.id.btnRGPV);
        btnSchoolEducationPortals = findViewById(R.id.btnSchoolEducationPortals);
        btnShopping = findViewById(R.id.btn_shopping);
        btnAI = findViewById(R.id.btn_ai);
        btnSocialMedia = findViewById(R.id.btn_social_media);
        btnOTT = findViewById(R.id.btn_ott);
        tvExploreFurtherClickHere = findViewById(R.id.tvExploreFurtherClickHere);
        btnLogout = findViewById(R.id.btnLogOut); // Make sure this exists in your layout

        String username = getIntent().getStringExtra("username");
        tvWelcome.setText("Welcome " + username);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });

        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPreference(PreferencesActivity.this , new GoogleActivity());
            }
        });

        btnGovernmentPortals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPreference(PreferencesActivity.this , new GovernemntPortalsActivity());
            }
        });

        btnRGPV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPreference(PreferencesActivity.this , new RGPVActivity());
            }
        });

        btnSchoolEducationPortals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPreference(PreferencesActivity.this , new SchoolEducationPortalsActivity());
            }
        });

        btnShopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPreference(PreferencesActivity.this , new ShoppingActivity());
            }
        });

        btnAI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPreference(PreferencesActivity.this , new AIActivity());
            }
        });

        btnSocialMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPreference(PreferencesActivity.this , new SocialMediaActivity());
            }
        });

        btnOTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPreference(PreferencesActivity.this , new OTTActivity());
            }
        });

        // Start blinking animation
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        tvExploreFurtherClickHere.startAnimation(animation);

        tvExploreFurtherClickHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadURL(PreferencesActivity.this , "https://www.google.co.in/");
            }
        });

    }

    private void logout()
    {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(PreferencesActivity.this , LoginActivity.class));
        finish();
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