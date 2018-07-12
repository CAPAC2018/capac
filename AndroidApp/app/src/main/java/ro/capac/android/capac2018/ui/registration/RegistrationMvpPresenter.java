package ro.capac.android.capac2018.ui.registration;

import ro.capac.android.capac2018.ui.base.MvpPresenter;

public interface RegistrationMvpPresenter<V extends RegistrationMvpView> extends MvpPresenter<V> {
    void onServerRegistrationClick(String email, String password);
}
