package comnikitc.github.mobdev_hw_1;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

public class TagLayout extends ViewGroup {
    int deviceWidth;
    final String TAG = "lifecycle";

    public TagLayout(Context context) {
        this(context, null, 0);
    }

    public TagLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TagLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
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
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
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
        Log.d(TAG, "ViewGroup measured");

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
}
