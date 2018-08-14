package ro.capac.android.capac2018.ui.dialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;

import ro.capac.android.capac2018.ui.create_event.CreateEventActivity;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    public final static String TAG = "DatePicker";
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        CreateEventActivity myActivity = (CreateEventActivity) getActivity();
        Calendar c = Calendar.getInstance();
        c.set(year,month,day);
        Date date = c.getTime();
        myActivity.changeDate(date);
    }

}
