package com.example.contactlist;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int PERMISSION_CONTACT = 1688;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openPermissionDialog();
    }

    private void openPermissionDialog() {

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_CONTACTS)) {

                AlertDialog.Builder builder = new AlertDialog.Builder(this)
                        .setMessage("We need contact permission to proceed")
                        .setPositiveButton("Okay", (dialog, which) ->
                                ActivityCompat.requestPermissions(this,
                                new String[]{Manifest.permission.READ_CONTACTS},
                                PERMISSION_CONTACT))
                        .setNegativeButton("No", (dialog,which)-> dialog.dismiss());

                builder.show();
            }
        }
        else {
            fetchContacts();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == PERMISSION_CONTACT){
            if(permissions.length > 0){
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    fetchContacts();
                } else {
                    openPermissionDialog();
                }
            }
        }
    }

    String displayName="", emailAddress="", phoneNumber="";
    ArrayList<String> contactlist=new ArrayList<String>();

    private void fetchContacts() {

//        ArrayList<String> contacts = new ArrayList<>();
//
//        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
//
//        String[] projection = {ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,ContactsContract.CommonDataKinds.Phone.NUMBER};
//        String selection = null;
//        String[] selectionArgs = null;
//        String sortOrder = null;
//
//        ContentResolver resolver = getContentResolver();
//        Cursor cursor = resolver.query(uri, projection, selection,selectionArgs, sortOrder);
//
//        while(cursor.moveToNext()) {
//            String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
//            String num = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
//
//            Log.i("@codekul", "Name - " + name + " Num - " + num);
//            contacts.add(name + "\n" + num);
//        }
        ContentResolver cr =getContentResolver();
        Cursor cursor = cr.query(ContactsContract.Contacts.CONTENT_URI,
                null, null, null, null);
        while (cursor.moveToNext())
        {
            displayName="";emailAddress=""; phoneNumber="";
            displayName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
            Cursor emails = cr.query(ContactsContract.CommonDataKinds.Email.CONTENT_URI,
                    null,
                    ContactsContract.CommonDataKinds.Email.CONTACT_ID + " = " + id,
                    null, null);
            while (emails.moveToNext())
            {
                emailAddress = emails.getString(emails.getColumnIndex(ContactsContract.CommonDataKinds.Email.DATA));
                break;
            }
            emails.close();
            if(Integer.parseInt(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0)
            {
                Cursor pCur = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                        null,
                        ContactsContract.CommonDataKinds.Phone.CONTACT_ID +" = ?",
                        new String[]{id}, null);
                while (pCur.moveToNext())
                {
                    phoneNumber = pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    break;
                }
                pCur.close();
            }
            contactlist.add("DisplayName: "+displayName+", PhoneNumber: "+phoneNumber+", EmailAddress: "+ emailAddress+"\n");
        }
        cursor.close();
        Log.d("@modi", "Contact List : " + contactlist);
    }
}
