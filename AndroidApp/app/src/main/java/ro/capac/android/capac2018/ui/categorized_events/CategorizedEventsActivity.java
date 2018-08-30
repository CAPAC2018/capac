package ro.capac.android.capac2018.ui.categorized_events;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.ramotion.foldingcell.FoldingCell;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import ro.capac.android.capac2018.R;
import ro.capac.android.capac2018.data.db.model.Event;
import ro.capac.android.capac2018.ui.base.BaseActivity;
import ro.capac.android.capac2018.ui.create_event.CreateEventActivity;

public class CategorizedEventsActivity extends BaseActivity implements CategorizedEventsMvpView {

    @Inject
    CategorizedEventsMvpPresenter<CategorizedEventsMvpView> mPresenter;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, CategorizedEventsActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_categorizedevents);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);

        final ListView listView = findViewById(R.id.categorizedevents_listview);
        final ArrayList<Event> events = Event.getTestingList();

        // create custom adapter that holds elements and their state (we need hold a id's of unfolded elements for reusable elements)
        final CategorizedEventsAdapter adapter = new CategorizedEventsAdapter(this, events);

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
    }
    @Override
    @OnClick(R.id.create_event_btn)
    public void openCreateEventActivity()
    {
        startActivity(CreateEventActivity.getStartIntent(CategorizedEventsActivity.this));
    }
    @Override
    protected void setUp() {

    }
}
