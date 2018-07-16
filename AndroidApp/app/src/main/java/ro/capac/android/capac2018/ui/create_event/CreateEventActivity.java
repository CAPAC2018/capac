package ro.capac.android.capac2018.ui.create_event;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import ro.capac.android.capac2018.R;
import ro.capac.android.capac2018.ui.base.BaseActivity;
import ro.capac.android.capac2018.ui.main.MainActivity;


public class CreateEventActivity extends BaseActivity implements CreateEventMvpView {

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, CreateEventActivity.class);
        return intent;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);
        getActivityComponent().inject(this);
    }

    @Override
    protected void setUp() {

    }
}
