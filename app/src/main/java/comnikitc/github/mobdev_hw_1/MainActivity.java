package comnikitc.github.mobdev_hw_1;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final String TAG = "lifecycle";
    final int COUNT_TAGS = 3;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

        Log.d(TAG, "MainActivity create");

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
        super.onRestart();
        Log.d(TAG, "MainActivity onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "MainActivity start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "MainActivity is resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "MainActivity paused");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "MainActivity stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "MainActivity destroy");
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, ActivityTwo.class);
        startActivity(intent);
    }
}
