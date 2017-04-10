package comnikitc.github.mobdev_hw_1;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;

public class MyView extends View {
    final String TAG = "lifecycle";
    Context contextView;

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        contextView = context;
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        showToast("MyView dispatchDraw");
        Log.d(TAG, "MyView dispatchDraw");
        super.dispatchDraw(canvas);
    }


    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        showToast("MyView onLayout");
        Log.d(TAG, "MyView onLayout");
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onAttachedToWindow() {
        showToast("MyView onAttachedToWindow");
        Log.d(TAG, "MyView onAttachedToWindow");
        super.onAttachedToWindow();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        showToast("MyView onDraw");
        Log.d(TAG, "MyView onDraw");

        Rect myRect = new Rect();
        myRect.set(0, 150, 150, 500);
        Paint greenPaint = new Paint();
        greenPaint.setColor(0xff000000);
        greenPaint.setStyle(Paint.Style.FILL);
        canvas.drawRect(myRect, greenPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        showToast("MyView onMeasure");
        Log.d(TAG, "MyView onMeasure");
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
    }

    protected void showToast(String message) {
        String currentTimeString = DateFormat.getTimeInstance().format(new Date());
        String toastMessage = message + " " + currentTimeString;
        Toast toast = Toast.makeText(contextView, toastMessage, Toast.LENGTH_SHORT);
        toast.show();
    }
}

