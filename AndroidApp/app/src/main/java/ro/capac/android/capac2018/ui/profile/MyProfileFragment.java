package ro.capac.android.capac2018.ui.profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.ButterKnife;
import ro.capac.android.capac2018.R;
import ro.capac.android.capac2018.di.component.ActivityComponent;
import ro.capac.android.capac2018.ui.base.BaseFragment;

public class MyProfileFragment extends BaseFragment implements MyProfileMvpView{
    public static final String TAG = "MyProfileFragment";

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
