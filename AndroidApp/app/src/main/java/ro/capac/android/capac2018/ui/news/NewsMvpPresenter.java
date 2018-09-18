package ro.capac.android.capac2018.ui.news;

import android.view.View;

import ro.capac.android.capac2018.ui.base.MvpPresenter;
/**
 * Created by Paul on 18-Sep-18 at 17:26.
 */
public interface NewsMvpPresenter<V extends NewsMvpView> extends MvpPresenter<V> {
    void showMyEventsList();
    void onAttendEventClick(Long eventId, int cellPosition, View view);
}
