package ro.capac.android.capac2018.ui.categorized_events;

import java.util.List;

import ro.capac.android.capac2018.data.network.model.EventResponse;
import ro.capac.android.capac2018.di.PerActivity;
import ro.capac.android.capac2018.ui.base.MvpPresenter;

@PerActivity
public interface CategorizedEventsMvpPresenter<V extends CategorizedEventsMvpView> extends MvpPresenter<V> {
    List<EventResponse.Event> getEventsList(String category);
}
