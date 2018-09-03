package ro.capac.android.capac2018.ui.categorized_events;

import java.util.List;

import ro.capac.android.capac2018.data.network.model.EventResponse;
import ro.capac.android.capac2018.ui.base.MvpView;

public interface CategorizedEventsMvpView extends MvpView {

    void openCreateEventActivity();
    void refreshList(List<EventResponse.Event> events);
}
