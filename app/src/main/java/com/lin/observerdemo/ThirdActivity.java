package com.lin.observerdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by beck on 2018/5/9.
 */

public class ThirdActivity extends Activity implements ObserverListener {

    private static final String TAG = "ThirdActivity";
    private TextView tv;
    private Button btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        tv = findViewById(R.id.tv_content);
        btn = findViewById(R.id.btn_refresh);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "onClick: ");
                ObserverManager.getInstance().notifyObserver("观察者请刷新信息");
            }
        });
        ObserverManager.getInstance().add(this);
    }

    @Override
    public void observerUpData(String content) {
        Log.i(TAG, "observerUpData: activity3");
        tv.setText(content);
    }
}
