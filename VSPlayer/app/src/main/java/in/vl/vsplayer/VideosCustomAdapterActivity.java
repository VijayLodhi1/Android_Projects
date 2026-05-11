package in.vl.vsplayer;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class VideosCustomAdapterActivity extends BaseAdapter {
    Context context;
    ArrayList<Videos> videosArrayList;

    VideosCustomAdapterActivity(Context context , ArrayList<Videos> videosArrayList)
    {
        this.context = context;
        this.videosArrayList = videosArrayList;
    }


    @Override
    public int getCount() {
        if(videosArrayList != null && videosArrayList.size() > 0)
        {
            return videosArrayList.size();
        }
        else
        {
            return 0;
        }
    }

    @Override
    public Object getItem(int position) {
        return videosArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null)
        {
            view = LayoutInflater.from(context).inflate(R.layout.activity_videos_custom_adapter , viewGroup , false);
        }

        LinearLayout mainLinearLayout = view.findViewById(R.id.main_linear_layout);
        TextView tvVideoName = view.findViewById(R.id.tv_video_name);
        tvVideoName.setText(videosArrayList.get(i).getVideoName());

        mainLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context , PlayVideosActivity.class);
                intent.putExtra("videoUri" , videosArrayList.get(i).getVideoUri().toString());
                context.startActivity(intent);
            }
        });

        return view;
    }
}
