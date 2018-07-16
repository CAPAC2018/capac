package ro.capac.android.capac2018.ui.join_event;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import javax.inject.Inject;

import butterknife.ButterKnife;
import ro.capac.android.capac2018.R;
import ro.capac.android.capac2018.ui.base.BaseActivity;
import ro.capac.android.capac2018.ui.join_event.JoinEventMvpView;
import ro.capac.android.capac2018.ui.join_event.JoinEventMvpPresenter;


public class JoinEventActivity extends BaseActivity {


    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, JoinEventActivity.class);
        return intent;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_event);
        getActivityComponent().inject(this);

    }

    @Override
    protected void setUp() {

    }
}
