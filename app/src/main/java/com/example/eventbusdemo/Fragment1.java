package com.example.eventbusdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


public class Fragment1 extends Fragment {
    Button btn_ok;
    EditText et_EnterText;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.layout_fragment1,container,false);

        btn_ok=view.findViewById(R.id.frg1_btn_ok);
        et_EnterText=view.findViewById(R.id.frg1_et_text);
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text=et_EnterText.getText().toString();
                EventBus.getDefault().post(new Bean(text));

            }
        });
        return view;
    }
//    @Subscribe
//    public void onMessageEvent(Bean event) {
//      // tv_showText.setText(event.message);
//        Toast.makeText(getActivity(), event.message, Toast.LENGTH_SHORT).show();
//    }



}
