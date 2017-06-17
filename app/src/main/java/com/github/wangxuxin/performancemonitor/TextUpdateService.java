package com.github.wangxuxin.performancemonitor;

import android.os.Handler;
import android.os.Message;

/**
 * Created by a1274 on 2017/6/17.
 */
public class TextUpdateService {

    int textline=12;
    private Handler handler;
    private String Text="";
    private String[] Temp=new String[textline];
    int length=0;

    TextUpdateService(Handler handler){
        this.handler=handler;
    }

    public void add(String text){
        if(length>textline){
            update();
        }else if(length==textline){
            //Temp[length]=text;
            update();
        }else if(length<textline){
            Temp[length]=text;
            length++;
        }
    }

    private void update(){
        if(length==textline){
            for(int i=0;i<Temp.length;i++){
                /*
                switch (i){
                    case 0:
                        continue;
                    case 1:
                        continue;
                    case 2:
                        continue;
                    default:
                        */
                        Text=Text+Temp[i]+"\n";
                //}
            }
            Message message=new Message();
            message.what=1;
            message.obj=Text;
            handler.sendMessage(message);
            Text="";
            length=0;
        }
        Temp=new String[textline];
    }
}
