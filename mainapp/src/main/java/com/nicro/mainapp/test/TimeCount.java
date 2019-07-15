package com.nicro.mainapp.test;

import android.os.CountDownTimer;
import android.widget.TextView;

public class TimeCount extends CountDownTimer {

    private TextView tv_count;

    /**
     * @param millisInFuture    The number of millis in the future from the call
     *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
     *                          is called.
     * @param countDownInterval The interval along the way to receive
     *                          {@link #onTick(long)} callbacks.
     */
    public TimeCount(long millisInFuture, long countDownInterval, TextView tv_count) {
        super(millisInFuture, countDownInterval);
        this.tv_count = tv_count;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        tv_count.setEnabled(false);
        tv_count.setText(millisUntilFinished / 1000 + "秒");
    }

    @Override
    public void onFinish() {
        tv_count.setEnabled(true);
        tv_count.setText("获取验证码");
    }
}
