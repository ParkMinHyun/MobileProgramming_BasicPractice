package com.example.parkminhyun.mobileprogramming;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {

    final static String KEY_INT_FROM_SERVICE = "KEY_INT_FROM_SERVICE";
    final static String ACTION_UPDATE_CNT = "UPDATE_CNT";

    CountServiceThread countServiceThread;
    double cnt;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        countServiceThread = new CountServiceThread();
        countServiceThread.start();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        countServiceThread.setRunning(false);
    }

    private class CountServiceThread extends Thread {

        private boolean running;

        public void setRunning(boolean running) {
            this.running = running;
        }

        @Override
        public void run() {
            cnt = 0.0;
            running = true;
            while (running) {
                try {
                    Thread.sleep(10);

                    Intent intent = new Intent();
                    intent.setAction(ACTION_UPDATE_CNT);
                    intent.putExtra(KEY_INT_FROM_SERVICE, cnt);
                    sendBroadcast(intent);

                    cnt += 0.01;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}