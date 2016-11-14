package com.example.zhaoxukl1314.mysurfaceview.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.LinearLayout;

import com.example.zhaoxukl1314.mysurfaceview.R;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by zhaoxukl1314 on 16/11/8.
 */

public class GameUI extends SurfaceView implements SurfaceHolder.Callback {

    private boolean mIsRendering;
    private final RenderThread mRenderThread;
    private final SurfaceHolder mHolder;
    private Man mMan;
    private Smile mSmile;
    private List<Smile> mSmiles;

    public GameUI(Context context) {
        super(context);
        mHolder = getHolder();
        mHolder.addCallback(this);
        mMan = new Man(BitmapFactory.decodeResource(getResources(), R.drawable.avatar_boy), null);
        mSmiles = new CopyOnWriteArrayList<Smile>();
        mRenderThread = new RenderThread();
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        mIsRendering = true;
        mRenderThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        mIsRendering = false;
    }

    public void handleOnTouchEvent(MotionEvent event) {
        Point touchPoint = new Point((int)event.getX(), (int)event.getY());
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mSmile = mMan.createSmile(BitmapFactory.decodeResource(getResources(), R.drawable.rating_small),touchPoint);
                mSmiles.add(mSmile);
                break;

            case MotionEvent.ACTION_MOVE:
                mSmile = mMan.createSmile(BitmapFactory.decodeResource(getResources(), R.drawable.rating_small),touchPoint);
                mSmiles.add(mSmile);
                break;

        }
    }

    private class RenderThread extends Thread {
        @Override
        public void run() {
            while (mIsRendering) {
                Canvas lockCanvas = mHolder.lockCanvas();
                try {
                    drawRect(lockCanvas);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (lockCanvas != null) {
                        mHolder.unlockCanvasAndPost(lockCanvas);
                    }
                }

            }
        }
    }

    private void drawRect(Canvas lockCanvas) {
        Paint paint = new Paint();
        paint.setColor(Color.GRAY);
        if (lockCanvas != null) {
            lockCanvas.drawRect(0,0,getWidth(),getHeight(),paint);

            mMan.draw(lockCanvas);
            if (mSmiles.size() > 0) {
                for (Smile smile: mSmiles) {
                    smile.draw(lockCanvas);
                    smile.move();

                    if (smile.getmPos().x < 0 || smile.getmPos().x > getWidth() || smile.getmPos().y < 0 || smile.getmPos().y > getHeight()) {
                        mSmiles.remove(smile);
                    }
                }
            }
        }
    }
}
