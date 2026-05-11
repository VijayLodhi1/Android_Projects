package in.vl.browser;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class UrlFragment extends Fragment {

    BrowserInterface browserInterface;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try
        {
            browserInterface = (BrowserInterface) context;
        }
        catch(ClassCastException e)
        {
            Log.e("ClassCastException" , e.toString());
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.from(getContext()).inflate(R.layout.url_fragment , container , false);
        EditText edUrl = view.findViewById(R.id.ed_url);
        Button btnGo = view.findViewById(R.id.btn_go);
        Button btnClear = view.findViewById(R.id.btn_clear);

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                browserInterface.onEnterUrlGo(edUrl.getText().toString());
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edUrl.setText("");
            }
        });

        return view;
    }
}
