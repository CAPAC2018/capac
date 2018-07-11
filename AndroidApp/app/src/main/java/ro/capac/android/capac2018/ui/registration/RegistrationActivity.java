package ro.capac.android.capac2018.ui.registration;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import ro.capac.android.capac2018.R;
import ro.capac.android.capac2018.ui.base.BaseActivity;
import ro.capac.android.capac2018.ui.login.LoginActivity;
import ro.capac.android.capac2018.ui.login.LoginMvpPresenter;
import ro.capac.android.capac2018.ui.login.LoginMvpView;
import ro.capac.android.capac2018.ui.main.MainActivity;

public class RegistrationActivity extends BaseActivity implements RegistrationMvpView {
    @Inject
    RegistrationMvpPresenter<RegistrationMvpView> mPresenter;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, RegistrationActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }

    @Override
    public void openMainActivity() {
        Intent intent = MainActivity.getStartIntent(RegistrationActivity.this);
        startActivity(intent);
        finish();
    }
    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {

    }
}
