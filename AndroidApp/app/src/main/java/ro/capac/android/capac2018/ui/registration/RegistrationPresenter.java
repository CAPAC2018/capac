package ro.capac.android.capac2018.ui.registration;

import com.androidnetworking.error.ANError;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import ro.capac.android.capac2018.R;
import ro.capac.android.capac2018.data.DataManager;
import ro.capac.android.capac2018.data.network.model.AuthenticationRequest;
import ro.capac.android.capac2018.data.network.model.AuthenticationResponse;
import ro.capac.android.capac2018.ui.base.BasePresenter;
import ro.capac.android.capac2018.utils.CommonUtils;
import ro.capac.android.capac2018.utils.rx.SchedulerProvider;

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
    public void onServerRegistrationClick(String userName, String email, String phoneNumber, String password, String confirmPass) {

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
        if(!confirmPass.equals(password)){
            getMvpView().onError("Passwords don't match");
            return;
        }
        getMvpView().showLoading();

        AuthenticationRequest.RegistrationRequest.ServerRegistrationRequest request = new AuthenticationRequest.RegistrationRequest.ServerRegistrationRequest(userName,email,phoneNumber,password);

        getCompositeDisposable().add(getDataManager()
                .doServerUserRegistration(request)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<AuthenticationResponse.RegistrationResponse>() {
                    @Override
                    public void accept(AuthenticationResponse.RegistrationResponse response) {
                        if(response.getStatusCode().equals("success")) {
                            getDataManager().updateUserInfo(
                                    null,
                                    response.getUserId(),
                                    DataManager.LoggedInMode.LOGGED_IN_MODE_SERVER,
                                    response.getUserName(),
                                    response.getUserEmail(),
                                    null);
                        } else {
                            getMvpView().onError(response.getMessage());
                            getMvpView().hideLoading();
                            return;
                        }

                        if (!isViewAttached()) {
                            return;
                        }

                        getMvpView().hideLoading();
                        getMvpView().openMainActivity();

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {

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
