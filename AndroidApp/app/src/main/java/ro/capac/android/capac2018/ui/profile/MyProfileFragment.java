package ro.capac.android.capac2018.ui.profile;

import android.accounts.AccountAuthenticatorActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import ro.capac.android.capac2018.R;
import ro.capac.android.capac2018.di.component.ActivityComponent;
import ro.capac.android.capac2018.ui.base.BaseFragment;
import ro.capac.android.capac2018.ui.main.MainActivity;
import ro.capac.android.capac2018.ui.settings.SettingsFragment;
import ro.capac.android.capac2018.ui.top.TopActivity;

public class MyProfileFragment extends BaseFragment implements MyProfileMvpView{
    public static final String TAG = "MyProfileFragment";
    TextView myName;
    @Inject
    MyProfileMvpPresenter<MyProfileMvpView> mPresenter;

    public static MyProfileFragment newInstance() {
        Bundle args = new Bundle();
        MyProfileFragment fragment = new MyProfileFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_profile, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(MyProfileFragment.this);
            setUnBinder(ButterKnife.bind(this, view));
            mPresenter.onAttach(this);
        }
        myName = view.findViewById(R.id.user_first_and_last_name);
        myName.setText(mPresenter.getName());
        return view;
    }

    @OnClick(R.id.settings_in_card_view)
    public void showSettingsFragment() {
        getFragmentManager()
                .beginTransaction()
                .disallowAddToBackStack()
                .replace(R.id.frame, SettingsFragment.newInstance(), SettingsFragment.TAG)
                .commit();
    }
    @Override
    public void openTopActivity() {
        startActivity(TopActivity.getStartIntent(this.getContext()));
        getActivity().finish();
    }
    @Override
    @OnClick(R.id.logout_in_card_view)
    public void logOut(){
        mPresenter.onLogOutClick();
    }
    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }
    @Override
    protected void setUp(View view) {

    }
}
