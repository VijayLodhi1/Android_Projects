package in.vl.setuone.setuone_functions;

import android.content.Context;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import in.vl.setuone.BrowserActivity;

public class Functions
{
    public static void loadURL(Context context , String URL)
    {
        Intent intent = new Intent(context , BrowserActivity.class);
        intent.putExtra("URL" , URL);
        context.startActivity(intent);
    }

    public static void viewPreference(Context context , AppCompatActivity appCompatActivity)
    {
        context.startActivity(new Intent(context , appCompatActivity.getClass()));
    }

}
