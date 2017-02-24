package com.example.focuslistener;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText FirstName,LastName,Email,Password,Contact;
    boolean isContactVisited, isPasswordVisited, isEmailVisited, isLastNameVisited, isFirstNameVisited;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtFirstNameError();
        edtLastNameError();
        edtEmailError();
        edtPasswordError();
        edtContactError();

    }

    private void edtFirstNameError() {

        FirstName = (EditText) findViewById(R.id.edt_first_name);
        FirstName.setOnFocusChangeListener(this::firstNamePercentage);
    }

    private void firstNamePercentage(View edtFirstName, boolean hasFocus) {

        if(!hasFocus){
            if(((EditText)edtFirstName).getText().toString().length() == 0 ) {
                ((EditText) edtFirstName).setError("Enter First Name");
                if(isFirstNameVisited){
                    Log.i("@codekul","Percentage is - "+getPercentage());
                    setPercentage(-20);
                    isFirstNameVisited = false;
                }
            }
            else {
                if(!isFirstNameVisited) {
                    setPercentage(20);
                    isFirstNameVisited = true;
                }
            }
        }

    }

    private void edtLastNameError() {

        LastName = (EditText) findViewById(R.id.edt_last_name);
        LastName.setOnFocusChangeListener(this::lastNamePercentage);

    }

    private void lastNamePercentage(View edtLastName, boolean hasFocus) {

        if(!hasFocus){
            if(((EditText)edtLastName).getText().toString().length() == 0 ) {
                ((EditText) edtLastName).setError("Enter Last Name");
                if(isLastNameVisited){
                    Log.i("@codekul","Percentage is - "+getPercentage());
                    setPercentage(-20);
                    isLastNameVisited = false;
                }
            }
            else {
                if(!isLastNameVisited) {
                    setPercentage(20);
                    isLastNameVisited = true;
                }
            }
        }
    }


    private void contactPercentage(View edtContact, boolean hasFocus){
        if(!hasFocus){
            if(((EditText)edtContact).getText().toString().length() == 0 ) {
                ((EditText) edtContact).setError("Enter Contact Number");
                if(isContactVisited){
                    Log.i("@codekul","Percentage is - "+getPercentage());
                    setPercentage(-20);
                    isContactVisited = false;
                }
            }
            else {
                if(!isContactVisited) {
                    setPercentage(20);
                    isContactVisited = true;
                }
            }
        }
    }
    private void edtContactError() {
        Contact = (EditText) findViewById(R.id.edt_contact_number);
        Contact.setOnFocusChangeListener(this::contactPercentage);
    }

    private void passwordPercentage(View edtPassword, boolean hasFocus){
        if(!hasFocus){
            if(((EditText)edtPassword).getText().toString().length() == 0) {
                ((EditText) edtPassword).setError("Enter Password");
                if(isPasswordVisited) {
                    setPercentage(-20);
                    isPasswordVisited = false;
                }
            }
            else {
                if(!isPasswordVisited) {
                    setPercentage(20);
                    isPasswordVisited = true;
                    Log.i("@Vivek", String.valueOf(isPasswordVisited));
                }
            }
        }
    }
    private void edtPasswordError() {
       Password = (EditText) findViewById(R.id.edt_password);
       Password.setOnFocusChangeListener(this::passwordPercentage);
    }


    private void emailPercentage(View edtEmail, boolean hasFocus){

        if(!hasFocus){
            if(((EditText)edtEmail).getText().toString().length() == 0 ) {
                ((EditText) edtEmail).setError("Enter Email-Id");
                if(isEmailVisited){
                    Log.i("@codekul","Percentage is - "+getPercentage());
                    setPercentage(-20);
                    isEmailVisited = false;
                }
            }
            else {
                if(!isEmailVisited) {
                    setPercentage(20);
                    isEmailVisited = true;
                }
            }
        }
    }

    private void edtEmailError() {

        Email = (EditText) findViewById(R.id.edt_email_id);
        Email.setOnFocusChangeListener(this::emailPercentage);

    }

    private void setPercentage(int val){
        Log.i("@codekul","Val is "+val);
        ((TextView)findViewById(R.id.textProfileComplete)).setText(""+( (getPercentage() + val) <= 0 ? 0 : (getPercentage() + val)));
    }

    private int getPercentage(){
        int per = 0;
        try {
            per = Integer.parseInt(((TextView)findViewById(R.id.textProfileComplete)).getText().toString());
        }
        catch (Exception e){
            e.printStackTrace();
            per = 0;
        }
        return per;
    }

}