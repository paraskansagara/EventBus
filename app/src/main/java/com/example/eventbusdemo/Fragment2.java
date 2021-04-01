package com.example.eventbusdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class Fragment2 extends Fragment {
    TextView tv_showText;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.layout_fragment2,container,false);
        tv_showText=view.findViewById(R.id.frg2_show_text);
        return view;
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessage(Bean event) {
        tv_showText.setText(event.message);
       //Toast.makeText(getActivity(), event.message, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
