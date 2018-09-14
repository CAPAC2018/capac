package ro.capac.android.capac2018.ui.categorized_events;

import android.view.View;

import java.util.List;

import ro.capac.android.capac2018.data.network.model.EventResponse;
import ro.capac.android.capac2018.data.network.model.UserResponse;
import ro.capac.android.capac2018.ui.base.MvpView;

public interface CategorizedEventsMvpView extends MvpView {

    void openCreateEventActivity();
    void refreshList(List<EventResponse.Event> events);
    void addAttendee(int cellPosition, List<UserResponse> attendees, View view);
    void alreadyGoing(View view);
}
