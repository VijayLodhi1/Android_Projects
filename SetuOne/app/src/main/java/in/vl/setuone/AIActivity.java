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

public class AIActivity extends AppCompatActivity {

    ImageView ivChatGPT;
    ImageView ivGoogleGemini;
    ImageView ivPerplexity;
    ImageView ivDeepSeek;
    ImageView ivGitHubCopilot;
    TextView tvExploreFurtherClickHere;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_aiactivity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ivChatGPT = findViewById(R.id.iv_chatgpt);
        ivGoogleGemini = findViewById(R.id.iv_google_gemini);
        ivPerplexity = findViewById(R.id.iv_perplexity);
        ivDeepSeek = findViewById(R.id.iv_deepseek);
        ivGitHubCopilot = findViewById(R.id.iv_github_copilot);
        tvExploreFurtherClickHere = findViewById(R.id.tvExploreFurtherClickHere);

        ivChatGPT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadURL(AIActivity.this, "https://chatgpt.com/");
            }
        });

        ivGoogleGemini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadURL(AIActivity.this, "https://gemini.google.com/app?utm_source=deepmind.google&utm_medium=referral&utm_campaign=gdm&utm_content=");
            }
        });

        ivPerplexity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadURL(AIActivity.this, "https://www.perplexity.ai/");
            }
        });

        ivDeepSeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadURL(AIActivity.this, "https://www.deepseek.com/en/");
            }
        });

        ivGitHubCopilot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadURL(AIActivity.this, "https://github.com/copilot");
            }
        });

        // Start blinking animation
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        tvExploreFurtherClickHere.startAnimation(animation);

        tvExploreFurtherClickHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadURL(AIActivity.this , "https://www.google.co.in/");
            }
        });

    }

}