package com.example.simpletextchip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CustomTextView textView1 = (CustomTextView) findViewById(R.id.txt_chip1);
        final CustomTextView textView2 = (CustomTextView) findViewById(R.id.txt_chip2);
        final CustomTextView textView3 = (CustomTextView) findViewById(R.id.txt_chip3);

        textView1.setDrawableClickListener(new DrawableClickListener() {

            public void onClick(DrawablePosition target) {
                if (target == DrawablePosition.RIGHT) {
                    textView1.setVisibility(View.GONE);
                    Toast.makeText(MainActivity.this, textView1.getText().toString() +
                            "  Canceled", Toast.LENGTH_SHORT).show();
                }
            }
        });

        textView2.setDrawableClickListener(new DrawableClickListener() {
            @Override
            public void onClick(DrawablePosition target) {
                if (target == DrawablePosition.RIGHT) {
                    textView2.setVisibility(View.GONE);
                    Toast.makeText(MainActivity.this, textView2.getText().toString() +
                            "  Canceled", Toast.LENGTH_SHORT).show();
                }
            }
        });

        textView3.setDrawableClickListener(new DrawableClickListener() {
            @Override
            public void onClick(DrawablePosition target) {
                if (target == DrawablePosition.RIGHT) {
                    textView3.setVisibility(View.GONE);
                    Toast.makeText(MainActivity.this, textView3.getText().toString() +
                            "  Canceled", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}
