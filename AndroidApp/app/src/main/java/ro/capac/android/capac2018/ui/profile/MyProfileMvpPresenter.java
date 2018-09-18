package ro.capac.android.capac2018.ui.profile;

import ro.capac.android.capac2018.ui.base.MvpPresenter;

public interface MyProfileMvpPresenter <V extends MyProfileMvpView> extends MvpPresenter<V> {
    String getName();
    void onLogOutClick();
}
