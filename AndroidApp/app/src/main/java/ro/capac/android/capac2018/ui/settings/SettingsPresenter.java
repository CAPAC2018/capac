package ro.capac.android.capac2018.ui.settings;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import ro.capac.android.capac2018.data.DataManager;
import ro.capac.android.capac2018.ui.base.BasePresenter;
import ro.capac.android.capac2018.utils.rx.SchedulerProvider;

public class SettingsPresenter <V extends SettingsMvpView> extends BasePresenter<V>
        implements SettingsMvpPresenter<V> {

    @Inject
    public SettingsPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
