package com.example.eventbusdemo;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class Bean {

    public final String message;
    public Bean(String message) {
        this.message = message;
    }

}
