package ro.capac.android.capac2018.ui.registration;

import com.androidnetworking.error.ANError;

import io.reactivex.functions.Consumer;
import ro.capac.android.capac2018.R;
import ro.capac.android.capac2018.data.DataManager;
import ro.capac.android.capac2018.data.db.model.User;
import ro.capac.android.capac2018.data.network.model.LoginRequest;
import ro.capac.android.capac2018.data.network.model.LoginResponse;
import ro.capac.android.capac2018.ui.base.BasePresenter;
import ro.capac.android.capac2018.utils.CommonUtils;
import ro.capac.android.capac2018.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class RegistrationPresenter<V extends RegistrationMvpView> extends BasePresenter<V>
        implements RegistrationMvpPresenter<V> {

    private static final String TAG = "RegistrationPresenter";

    @Inject
    public RegistrationPresenter(DataManager dataManager,
                          SchedulerProvider schedulerProvider,
                          CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onServerRegistrationClick(String userName, String email, String phoneNumber, String password) {

        //validations
        if (email == null || email.isEmpty()) {
            getMvpView().onError(R.string.empty_email);
            getMvpView().emailInvalid();
            return;
        }
        if (!CommonUtils.isEmailValid(email)) {
            getMvpView().onError(R.string.invalid_email);
            return;
        }
        if (password == null || password.isEmpty()) {
            getMvpView().onError(R.string.empty_password);
            return;
        }
        if (userName == null || userName.isEmpty()) {
            getMvpView().onError("Please provide a non empty user name");
            return;
        }
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            getMvpView().onError("Please provide a non empty phone number");
            return;
        }
        getMvpView().showLoading();

        User newUser = new User(userName,email,phoneNumber,password);

        //TODO: Save newUser in database replace code below with proper one ASAP
        getCompositeDisposable().add(getDataManager()
                .doServerLoginApiCall(new LoginRequest.ServerLoginRequest(email, password))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<LoginResponse>() {
                    @Override
                    public void accept(LoginResponse response) throws Exception {
                        getDataManager().updateUserInfo(
                                response.getAccessToken(),
                                response.getUserId(),
                                DataManager.LoggedInMode.LOGGED_IN_MODE_SERVER,
                                response.getUserName(),
                                response.getUserEmail(),
                                response.getGoogleProfilePicUrl());

                        if (!isViewAttached()) {
                            return;
                        }

                        getMvpView().hideLoading();
                        getMvpView().openMainActivity();

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                        if (!isViewAttached()) {
                            return;
                        }

                        getMvpView().hideLoading();

                        // handle the login error here
                        if (throwable instanceof ANError) {
                            ANError anError = (ANError) throwable;
                            handleApiError(anError);
                        }
                    }
                }));
    }
}
