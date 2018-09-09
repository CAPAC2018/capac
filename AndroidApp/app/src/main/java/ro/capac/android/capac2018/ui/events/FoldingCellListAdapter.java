package ro.capac.android.capac2018.ui.events;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ramotion.foldingcell.FoldingCell;

import java.util.HashSet;
import java.util.List;

import ro.capac.android.capac2018.R;
import ro.capac.android.capac2018.data.db.model.Event;

/**
 * Simple example of ListAdapter for using with Folding Cell
 * Adapter holds indexes of unfolded elements for correct work with default reusable views behavior
 */
public class FoldingCellListAdapter extends ArrayAdapter<Event> {

    private HashSet<Integer> unfoldedIndexes = new HashSet<>();
    private View.OnClickListener defaultRequestBtnClickListener;

    public FoldingCellListAdapter(Context context, List<Event> objects) {
        super(context, 0, objects);
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // get item for selected view
        Event event = getItem(position);
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
        viewHolder.time.setText(event.getTime());
        viewHolder.date.setText(event.getDate());
        viewHolder.location.setText(event.getLocation());
        viewHolder.sportType.setText(event.getSportType());
        viewHolder.time1.setText(event.getTime());
        viewHolder.date1.setText(event.getDate());
        viewHolder.location1.setText(event.getLocation());
        viewHolder.sportType1.setText(event.getSportType());
        viewHolder.organizer.setText(event.getOrganizer());
        viewHolder.noOfAtendees.setText(event.getNoOfAttendees());
        if(event.getDescription().equals("null"))
            viewHolder.description.setText("The organizer hasn't provided any description for this event, just go and have some fun!");
        else
            viewHolder.description.setText(event.getDescription());
        viewHolder.noReqPlayers.setText(event.getMaxAttendees());
        viewHolder.reqStars.setText(event.getReqStars());
        return cell;
    }

    // simple methods for register cell state changes
    public void registerToggle(int position) {
        if (unfoldedIndexes.contains(position))
            registerFold(position);
        else
            registerUnfold(position);
    }

    private void registerFold(int position) {
        unfoldedIndexes.remove(position);
    }

    private void registerUnfold(int position) {
        unfoldedIndexes.add(position);
    }
    public View.OnClickListener getDefaultRequestBtnClickListener() {
        return defaultRequestBtnClickListener;
    }
    public void setDefaultRequestBtnClickListener(View.OnClickListener defaultRequestBtnClickListener) {
        this.defaultRequestBtnClickListener = defaultRequestBtnClickListener;
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
    }
}
