package ro.capac.android.capac2018.ui.registration;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import ro.capac.android.capac2018.R;
import ro.capac.android.capac2018.ui.base.BaseActivity;
import ro.capac.android.capac2018.ui.main.MainActivity;

public class RegistrationActivity extends BaseActivity implements RegistrationMvpView {
    @Inject
    RegistrationMvpPresenter<RegistrationMvpView> mPresenter;
    //declare Variables
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
        //initialize variables
        userName = findViewById(R.id.registration_user_name);
        userEmail = findViewById(R.id.registration_user_email);
        phoneNumber = findViewById(R.id.registration_user_phone_number);
        userPassword = findViewById(R.id.registration_user_password);
        userPasswordConfirmation = findViewById(R.id.registration_user_password_confirmation);
        registrationButton = findViewById(R.id.registration_button);

        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mPresenter.onAttach(RegistrationActivity.this);
    }

    @OnClick(R.id.registration_button)
    void onServerRegistrationClick(){
        mPresenter.onServerRegistrationClick(userName.getText().toString(), userEmail.getText().toString(), phoneNumber.getText().toString(), userPassword.getText().toString(),userPasswordConfirmation.getText().toString());
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
