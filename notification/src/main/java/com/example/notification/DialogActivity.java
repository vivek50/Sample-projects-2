package com.example.notification;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DialogActivity extends AppCompatActivity {

    public static final String TAG_ALERT = "Alert";
    public static final String TAG_DATE = "Date";
    public static final String TAG_TIME = "Time";
    public static final String TAG_PROGRESS = "Progress";
    public static final String TAG_CUSTOM = "Custom";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        findViewById(R.id.btnAlert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDialog(TAG_ALERT);

            }
        });

        findViewById(R.id.btnDate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDialog(TAG_DATE);

            }
        });

        findViewById(R.id.btnTime).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDialog(TAG_TIME);

            }
        });

        findViewById(R.id.btnProgress).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDialog(TAG_PROGRESS);

            }
        });

        findViewById(R.id.btnCustom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDialog(TAG_CUSTOM);

            }
        });

    }

    private void showDialog(String tag) {

        DialogFragment fragment = new DialogFragment();
        fragment.show(getSupportFragmentManager(),tag);
    }
}
