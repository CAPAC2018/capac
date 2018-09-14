package ro.capac.android.capac2018.ui.events;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ramotion.foldingcell.FoldingCell;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import ro.capac.android.capac2018.R;
import ro.capac.android.capac2018.data.db.model.Event;
import ro.capac.android.capac2018.di.component.ActivityComponent;
import ro.capac.android.capac2018.ui.base.BaseFragment;
import ro.capac.android.capac2018.ui.categorized_events.CategorizedEventsActivity;
import ro.capac.android.capac2018.ui.create_event.CreateEventActivity;

public class EventsFragment extends BaseFragment implements EventsMvpView {
    public static final String TAG = "EventsFragment";

    @Inject
    EventsMvpPresenter<EventsMvpView> mPresenter;

    public static EventsFragment newInstance() {
        Bundle args = new Bundle();
        EventsFragment fragment = new EventsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_events, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(EventsFragment.this);
            setUnBinder(ButterKnife.bind(this, view));
            mPresenter.onAttach(this);
        }
        final ListView listView = view.findViewById(R.id.event_list);
        final ArrayList<Event> events = Event.getTestingList();

        // create custom adapter that holds elements and their state (we need hold a id's of unfolded elements for reusable elements)
        final FoldingCellListAdapter adapter = new FoldingCellListAdapter(this.getContext(), events);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                // toggle clicked cell state
                ((FoldingCell) view).toggle(false);

                //Block scrolling to prevent a drawing bug
                listView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        return true;
                    }
                });
                // register in adapter that state for selected cell is toggled
                adapter.registerToggle(pos);

                //Unlock scrolling after animation has ended
                Runnable r = new Runnable() {
                    @Override
                    public void run(){
                        listView.setOnTouchListener(null);
                    }
                };
                Handler h = new Handler();
                h.postDelayed(r, 1900);
            }
        });

        return view;
    }
    @Override
    protected void setUp(View view) {

    }
    @Override
    @OnClick(R.id.create_event_btn)
    public void openCreateEventActivity() {
        startActivity(CreateEventActivity.getStartIntent(this.getContext()));
    }
    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }
}
