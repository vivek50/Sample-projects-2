package com.example.notification;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (getUserName().equals("admin") && getPassword().equals("admin")) {

                    Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this,AfterLoginActivity.class));
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
                finish();
            }
        });
    }

    private String getUserName() {

        return ((EditText)findViewById(R.id.edtUserName1)).getText().toString();
    }

    private String getPassword() {

        return ((EditText)findViewById(R.id.edtPassword1)).getText().toString();
    }
}
