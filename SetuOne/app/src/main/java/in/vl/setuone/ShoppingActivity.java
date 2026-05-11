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

public class ShoppingActivity extends AppCompatActivity {

    ImageView ivFlipkart , ivAmazon , ivMyntra , ivMeesho , ivShopsy , ivGlowroad;
    TextView tvExploreFurtherClickHere;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shopping);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ivFlipkart = findViewById(R.id.iv_flipkart);
        ivAmazon = findViewById(R.id.iv_amazon);
        ivMyntra = findViewById(R.id.iv_myntra);
        ivMeesho = findViewById(R.id.iv_meesho);
        ivShopsy = findViewById(R.id.iv_shopsy);
        ivGlowroad = findViewById(R.id.iv_glowroad);
        tvExploreFurtherClickHere = findViewById(R.id.tvExploreFurtherClickHere);

        ivFlipkart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadURL(ShoppingActivity.this , "https://www.flipkart.com/");
            }
        });

        ivAmazon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadURL(ShoppingActivity.this , "https://www.amazon.in/");
            }
        });

        ivMyntra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadURL(ShoppingActivity.this , "https://www.myntra.com/");
            }
        });

        ivMeesho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadURL(ShoppingActivity.this , "https://www.meesho.com/");
            }
        });

        ivShopsy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadURL(ShoppingActivity.this , "https://www.shopsy.in/");
            }
        });

        ivGlowroad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadURL(ShoppingActivity.this , "https://glowroad.com/");
            }
        });

        // Start blinking animation
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        tvExploreFurtherClickHere.startAnimation(animation);

        tvExploreFurtherClickHere.setOnClickListener(v -> {
            loadURL(ShoppingActivity.this , "https://www.google.co.in/");
        });

    }

}