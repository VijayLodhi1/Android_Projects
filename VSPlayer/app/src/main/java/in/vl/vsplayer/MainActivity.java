package in.vl.vsplayer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnStart;
    private final static int REQUEST_PERMISSION_CODE = 1;
    private String[] permissions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = findViewById(R.id.btn_start);

        permissions = new String[]
                {/*Manifest.permission.READ_EXTERNAL_STORAGE ,
                Manifest.permission.WRITE_EXTERNAL_STORAGE ,
                Manifest.permission.MANAGE_EXTERNAL_STORAGE ,*/
                        Manifest.permission.READ_MEDIA_AUDIO ,
                        Manifest.permission.READ_MEDIA_VIDEO /*,
                Manifest.permission.MANAGE_MEDIA*/ ,
                        Manifest.permission.ACCESS_NOTIFICATION_POLICY ,
                        /*Manifest.permission.BIND_NOTIFICATION_LISTENER_SERVICE ,*/
                        Manifest.permission.POST_NOTIFICATIONS};

        enableRuntimePermission(permissions);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextActivity();
            }
        });

    }

    private void enableRuntimePermission(String[] permissions)
    {
        boolean allPermissionsGranted = true;
        for(String permission : permissions)
        {
            if(ContextCompat.checkSelfPermission(MainActivity.this , permission) == PackageManager.PERMISSION_DENIED)
            {
                allPermissionsGranted = false;
                break;
            }
        }
        if(allPermissionsGranted)
        {
            nextActivity();
        }
        else
        {
            ActivityCompat.requestPermissions(MainActivity.this , permissions , REQUEST_PERMISSION_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == REQUEST_PERMISSION_CODE)
        {
            boolean allPermissionsGranted = true;
            for(int grantResult : grantResults)
            {
                if(grantResult == PackageManager.PERMISSION_DENIED)
                {
                    allPermissionsGranted = false;
                    break;
                }
            }
            if(allPermissionsGranted)
            {
                Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
                /*new AlertDialog.Builder(MainActivity.this)
                        .setCancelable(false)
                        .setMessage("PERMISSION REQUIRED")
                        .setPositiveButton("Grant", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                enableRuntimePermission(permissions);
                            }
                        })
                        .setNegativeButton("Deny", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                MainActivity.this.finish();
                            }
                        })
                        .show();*/
            }
        }
    }

    private void nextActivity()
    {
        startActivity(new Intent(MainActivity.this , ScanSongsVideosButtonActivity.class));
        finish();
    }

}