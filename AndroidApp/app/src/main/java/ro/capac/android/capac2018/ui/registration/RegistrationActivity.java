package ro.capac.android.capac2018.ui.registration;

import android.content.Context;
import android.content.Intent;
import android.net.sip.SipSession;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import ro.capac.android.capac2018.R;
import ro.capac.android.capac2018.data.AppDataManager;
import ro.capac.android.capac2018.ui.base.BaseActivity;
import ro.capac.android.capac2018.ui.login.LoginActivity;
import ro.capac.android.capac2018.ui.login.LoginMvpPresenter;
import ro.capac.android.capac2018.ui.login.LoginMvpView;
import ro.capac.android.capac2018.ui.main.MainActivity;
import ro.capac.android.capac2018.utils.CommonUtils;

public class RegistrationActivity extends BaseActivity implements RegistrationMvpView {
    @Inject
    RegistrationMvpPresenter<RegistrationMvpView> mPresenter;
    //Declare Variables4
    AutoCompleteTextView userName;
    AutoCompleteTextView userEmail;
    AutoCompleteTextView phoneNumber;
    AutoCompleteTextView userPassword;
    AutoCompleteTextView userPasswordConfirmation;
    Button registrationButton;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, RegistrationActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        //Initialize variables
        userName = findViewById(R.id.registration_user_name);
        userEmail = findViewById(R.id.registration_user_email);
        phoneNumber = findViewById(R.id.registration_user_phone_number);
        userPassword = findViewById(R.id.registration_user_password);
        userPasswordConfirmation = findViewById(R.id.registration_user_password_confirmation);
        registrationButton = findViewById(R.id.registration_button);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));
        mPresenter.onAttach(RegistrationActivity.this);

        registrationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               mPresenter.onServerRegistrationClick(userEmail.getText().toString(), userPassword.getText().toString());
            }
        });
    }

    @Override
    public void openMainActivity() {
        Intent intent = MainActivity.getStartIntent(RegistrationActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public void emailInvalid() {
        userEmail.setActivated(true);
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
