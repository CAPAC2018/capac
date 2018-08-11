package ro.capac.android.capac2018.ui.settings;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.annotation.Nullable;
import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import ro.capac.android.capac2018.R;
import ro.capac.android.capac2018.di.component.ActivityComponent;
import ro.capac.android.capac2018.ui.base.BaseFragment;
import ro.capac.android.capac2018.ui.profile.MyProfileFragment;
import ro.capac.android.capac2018.ui.profile.MyProfileMvpPresenter;
import ro.capac.android.capac2018.ui.profile.MyProfileMvpView;


public class SettingsFragment extends BaseFragment implements SettingsMvpView {
    public static final String TAG = "SettingsFragment";
    @Inject
    SettingsMvpPresenter<SettingsMvpView> mPresenter;

    public static SettingsFragment newInstance() {

        Bundle args = new Bundle();
        SettingsFragment fragment = new SettingsFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(SettingsFragment.this);
            setUnBinder(ButterKnife.bind(this, view));
            mPresenter.onAttach(this);
        }
        return view;

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