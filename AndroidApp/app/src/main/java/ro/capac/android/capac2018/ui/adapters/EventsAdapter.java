package ro.capac.android.capac2018.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.ramotion.foldingcell.FoldingCell;

import java.util.HashSet;
import java.util.List;

import ro.capac.android.capac2018.R;
import ro.capac.android.capac2018.data.network.model.EventResponse;
import ro.capac.android.capac2018.utils.CommonUtils;

/**
 * Simple example of ListAdapter for using with Folding Cell
 * Adapter holds indexes of unfolded elements for correct work with default reusable views behavior
 */
public class EventsAdapter extends ArrayAdapter<EventResponse.Event> {

    private HashSet<Integer> unfoldedIndexes = new HashSet<>();
    private View.OnClickListener goingBtnClickListener;
    private View.OnClickListener attendeesClickListener;
    private View.OnClickListener organizerClickListener;
    private boolean bg = false;

    public EventsAdapter(Context context, List<EventResponse.Event> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // get item for selected view
        EventResponse.Event event = getItem(position);
        // if cell is exists - reuse it, if not - create the new one from resource
        FoldingCell cell = (FoldingCell) convertView;
        ViewHolder viewHolder;
        if (cell == null) {
            viewHolder = new ViewHolder();
            LayoutInflater vi = LayoutInflater.from(getContext());
            cell = (FoldingCell) vi.inflate(R.layout.event_cell, parent, false);
            // binding view parts to view holder
            viewHolder.time = cell.findViewById(R.id.time_in_title_cell);
            viewHolder.date = cell.findViewById(R.id.date_in_title_cell);
            viewHolder.location= cell.findViewById(R.id.location_in_title_cell);
            viewHolder.sportType = cell.findViewById(R.id.sport_type_in_title_cell);
            viewHolder.organizer= cell.findViewById(R.id.organizer_in_title_cell);
            viewHolder.noOfAtendees= cell.findViewById(R.id.number_of_users_going_in_title_cell);
            viewHolder.description= cell.findViewById(R.id.event_description);
            viewHolder.noReqPlayers = cell.findViewById(R.id.required_player_number);
            viewHolder.reqStars = cell.findViewById(R.id.event_req_stars);
            viewHolder.time1 = cell.findViewById(R.id.time_in_content_cell);
            viewHolder.date1 = cell.findViewById(R.id.date_in_content_cell);
            viewHolder.location1= cell.findViewById(R.id.location_in_content_cell);
            viewHolder.sportType1 = cell.findViewById(R.id.sport_type_in_content_cell);
            viewHolder.openSpots = cell.findViewById(R.id.open_spots);
            viewHolder.attendButton = cell.findViewById(R.id.attend_event);
            cell.setTag(viewHolder);
        } else {
            // for existing cell set valid valid state(without animation)
            if (unfoldedIndexes.contains(position)) {
                cell.unfold(true);
            } else {
                cell.fold(true);
            }
            viewHolder = (ViewHolder) cell.getTag();
        }
        // bind data from selected element to view through view holder
        if(event.getDateTime()!=null) {
            viewHolder.time.setText(CommonUtils.formatTime(event.getDateTime()));
            viewHolder.date.setText(CommonUtils.formatDate(event.getDateTime()));
            viewHolder.time1.setText(CommonUtils.formatTime(event.getDateTime()));
            viewHolder.date1.setText(CommonUtils.formatDate(event.getDateTime()));
        }
        if(event.getLocation()!=null) {
            viewHolder.location.setText(event.getLocation());
            viewHolder.location1.setText(event.getLocation());
        }
        if(event.getCategory()!=null) {
            viewHolder.sportType.setText(event.getCategory());
            viewHolder.sportType1.setText(event.getCategory());
        }
        if(event.getOwner()!=null)
        viewHolder.organizer.setText(event.getOwner().getUserName());
        if(event.getAttendees()!=null) {
            viewHolder.noOfAtendees.setText(String.valueOf(event.getAttendees().size()));
            viewHolder.openSpots.setText(String.valueOf(event.getMaxAttendees() - event.getAttendees().size()));
        }
        if(event.getDescription().equals("null"))

            viewHolder.description.setText("The organizer hasn't provided any description for this event, just go and have some fun!");
        else
            viewHolder.description.setText(event.getDescription());
        if(event.getMaxAttendees()!=null) {
            viewHolder.noReqPlayers.setText(String.valueOf(event.getMaxAttendees()));
        } else{
            viewHolder.noReqPlayers.setText("0");
        }
        if(event.getMinReputation()!=null) {
            viewHolder.reqStars.setText(String.valueOf(event.getMinReputation()));
        } else{
            viewHolder.reqStars.setText(String.valueOf("0"));
        }
        viewHolder.organizer.setOnClickListener(organizerClickListener);
        viewHolder.organizer.setTag(position);
        viewHolder.attendButton.setOnClickListener(goingBtnClickListener);
        viewHolder.attendButton.setTag(position);
        viewHolder.noOfAtendees.setOnClickListener(attendeesClickListener);
        viewHolder.noOfAtendees.setTag(position);
        if(bg)
            viewHolder.attendButton.setBackground(getContext().getDrawable(R.drawable.bg_going_btn));
        return cell;
    }

    public View.OnClickListener getAttendeesClickListener() {
        return attendeesClickListener;
    }
    public void setAttendeesClickListener(View.OnClickListener attendeesClickListener) {
        this.attendeesClickListener = attendeesClickListener;
    }

    public View.OnClickListener getOrganizerClickListener() {
        return organizerClickListener;
    }

    public void setOrganizerClickListener(View.OnClickListener organizerClickListener) {
        this.organizerClickListener = organizerClickListener;
    }
    // simple methods for register cell state changes
    public void registerToggle(int position) {
        if (unfoldedIndexes.contains(position))
            registerFold(position);
        else
            registerUnfold(position);
    }

    public void setButtonBg(boolean bg){
        this.bg = bg;
    }

    private void registerFold(int position) {
        unfoldedIndexes.remove(position);
    }

    private void registerUnfold(int position) {
        unfoldedIndexes.add(position);
    }
    public View.OnClickListener getGoingBtnClickListener() {
        return goingBtnClickListener;
    }
    public void setGoingBtnClickListener(View.OnClickListener defaultRequestBtnClickListener) {
        this.goingBtnClickListener = defaultRequestBtnClickListener;
    }
    // View lookup cache

    private static class ViewHolder {
        TextView time;
        TextView date;
        TextView location;
        TextView sportType;
        TextView organizer;
        TextView noOfAtendees;
        TextView description;
        TextView noReqPlayers;
        TextView reqStars;
        TextView time1;
        TextView date1;
        TextView location1;
        TextView sportType1;
        Button attendButton;
        TextView openSpots;
    }
}
