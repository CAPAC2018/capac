package ro.capac.android.capac2018.ui.categorized_events;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import ro.capac.android.capac2018.data.DataManager;
import ro.capac.android.capac2018.data.network.model.EventRequest;
import ro.capac.android.capac2018.data.network.model.EventResponse;
import ro.capac.android.capac2018.data.network.model.LoginResponse;
import ro.capac.android.capac2018.ui.base.BasePresenter;
import ro.capac.android.capac2018.utils.rx.SchedulerProvider;

public class CategorizedEventsPresenter<V extends CategorizedEventsMvpView> extends BasePresenter<V>
        implements CategorizedEventsMvpPresenter<V> {

    private static final String TAG = "CategorizedEventsPresenter";

    @Inject
    public CategorizedEventsPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    public void showEventsList(String category) {
        getMvpView().showLoading();
        EventRequest.GetEventsByCategoryRequest request = new EventRequest.GetEventsByCategoryRequest(category);
        getDataManager().doRequestEventsByCategory(request).subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<EventResponse.CategorizedEvents>() {
                    @Override
                    public void accept(EventResponse.CategorizedEvents response) {
                        List<EventResponse.Event> events = response.getEvents();
                        getMvpView().refreshList(events);
                        getMvpView().hideLoading();
                    }
                });
    }
}
