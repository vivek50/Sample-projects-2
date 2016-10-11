package com.example.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class AfterLoginActivity extends AppCompatActivity {

    private static final int REQ_SIMPLE = 1234;
    private static final int NOTIFICATION_SIMPLE = 5678;
    String[] Nontilist;

    int[] Notiimages = {R.drawable.toast, R.drawable.statusbar, R.drawable.dialog};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);

        Resources resources = getResources();
        Nontilist = resources.getStringArray(R.array.Notifiaction);
        ListView listView = (ListView) findViewById(R.id.notificationlist);

        MyAdapter adapter = new MyAdapter(this, Nontilist, Notiimages);
        listView.setAdapter(adapter);

        findViewById(R.id.btnLogout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });
    }

    class MyAdapter extends ArrayAdapter {

        String[] titles;
        Context context;
        int images[];


        public MyAdapter(Context context, String[] titles, int images[]) {

            super(context, R.layout.notifiaction_list, R.id.notificationtext);
            this.context = context;
            this.images = images;
            this.titles = titles;
        }
        ImageView imageView;
        TextView textView;
        LinearLayout linearLayout;

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

         //   LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

            if(convertView==null)
            {
                convertView=LayoutInflater.from(context).inflate(R.layout.notifiaction_list, parent, false);

                imageView = (ImageView) convertView.findViewById(R.id.notifiactionimage);

                textView  = (TextView) convertView.findViewById(R.id.notificationtext);

                linearLayout  = (LinearLayout) convertView.findViewById(R.id.notificationLayout);

            }

            imageView.setImageResource(images[position]);
            textView.setText(titles[position]);
            linearLayout.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    if (position == 0) {

                        Toast.makeText(getContext(), "This is a Toast Notification", Toast.LENGTH_LONG).show();

                    } else if (position == 1) {

                        Toast.makeText(getContext(), "This is a Status Bar Notification", Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(AfterLoginActivity.this, StatusBarActivity.class);

                        PendingIntent pendingIntent = PendingIntent.getActivity(AfterLoginActivity.this,REQ_SIMPLE,intent,
                                PendingIntent.FLAG_ONE_SHOT);

                        NotificationManager manager =
                                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                        NotificationCompat.Builder builder =   new NotificationCompat.Builder(AfterLoginActivity.this);
                        builder.setSmallIcon(R.drawable.toast);
                        builder.setContentTitle(getResources().getString(R.string.TitleStatusBar));
                        builder.setContentText(getResources().getString(R.string.MesgStatusBar));
//                        builder.setAutoCancel(true);
                        builder.setContentIntent(pendingIntent);
                        builder.setDefaults(NotificationCompat.DEFAULT_ALL);
//                        builder.addAction(R.mipmap.ic_launcher,"Yes",pendingIntent);
//                        builder.addAction(R.mipmap.ic_launcher,"No",pendingIntent);

                        Notification notification = builder.build();
                        notification.flags = Notification.FLAG_AUTO_CANCEL;

                        manager.notify(NOTIFICATION_SIMPLE,notification);

                    } else {

                        Toast.makeText(getContext(), "Dialog Fragment Continue...", Toast.LENGTH_LONG).show();

                        startActivity(new Intent(AfterLoginActivity.this,DialogActivity.class));

                    }

                }
            });

            return convertView;
        }



    }
}



