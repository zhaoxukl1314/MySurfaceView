package com.example.zhaoxukl1314.mysurfaceview.View;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;

/**
 * Created by zhaoxukl1314 on 16/11/9.
 */

public class Man extends Sprit {

    public static final int DOWN = 0;

    public Man(Bitmap img, Point pox) {
        super(img, pox);
    }

    public Smile createSmile(Bitmap img, Point touchPoint) {
        Point point = new Point(mPos.x + 200, mPos.y + 150);
        Smile smile = new Smile(img, point, touchPoint);
        return smile;
    }

    public void move(int direction) {
        switch (direction) {
            case DOWN:
                mPos.y += 30;
                break;
        }
    }
}
