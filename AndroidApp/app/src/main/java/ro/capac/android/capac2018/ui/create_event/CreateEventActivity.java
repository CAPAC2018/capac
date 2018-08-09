package ro.capac.android.capac2018.ui.create_event;

import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.Calendar;

import butterknife.OnClick;
import ro.capac.android.capac2018.R;
import ro.capac.android.capac2018.ui.base.BaseActivity;
import ro.capac.android.capac2018.ui.dialog.DatePickerFragment;
import ro.capac.android.capac2018.ui.dialog.TimePickerFragment;


public class CreateEventActivity extends BaseActivity implements CreateEventMvpView {
    Button timePicker;
    Button datePicker;
    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, CreateEventActivity.class);
        return intent;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);
        getActivityComponent().inject(this);
        timePicker = findViewById(R.id.time_picker);
        datePicker = findViewById(R.id.date_picker);
        timePicker.setText("TIME: "+ Calendar.HOUR_OF_DAY + ":" +Calendar.MINUTE);
        datePicker.setText("DATE: " + Calendar.DAY_OF_MONTH + "." +Calendar.MONTH);
    }
    @OnClick(R.id.time_picker)
    public void showTimePicker(){
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.setShowsDialog(true);
        newFragment.show(getFragmentManager(),TimePickerFragment.TAG);
    }
    @OnClick(R.id.date_picker)
    public void showDatePicker(){
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.setShowsDialog(true);
        newFragment.show(getFragmentManager(), DatePickerFragment.TAG);
    }
    @Override
    protected void setUp() {

    }
    public void changeTime(int hour, int minute){
        timePicker.setText("TIME: "+ hour + ":" + minute);
    }

    public void changeDate(int day, int month){
        datePicker.setText("DATE: " + day + "." +month);
    }
}
