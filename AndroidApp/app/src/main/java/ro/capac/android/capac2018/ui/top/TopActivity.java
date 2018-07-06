package ro.capac.android.capac2018.ui.top;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import javax.inject.Inject;

import butterknife.ButterKnife;
import ro.capac.android.capac2018.R;
import ro.capac.android.capac2018.ui.base.BaseActivity;
import ro.capac.android.capac2018.ui.login.LoginActivity;
import ro.capac.android.capac2018.ui.registration.RegistrationActivity;

import butterknife.OnClick;

public class TopActivity extends BaseActivity implements TopMvpView {

    @Inject
    TopMvpPresenter<TopMvpView> mPresenter;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, TopActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(TopActivity.this);
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {

    }

    @OnClick(R.id.btn_login)
    public void openLoginActivity(){
        Intent intent = LoginActivity.getStartIntent(TopActivity.this);
        startActivity(intent);
        finish();
    }

    @OnClick(R.id.btn_register)
    public void openRegistrationActivity(){
        Intent intent = RegistrationActivity.getStartIntent(TopActivity.this);
        startActivity(intent);
        finish();
    }
}
