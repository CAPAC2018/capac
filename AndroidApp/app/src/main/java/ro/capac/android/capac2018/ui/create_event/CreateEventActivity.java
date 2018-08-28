package ro.capac.android.capac2018.ui.create_event;

import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.Date;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import ro.capac.android.capac2018.R;
import ro.capac.android.capac2018.ui.MapsActivity;
import ro.capac.android.capac2018.ui.base.BaseActivity;
import ro.capac.android.capac2018.ui.dialog.DatePickerFragment;
import ro.capac.android.capac2018.ui.dialog.TimePickerFragment;
import ro.capac.android.capac2018.utils.CommonUtils;


public class CreateEventActivity extends BaseActivity implements CreateEventMvpView {
    Button timePicker;
    Button datePicker;
    Button create;
    @Inject
    CreateEventMvpPresenter<CreateEventMvpView> mPresenter;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, CreateEventActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mPresenter.onAttach(this);

        create = findViewById(R.id.create_btn);
        timePicker = findViewById(R.id.time_picker);
        datePicker = findViewById(R.id.date_picker);
        create.animate()
                .translationY(create.getHeight())
                .setDuration(750)
                .setListener(null);
        timePicker.setText("TIME: " + CommonUtils.getCurrentTime());
        datePicker.setText("DATE: " + CommonUtils.getCurrentDate());
    }

    @OnClick(R.id.time_picker)
    public void showTimePicker() {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.setShowsDialog(true);
        newFragment.show(getFragmentManager(), TimePickerFragment.TAG);
    }

    @OnClick(R.id.date_picker)
    public void showDatePicker() {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.setShowsDialog(true);
        newFragment.show(getFragmentManager(), DatePickerFragment.TAG);
    }

    @OnClick(R.id.location_picker)
    public void startMap() {
        startActivity(MapsActivity.getStartIntent(this));
    }

    @Override
    protected void setUp() {

    }

    @OnClick(R.id.create_event_btn)
    public void createEvent(){

        mPresenter.onCreateEventClick();
    }

    public void changeTime(Date date) {
        timePicker.setText("TIME: " + CommonUtils.formatTime(date));
    }
    public void changeDate(Date date){
        datePicker.setText("DATE: " + CommonUtils.formatDate(date));
    }
}