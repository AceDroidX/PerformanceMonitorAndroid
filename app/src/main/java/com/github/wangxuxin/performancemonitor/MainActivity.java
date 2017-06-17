package com.github.wangxuxin.performancemonitor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Switch floatingSwitch =(Switch) findViewById(R.id.switch1);
        floatingSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(MainActivity.this,FloatingService.class);
                if(isChecked){
                    Log.d("wxxDebugif","is checked");
                    startService(intent);
                }else {
                    Log.d("wxxDebugif","isn't checked");
                    stopService(intent);
                }
            }
        });

        Button aboutButton = (Button)findViewById(R.id.about_button);
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                //intent.putExtra("type",type+"/"+l);
                intent.setClass(MainActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });
    }

    /*
    public void buttonListener(View v) {
        Intent intent = new Intent(MainActivity.this,FloatingService.class);
        switch (v.getId()) {
            case R.id.open_button:
                startService(intent);
                break;
            case R.id.close_button:
                stopService(intent);
                break;
            default:
                break;
        }
    }
    */
}
