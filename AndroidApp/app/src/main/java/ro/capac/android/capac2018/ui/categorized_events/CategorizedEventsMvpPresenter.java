package ro.capac.android.capac2018.ui.categorized_events;

import android.view.View;

import ro.capac.android.capac2018.di.PerActivity;
import ro.capac.android.capac2018.ui.base.MvpPresenter;

@PerActivity
public interface CategorizedEventsMvpPresenter<V extends CategorizedEventsMvpView> extends MvpPresenter<V> {
    void showEventsList(String category);
    void onAttendEventClick(Long eventId, int cellPosition, View view);
}
