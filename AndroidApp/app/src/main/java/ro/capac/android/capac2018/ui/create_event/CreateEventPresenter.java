package ro.capac.android.capac2018.ui.create_event;

import android.annotation.SuppressLint;
import android.util.Log;

import com.androidnetworking.error.ANError;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import ro.capac.android.capac2018.data.DataManager;
import ro.capac.android.capac2018.data.db.model.Event;
import ro.capac.android.capac2018.data.network.model.EventRequest;
import ro.capac.android.capac2018.data.network.model.EventResponse;
import ro.capac.android.capac2018.ui.base.BasePresenter;
import ro.capac.android.capac2018.utils.rx.SchedulerProvider;

public class CreateEventPresenter <V extends CreateEventMvpView> extends BasePresenter<V>
        implements CreateEventMvpPresenter<V> {
    private static final String TAG = "CreateEventPresenter";

    @Inject
    public CreateEventPresenter(DataManager dataManager,
                                SchedulerProvider schedulerProvider,
                                CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @SuppressLint("CheckResult")
    public void onCreateEventClick(
            String time,
            String date,
            String location,
            String sportType,
            String description,
            String noReqPlayers,
            String reqStars
    ){
        Log.i(TAG, "onCreateEventClick: Click");
        Event event = new Event(time,date,location,sportType,description,noReqPlayers,reqStars);
        getDataManager().doCreateEventApiCall(new EventRequest.CreateEventRequest(event)).subscribeOn(getSchedulerProvider().io())
        .observeOn(getSchedulerProvider().ui())
        .subscribe(new Consumer<EventResponse.CreateEventResponse>() {
            @Override
            public void accept(EventResponse.CreateEventResponse createEventResponse) {
                Log.i(TAG, "12123214124 accept: create EVENT " + createEventResponse);
                getMvpView().showMessage(createEventResponse.getMessage());
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                Log.e(TAG, "Error occured while creating a new event" + throwable);
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
        });
    }

}
