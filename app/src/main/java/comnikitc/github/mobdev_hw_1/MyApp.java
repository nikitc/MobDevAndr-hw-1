package comnikitc.github.mobdev_hw_1;


import android.app.Application;
import android.content.res.Configuration;
import android.util.Log;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;

public class MyApp extends Application {

    final String TAG = "lifecycle";

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onCreate() {
        Log.d(TAG, "Application onCreate");
        showToast("Application onCreate");
        super.onCreate();

    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Log.d(TAG, "Application onLowMemory");
        showToast("Application onLowMemory");
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        Log.d(TAG, "Application onTerminate");
        showToast("Application onTerminate");
    }

    protected void showToast(String message) {
        String currentTimeString = DateFormat.getTimeInstance().format(new Date());
        String toastMessage = message + " " + currentTimeString;
        Toast toast = Toast.makeText(MyApp.this, toastMessage, Toast.LENGTH_SHORT);
        toast.show();
    }
}