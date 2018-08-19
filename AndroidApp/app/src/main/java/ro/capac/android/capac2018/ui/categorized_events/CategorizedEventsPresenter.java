package ro.capac.android.capac2018.ui.categorized_events;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import ro.capac.android.capac2018.data.DataManager;
import ro.capac.android.capac2018.ui.base.BasePresenter;
import ro.capac.android.capac2018.utils.rx.SchedulerProvider;

public class CategorizedEventsPresenter<V extends CategorizedEventsMvpView> extends BasePresenter<V>
        implements CategorizedEventsMvpPresenter<V> {

    private static final String TAG = "CategorizedEventsPresenter";

    @Inject
    public CategorizedEventsPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
