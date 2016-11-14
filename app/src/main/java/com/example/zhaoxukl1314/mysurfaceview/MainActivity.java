package com.example.zhaoxukl1314.mysurfaceview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import android.widget.TextView;

import com.example.zhaoxukl1314.mysurfaceview.View.GameUI;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    private GameUI mGameUI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        mGameUI = new GameUI(this);
        setContentView(mGameUI);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mGameUI.handleOnTouchEvent(event);
        return super.onTouchEvent(event);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
