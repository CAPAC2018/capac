package ro.capac.android.capac2018.ui.events;

import ro.capac.android.capac2018.di.PerActivity;
import ro.capac.android.capac2018.ui.base.MvpPresenter;

@PerActivity
public interface EventsMvpPresenter<V extends EventsMvpView> extends MvpPresenter<V> {
}
