package ro.capac.android.capac2018.ui.top;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ro.capac.android.capac2018.R;
import ro.capac.android.capac2018.ui.login.LoginActivity;
import ro.capac.android.capac2018.ui.registration.RegistrationActivity;
import ro.capac.android.capac2018.ui.splash.SplashActivity;

import butterknife.OnClick;

public class TopActivity extends AppCompatActivity {

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, SplashActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);

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
