package ro.capac.android.capac2018.ui.profile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ro.capac.android.capac2018.R;
import ro.capac.android.capac2018.ui.base.BaseActivity;
import ro.capac.android.capac2018.ui.registration.RegistrationMvpView;

public class MyProfileActivity extends BaseActivity implements MyProfileMvpView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
    }

    @Override
    protected void setUp() {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
