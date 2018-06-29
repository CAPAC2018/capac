package ro.capac.android.capac2018;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button SignInBtn = (Button) findViewById(R.id.SignInBtn);
        SignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent GoToSignIn = new Intent(getApplicationContext(),SignIn.class);
                    startActivity(GoToSignIn);
            }
        });

        Button RegisterBtn = (Button) findViewById(R.id.RegisterBtn);
        RegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent GoToRegistration = new Intent(getApplicationContext(),Registration.class);
                    startActivity(GoToRegistration);
            }
        });
    }
}
