package ro.capac.android.capac2018.ui.lobby;

import io.reactivex.disposables.CompositeDisposable;
import ro.capac.android.capac2018.data.DataManager;
import ro.capac.android.capac2018.ui.base.BasePresenter;
import ro.capac.android.capac2018.ui.base.MvpView;
import ro.capac.android.capac2018.utils.rx.SchedulerProvider;

public class LobbyPresenter <V extends LobbyMvpView> extends BasePresenter<V>
    implements LobbyMvpPresenter<V> {

    public LobbyPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
