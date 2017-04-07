package comnikitc.github.mobdev_hw_1;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class MyView extends View {
    final String TAG = "lifecycle";

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.d(TAG, "View is drawn");

        Rect myRect = new Rect();
        myRect.set(0, 150, 150, 500);
        Paint greenPaint = new Paint();
        greenPaint.setColor(0xff000000);
        greenPaint.setStyle(Paint.Style.FILL);
        canvas.drawRect(myRect, greenPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.d(TAG, "View is measured");

        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
    }
}

