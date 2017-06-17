package com.github.wangxuxin.performancemonitor;

import android.os.Handler;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by a1274 on 2017/6/17.
 */
public class CommandService extends Thread {

    private int type;
    private Handler handler;

    CommandService(Handler handler,int type){
        this.type=type;
        this.handler=handler;
    }

    @Override
    public void run(){
        if(type==1){
            top();
        }else if(type==2){
            killall();
        }
    }

    private void top(){
        try {
            TextUpdateService textUpdate=new TextUpdateService(handler);
            Process p  = Runtime.getRuntime().exec("top -m 10 -d 1");
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null
                    && !line.equals("null")) {
                if("\n".equals(line)){
                    continue;
                }if("".equals(line)){
                    continue;
                }
                Log.d("wxxDebug", line);
                textUpdate.add(line);
            }
            Log.d("wxxDebug","stoptop");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void killall(){
        try {
            Runtime.getRuntime().exec("killall top");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


