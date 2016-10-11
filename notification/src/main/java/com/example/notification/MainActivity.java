package com.example.notification;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnHomeLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this,LoginActivity.class));
                Toast.makeText(MainActivity.this, "Welcome to Login Activity", Toast.LENGTH_LONG).show();
            }
        });

        findViewById(R.id.btnHomeRegister).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this,RegistrationActivity.class));
                Toast.makeText(MainActivity.this, "Welcome to Registration Activity", Toast.LENGTH_LONG).show();
            }
        });
    }
}
