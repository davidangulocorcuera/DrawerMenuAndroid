package com.example.biolizard.drawermenu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainFragment extends Fragment {
    private String str_textForSend;
    @BindView(R.id.textView_principal)
    TextView tv_firstText;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            str_textForSend = getArguments().getString(MainActivity.KEY);
        }
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        ButterKnife.bind(this, view);
        updateView(str_textForSend);
        return  view;
    }
    public void updateView(String texto){
        if (texto!=null) {
            tv_firstText.setText(texto);
        }
    }
    public interface OnFragmentInteractionListener {
        void changeText(String texto);
    }
}
