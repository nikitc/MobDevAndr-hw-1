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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        Log.d(TAG, "ActivityTwo onCreate");
        showToast("ActivityTwo onCreate");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "ActivityTwo onRestart");
        showToast("ActivityTwo onRestart");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "ActivityTwo onStart");
        showToast("ActivityTwo onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "ActivityTwo onResume");
        showToast("ActivityTwo onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "ActivityTwo onPause");
        showToast("ActivityTwo onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "ActivityTwo onStop");
        showToast("ActivityTwo onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "ActivityTwo onDestroy");
        showToast("ActivityTwo onDestroy");
    }

    protected void showToast(String message) {
        String currentTimeString = DateFormat.getTimeInstance().format(new Date());
        String toastMessage = message + " " + currentTimeString;
        Toast toast = Toast.makeText(ActivityTwo.this, toastMessage, Toast.LENGTH_SHORT);
        toast.show();
    }

}
