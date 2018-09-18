package ro.capac.android.capac2018.ui.news;

import android.view.View;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import ro.capac.android.capac2018.data.DataManager;
import ro.capac.android.capac2018.data.network.model.EventRequest;
import ro.capac.android.capac2018.data.network.model.EventResponse;
import ro.capac.android.capac2018.ui.base.BasePresenter;
import ro.capac.android.capac2018.utils.rx.SchedulerProvider;

/**
 * Created by Paul on 18-Sep-18 at 17:27.
 */
public class NewsPresenter<V extends NewsMvpView> extends BasePresenter<V>
        implements NewsMvpPresenter<V> {
    @Inject
    public NewsPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
    public void showMyEventsList() {
        getMvpView().showLoading();
        EventRequest.MyEventsRequest request = new EventRequest.MyEventsRequest();
        request.setUserId(getDataManager().getCurrentUserId());
        getDataManager().doGetMyEvents(request).subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<EventResponse.EventsList>() {
                    @Override
                    public void accept(EventResponse.EventsList response) {
                        List<EventResponse.Event> events = response.getEvents();
                        getMvpView().refreshList(events);
                        getMvpView().hideLoading();
                    }
                });
    }

    @Override
    public void onAttendEventClick(Long eventId, final int cellPosition, final View view) {
        getMvpView().showLoading();
        EventRequest.AttendEventRequest request = new EventRequest.AttendEventRequest(eventId, getDataManager().getCurrentUserId());
        getDataManager().doAttendEventRequest(request).subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<EventResponse.AttendEventResponse>() {
                    @Override
                    public void accept(EventResponse.AttendEventResponse response) {
                        getMvpView().showMessage(response.getMessage());
                        if(response.getStatusCode().equals("success"))
                            getMvpView().addAttendee(cellPosition,response.getAttendees(),view);
                        else if(response.getStatusCode().equals("good_error"))
                            getMvpView().alreadyGoing(view);
                        getMvpView().hideLoading();
                    }
                });
    }
}
