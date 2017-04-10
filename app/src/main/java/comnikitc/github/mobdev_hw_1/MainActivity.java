package comnikitc.github.mobdev_hw_1;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final String TAG = "lifecycle";
    final int COUNT_TAGS = 3;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        showToast("MainActivity onCreate");
        Log.d(TAG, "MainActivity onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);



        MyView myView = (MyView) findViewById(R.id.myView);
        TagLayout tagLayout = (TagLayout) findViewById(R.id.tagLayout);
        LayoutInflater layoutInflater = getLayoutInflater();
        String tag;

        for (int i = 0; i <= COUNT_TAGS; i++) {
            tag = "tag" + i;
            View tagView = layoutInflater.inflate(R.layout.tag_layout, null, false);

            TextView tagTextView = (TextView) tagView.findViewById(R.id.tagTextView);
            tagTextView.setText(tag);
            tagLayout.addView(tagView);
        }

    }

    @Override
    protected void onRestart() {
        showToast("MainActivity onRestart");
        Log.d(TAG, "MainActivity onRestart");
        super.onRestart();
    }

    @Override
    protected void onStart() {
        super.onStart();
        showToast("MainActivity onStart");
        Log.d(TAG, "MainActivity onStart");
    }

    @Override
    protected void onResume() {
        showToast("MainActivity onResume");
        Log.d(TAG, "MainActivity onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        showToast("MainActivity onPause");
        Log.d(TAG, "MainActivity onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        showToast("MainActivity onStop");
        Log.d(TAG, "MainActivity onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        showToast("MainActivity onDestroy");
        Log.d(TAG, "MainActivity onDestroy");
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, ActivityTwo.class);
        startActivity(intent);
    }

    protected void showToast(String message) {
        String currentTimeString = DateFormat.getTimeInstance().format(new Date());
        String toastMessage = message + " " + currentTimeString;
        Toast toast = Toast.makeText(MainActivity.this, toastMessage, Toast.LENGTH_SHORT);
        toast.show();
    }
}
