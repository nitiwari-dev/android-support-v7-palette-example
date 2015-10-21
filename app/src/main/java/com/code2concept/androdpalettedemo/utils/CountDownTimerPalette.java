package com.code2concept.androdpalettedemo.utils;

import android.os.CountDownTimer;
import android.util.Log;

import com.code2concept.androdpalettedemo.i.INotifyTimer;


public class CountDownTimerPalette extends CountDownTimer {

    private static final String TAG = CountDownTimerPalette.class.getName();
    private final INotifyTimer iNotifyTimer;

    public CountDownTimerPalette(long millisInFuture, long countDownInterval, INotifyTimer iNotifyTimer) {
        super(millisInFuture, countDownInterval);
        this.iNotifyTimer = iNotifyTimer;
    }

    @Override
    public void onTick(long millisUntilFinished) {

        int tick = (int)millisUntilFinished/1000;

        iNotifyTimer.onTick(tick);

        Log.d(TAG, "Tick||" + tick);
    }

    @Override
    public void onFinish() {
        iNotifyTimer.onFinish();
    }
}
