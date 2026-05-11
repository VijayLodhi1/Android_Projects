package in.vl.vsplayer;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;

public class SongsCustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<Songs> songsArrayList;

    SongsCustomAdapter(Context context , ArrayList<Songs> songsArrayList)
    {
        this.context = context;
        this.songsArrayList = songsArrayList;
    }

    @Override
    public int getCount() {
        if(songsArrayList != null && songsArrayList.size() > 0)
        {
            return songsArrayList.size();
        }
        else
        {
            return 0;
        }
    }

    @Override
    public Object getItem(int position) {
        return songsArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null)
        {
            view = LayoutInflater.from(context).inflate(R.layout.activity_songs_custom_adapter , viewGroup , false);
        }

        LinearLayout mainLinearLayout = view.findViewById(R.id.main_linear_layout);
        TextView tvSong = view.findViewById(R.id.tv_song);
        tvSong.setText(songsArrayList.get(i).getSongName());

        mainLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context , PlaySongsActivity.class);
                SongsSingleton.setStaticSongsList(songsArrayList);
                intent.putExtra("i" , i);
                context.startActivity(intent);
            }
        });

        return view;
    }

}
