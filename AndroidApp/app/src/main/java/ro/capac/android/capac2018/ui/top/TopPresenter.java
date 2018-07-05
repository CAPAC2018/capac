package ro.capac.android.capac2018.ui.top;

import ro.capac.android.capac2018.data.DataManager;
import ro.capac.android.capac2018.ui.base.BasePresenter;
import ro.capac.android.capac2018.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class TopPresenter <V extends TopMvpView> extends BasePresenter<V>
        implements TopMvpPresenter<V> {

    private static final String TAG = "TopPresenter";

    @Inject
    public TopPresenter(DataManager dataManager,
                           SchedulerProvider schedulerProvider,
                           CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

}
