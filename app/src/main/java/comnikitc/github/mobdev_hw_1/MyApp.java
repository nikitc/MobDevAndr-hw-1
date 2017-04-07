package comnikitc.github.mobdev_hw_1;


import android.app.Application;
import android.content.res.Configuration;
import android.util.Log;

public class MyApp extends Application {

    final String TAG = "lifecycle";

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "Application create");

    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Log.d(TAG, "Application memory");
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        Log.d(TAG, "Application onTerminate");
    }
}