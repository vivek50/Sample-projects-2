package com.example.notification;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class DialogFragment extends AppCompatDialogFragment {


    public DialogFragment() {
        // Required empty public constructor
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Dialog dialog = null;

        if(getTag().equals(DialogActivity.TAG_ALERT))dialog = Alert();
        else if (getTag().equals(DialogActivity.TAG_DATE))dialog = DatePicker();
        else if (getTag().equals(DialogActivity.TAG_TIME))dialog = TimePicker();
        else if (getTag().equals(DialogActivity.TAG_PROGRESS))dialog = Progress();
        else dialog = Custom();

        return dialog;
    }

    private Dialog Alert() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(getResources().getString(R.string.TitleAlert));
        builder.setMessage(getResources().getString(R.string.MesgAlert));
        builder.setIcon(R.drawable.alert_icon);

        builder.setPositiveButton(R.string.alertPositive, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Log.i("@modi","Alert");
            }
        });
        builder.setNegativeButton(R.string.alertNegative, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(getActivity(), "You Clicked Cancel", Toast.LENGTH_SHORT).show();
            }
        });

        return builder.create();
    }

    private Dialog DatePicker() {

        DatePickerDialog datepicker = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                StringBuilder builder = new StringBuilder();
                builder.append("").append(dayOfMonth)
                        .append("-").append(month)
                        .append("-").append(year);

                Toast.makeText(getActivity(), builder.toString(), Toast.LENGTH_SHORT).show();
            }
        },2016,9,30);

        return datepicker;
    }

    private Dialog TimePicker() {

        TimePickerDialog timepicker = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                StringBuilder builder = new StringBuilder();
                builder.append("").append(hourOfDay)
                        .append(":").append(minute);

                Toast.makeText(getActivity(), builder.toString(), Toast.LENGTH_SHORT).show();
            }
        },8,45,false);

        return timepicker;
    }

    private Dialog Progress() {

        ProgressDialog progress = new ProgressDialog(getActivity());
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.setTitle(getResources().getString(R.string.TitleProgress));
        progress.setMessage(getResources().getString(R.string.MesgProgress));
        progress.setIcon(R.drawable.progress_icon);

        return progress;
    }

    private Dialog Custom() {

        View dialogview = getActivity().getLayoutInflater().inflate(R.layout.custom_dialog,null,false);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity()).setView(dialogview);

        return builder.show();

    }

}
