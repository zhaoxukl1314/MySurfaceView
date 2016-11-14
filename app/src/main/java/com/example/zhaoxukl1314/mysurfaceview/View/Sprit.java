package com.example.zhaoxukl1314.mysurfaceview.View;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;

/**
 * Created by zhaoxukl1314 on 16/11/9.
 */

public class Sprit {

    protected Bitmap mImg;
    protected Point mPos;

    public Point getmPos() {
        return mPos;
    }

    public Sprit(Bitmap img, Point pox) {
        mImg = img;
        if (pox != null) {
            mPos = pox;
        } else {
            mPos = new Point(0,0);
        }
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(mImg, mPos.x, mPos.y, null);
    }
}
