package ro.capac.android.capac2018.ui.news;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.OnItemClickListener;
import com.orhanobut.dialogplus.ViewHolder;
import com.ramotion.foldingcell.FoldingCell;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import ro.capac.android.capac2018.R;
import ro.capac.android.capac2018.data.network.model.EventResponse;
import ro.capac.android.capac2018.data.network.model.UserResponse;
import ro.capac.android.capac2018.di.component.ActivityComponent;
import ro.capac.android.capac2018.ui.adapters.EventsAdapter;
import ro.capac.android.capac2018.ui.adapters.UserListAdapter;
import ro.capac.android.capac2018.ui.base.BaseFragment;
import ro.capac.android.capac2018.ui.create_event.CreateEventActivity;

/**
 * Created by Paul on 18-Sep-18 at 17:26.
 */
public class NewsFragment extends BaseFragment implements NewsMvpView {
    public static final String TAG = "NewsFragment";
    EventsAdapter adapter;
    List<EventResponse.Event> events = new ArrayList<>();
    ListView listView;
    @Inject
    NewsMvpPresenter<NewsMvpView> mPresenter;
    public static NewsFragment newInstance() {
        Bundle args = new Bundle();
        NewsFragment fragment = new NewsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_categorizedevents, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(NewsFragment.this);
            setUnBinder(ButterKnife.bind(this, view));
            mPresenter.onAttach(this);
        }
        listView = view.findViewById(R.id.categorizedevents_listview);
// create custom adapter that holds elements and their state (we need hold a id's of unfolded elements for reusable elements)
        adapter = new EventsAdapter(this.getContext(), events);
        adapter.setButtonBg(true);
        mPresenter.showMyEventsList();
        adapter.setGoingBtnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventResponse.Event event = adapter.getItem((Integer) view.getTag());
                mPresenter.onAttendEventClick(event.getId(),(Integer) view.getTag(),view);
            }
        });
        adapter.setOrganizerClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserResponse owner = adapter.getItem((Integer) v.getTag()).getOwner();
                View view = LayoutInflater.from(NewsFragment.this.getContext()).inflate(R.layout.dialog_owner,null,false);
                TextView name = view.findViewById(R.id.owner_name_in_dialog);
                name.setText(owner.getUserName());
                DialogPlus dialog = DialogPlus.newDialog(NewsFragment.this.getContext())
                        .setContentHolder(new ViewHolder(view))
                        .setGravity(Gravity.CENTER)
                        .setCancelable(true)
                        .setHeader(R.layout.dialog_owner_header)
                        .setOnItemClickListener(new OnItemClickListener() {
                            @Override
                            public void onItemClick(DialogPlus dialog, Object item, View view, int position) {

                            }
                        })
                        .setContentBackgroundResource(R.drawable.owner_dialog)
                        .create();
                dialog.show();
            }
        });
        adapter.setAttendeesClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<UserResponse> users = adapter.getItem((Integer) view.getTag()).getAttendees();
                UserListAdapter userListAdapter = new UserListAdapter(NewsFragment.this.getContext(),users);
                DialogPlus dialog = DialogPlus.newDialog(NewsFragment.this.getContext())
                        .setAdapter(userListAdapter)
                        .setOnItemClickListener(new OnItemClickListener() {
                            @Override
                            public void onItemClick(DialogPlus dialog, Object item, View view, int position) {
                            }
                        })
                        .setExpanded(true)  // This will enable the expand feature, (similar to android L share dialog)
                        .setCancelable(true)
                        .setHeader(R.layout.dialog_header_user_list)
                        .setContentBackgroundResource(R.drawable.bg_header)
                        .create();
                dialog.show();
            }
        });
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
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }

    @Override
    public void openCreateEventActivity() {
        startActivity(CreateEventActivity.getStartIntent(NewsFragment.this.getContext()));
    }

    @Override
    public void refreshList(List<EventResponse.Event> events) {
        this.events.clear();
        this.events.addAll(events);
        this.adapter.notifyDataSetChanged();
        //adapter = new EventsAdapter(this,events);
        this.listView.invalidate();
    }

    @Override
    public void addAttendee(int cellPosition, List<UserResponse> attendees, View view) {
        adapter.getItem(cellPosition).setAttendees(attendees);
        Button mButton = (Button) view;
        mButton.setBackground(getResources().getDrawable(R.drawable.bg_going_btn));
        mButton.setText("GOING");
        mButton.setClickable(false);
        mButton.setFocusable(false);
        this.adapter.notifyDataSetChanged();
    }

    @Override
    public void alreadyGoing(View view) {
        Button mButton = (Button) view;
        mButton.setBackground(getResources().getDrawable(R.drawable.bg_going_btn));
        mButton.setText("GOING");
    }
}
