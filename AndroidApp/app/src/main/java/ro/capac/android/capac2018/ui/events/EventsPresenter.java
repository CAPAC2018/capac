package ro.capac.android.capac2018.ui.events;

import io.reactivex.disposables.CompositeDisposable;
import ro.capac.android.capac2018.data.DataManager;
import ro.capac.android.capac2018.ui.base.BasePresenter;
import ro.capac.android.capac2018.utils.rx.SchedulerProvider;

public class EventsPresenter<V extends EventsMvpView> extends BasePresenter<V>
        implements EventsMvpPresenter<V> {
    public EventsPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
