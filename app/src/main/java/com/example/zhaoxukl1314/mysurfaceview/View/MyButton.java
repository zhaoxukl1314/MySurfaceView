package com.example.zhaoxukl1314.mysurfaceview.View;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;

import static android.content.ContentValues.TAG;

/**
 * Created by zhaoxukl1314 on 16/11/14.
 */

public class MyButton extends Sprit {

    private boolean mIsClick;
    private Bitmap mPressedImg;
    private OnClickListener mOnClickListener;

    public MyButton(Bitmap img, Point pox, Bitmap pressedImg) {
        super(img, pox);
        mIsClick = false;
        mPressedImg = pressedImg;
    }

    public void setIsClick(boolean isClick) {
        mIsClick = isClick;
    }

    public boolean isTouchingButton(Point point) {
        Rect rect = new Rect(mPos.x, mPos.y, mPos.x + mPressedImg.getWidth(), mPos.y + mPressedImg.getHeight());
        Log.d(TAG,"zhaoxu rect : " + rect);
        return rect.contains(point.x, point.y);
    }

    @Override
    public void draw(Canvas canvas) {
        if (mIsClick) {
            canvas.drawBitmap(mPressedImg, mPos.x, mPos.y, null);
        } else {
            super.draw(canvas);
        }
    }

    public interface OnClickListener {
        void onClick();
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        mOnClickListener = onClickListener;
    }

    public void click() {
        mOnClickListener.onClick();
    }
}
