package ro.capac.android.capac2018.ui.create_event;

import ro.capac.android.capac2018.di.PerActivity;
import ro.capac.android.capac2018.ui.base.MvpPresenter;

@PerActivity
public interface CreateEventMvpPresenter<V extends CreateEventMvpView> extends MvpPresenter<V> {
    void onCreateEventClick(
            String time,
            String date,
            String location,
            String sportType,
            String description,
            String noReqPlayers,
            String reqStars);
}
