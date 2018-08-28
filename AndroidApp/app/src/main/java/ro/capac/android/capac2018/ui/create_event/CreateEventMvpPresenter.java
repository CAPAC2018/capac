package ro.capac.android.capac2018.ui.create_event;

import ro.capac.android.capac2018.di.PerActivity;
import ro.capac.android.capac2018.ui.base.MvpPresenter;

@PerActivity
public interface CreateEventMvpPresenter<V extends CreateEventMvpView> extends MvpPresenter<V> {
    public void onCreateEventClick();
}
