package ro.capac.android.capac2018.ui.main2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toolbar;

import com.mindorks.placeholderview.SwipePlaceHolderView;

import javax.inject.Inject;

import butterknife.BindView;
import ro.capac.android.capac2018.R;
import ro.capac.android.capac2018.ui.base.BaseActivity;
import ro.capac.android.capac2018.ui.custom.RoundedImageView;
import ro.capac.android.capac2018.ui.main.MainMvpPresenter;
import ro.capac.android.capac2018.ui.main.MainMvpView;

public class Main2Activity extends BaseActivity implements Main2MvpView{

    private TextView mTextMessage;
    @Inject
    MainMvpPresenter<MainMvpView> mPresenter;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.cards_container)
    SwipePlaceHolderView mCardsContainerView;

    private TextView mNameTextView;

    private TextView mEmailTextView;

    private RoundedImageView mProfileImageView;
    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, Main2Activity.class);
        return intent;
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_profile:
                    mTextMessage.setText(R.string.title_profile);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
                case R.id.navigation_categories_events:
                    mTextMessage.setText(R.string.title_categories_amp_events);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
    @Override
    protected void setUp() {

    }
}
