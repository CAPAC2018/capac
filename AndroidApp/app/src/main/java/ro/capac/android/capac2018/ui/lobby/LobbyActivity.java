package ro.capac.android.capac2018.ui.lobby;

import android.os.Bundle;

import ro.capac.android.capac2018.R;
import ro.capac.android.capac2018.ui.base.BaseActivity;

public class LobbyActivity extends BaseActivity implements LobbyMvpView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);
    }

    @Override
    protected void setUp() {

    }
}
