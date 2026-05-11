package in.vl.browser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements BrowserInterface {

    FrameLayout url_frame;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        url_frame = findViewById(R.id.url_frame);

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        UrlFragment urlFragment = new UrlFragment();
        fragmentTransaction.add(url_frame.getId() , urlFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onEnterUrlGo(String url) {

        Bundle bundle = new Bundle();
        bundle.putString("url" , url);

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        BrowserFragment browserFragment = new BrowserFragment();
        browserFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.browser_frame , browserFragment);
        fragmentTransaction.commit();
    }
}