package com.example.zhaoxukl1314.mysurfaceview.View;

import android.graphics.Bitmap;
import android.graphics.Point;

/**
 * Created by zhaoxukl1314 on 16/11/9.
 */

public class Smile extends Sprit {

    private int dx;
    private int dy;

    public Smile(Bitmap img, Point pox, Point touchPoint) {
        super(img, pox);

        int x = touchPoint.x - pox.x;
        int y = touchPoint.y - pox.y;

        int distance = (int) Math.sqrt(x * x + y * y);

        dx = x * 30 / distance;
        dy = y * 30 / distance;
    }

    public void move() {
        mPos.x += dx;
        mPos.y += dy;
    }
}
