package ro.capac.android.capac2018.ui.create_event;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import ro.capac.android.capac2018.data.DataManager;
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

}
