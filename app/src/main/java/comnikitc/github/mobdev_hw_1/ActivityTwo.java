package comnikitc.github.mobdev_hw_1;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import android.text.format.Time;
import java.text.DateFormat;
import java.util.Date;

public class ActivityTwo extends AppCompatActivity {

    final String TAG = "lifecycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "ActivityTwo onCreate");
        showToast("ActivityTwo onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "ActivityTwo onRestart");
        showToast("ActivityTwo onRestart");
        super.onRestart();

    }

    @Override
    protected void onStart() {
        Log.d(TAG, "ActivityTwo onStart");
        showToast("ActivityTwo onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "ActivityTwo onResume");
        showToast("ActivityTwo onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "ActivityTwo onPause");
        showToast("ActivityTwo onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "ActivityTwo onStop");
        showToast("ActivityTwo onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "ActivityTwo onDestroy");
        showToast("ActivityTwo onDestroy");
        super.onDestroy();
    }

    protected void showToast(String message) {
        String currentTimeString = DateFormat.getTimeInstance().format(new Date());
        String toastMessage = message + " " + currentTimeString;
        Toast toast = Toast.makeText(ActivityTwo.this, toastMessage, Toast.LENGTH_SHORT);
        toast.show();
    }

}
