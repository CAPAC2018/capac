package ro.capac.android.capac2018.ui.profile;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import ro.capac.android.capac2018.data.DataManager;
import ro.capac.android.capac2018.ui.base.BasePresenter;
import ro.capac.android.capac2018.utils.rx.SchedulerProvider;

/**
 * Created by Paul on 16-Jul-18 at 7:08 PM.
 */
public class MyProfilePresenter<V extends MyProfileMvpView> extends BasePresenter<V>
        implements MyProfileMvpPresenter<V> {

    private static final String TAG = "MyProfilePresenter";

    @Inject
    public MyProfilePresenter(DataManager dataManager,
                                 SchedulerProvider schedulerProvider,
                                 CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

}
