package comnikitc.github.mobdev_hw_1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;

public class TagLayout extends ViewGroup {
    int deviceWidth;
    final String TAG = "lifecycle";
    Context contextViewGroup;

    public TagLayout(Context context) {
        this(context, null, 0);
    }

    public TagLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TagLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
        contextViewGroup = context;
    }

    private void init(Context context) {
        final Display display =
                ((WindowManager) context
                        .getSystemService(Context.WINDOW_SERVICE))
                        .getDefaultDisplay();

        Point deviceDisplay = new Point();
        display.getSize(deviceDisplay);
        deviceWidth = deviceDisplay.x;
    }

    @Override
    protected void onAttachedToWindow() {
        showToast("ViewGroup onAttachedToWindow");
        Log.d(TAG, "ViewGroup onAttachedToWindow");
        super.onAttachedToWindow();
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        showToast("ViewGroup dispatchDraw");
        Log.d(TAG, "ViewGroup dispatchDraw");
        super.dispatchDraw(canvas);

    }

    @Override
    public void onViewAdded(View child) {
        showToast("ViewGroup onViewAdded");
        Log.d(TAG, "ViewGroup onViewAdded");
        super.onViewAdded(child);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        showToast("ViewGroup onLayout");
        Log.d(TAG, "ViewGroup onLayout");

        final int count = getChildCount();
        int curWidth, curHeight, curLeft, curTop;

        final int childLeft = this.getPaddingLeft();
        final int childTop = this.getPaddingTop();
        final int childRight = this.getMeasuredWidth() - this.getPaddingRight();
        final int childBottom = this.getMeasuredHeight() - this.getPaddingBottom();
        final int childWidth = childRight - childLeft;
        final int childHeight = childBottom - childTop;

        curLeft = childLeft;
        curTop = childTop;

        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);

            child.measure(MeasureSpec.makeMeasureSpec(childWidth, MeasureSpec.AT_MOST),
                    MeasureSpec.makeMeasureSpec(childHeight, MeasureSpec.AT_MOST));
            curWidth = child.getMeasuredWidth();
            curHeight = child.getMeasuredHeight();
            child.layout(curLeft, curTop, curLeft + curWidth, curTop + curHeight);
            curLeft += curWidth;
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        showToast("ViewGroup onMeasure");
        Log.d(TAG, "ViewGroup onMeasure");

        int count = getChildCount();
        int maxWidth = 0;
        int childState = 0;

        for (int i = 0; i < count; i++) {
            final View child = getChildAt(i);
            measureChild(child, widthMeasureSpec, heightMeasureSpec);
            maxWidth += Math.max(maxWidth, child.getMeasuredWidth());
            childState = combineMeasuredStates(childState, child.getMeasuredState());
        }

        maxWidth = Math.max(maxWidth, getSuggestedMinimumWidth());
        setMeasuredDimension(resolveSizeAndState(maxWidth, widthMeasureSpec, childState),
                resolveSizeAndState(200, heightMeasureSpec,
                        childState << MEASURED_HEIGHT_STATE_SHIFT));
    }

    protected void showToast(String message) {
        String currentTimeString = DateFormat.getTimeInstance().format(new Date());
        String toastMessage = message + " " + currentTimeString;
        Toast toast = Toast.makeText(contextViewGroup, toastMessage, Toast.LENGTH_SHORT);
        toast.show();
    }
}
