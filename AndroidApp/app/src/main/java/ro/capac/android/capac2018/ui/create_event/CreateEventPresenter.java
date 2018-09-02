package ro.capac.android.capac2018.ui.create_event;

import android.annotation.SuppressLint;

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
        Event event = new Event(time,date,location,sportType,description,noReqPlayers,reqStars);
        getDataManager().doCreateEventApiCall(new EventRequest.CreateEventRequest(event)).subscribeOn(getSchedulerProvider().io())
        .observeOn(getSchedulerProvider().ui())
        .subscribe(new Consumer<EventResponse.CreateEventResponse>() {
            @Override
            public void accept(EventResponse.CreateEventResponse createEventResponse) {
                getMvpView().showMessage(createEventResponse.getMessage());
            }
        });
    }

}
