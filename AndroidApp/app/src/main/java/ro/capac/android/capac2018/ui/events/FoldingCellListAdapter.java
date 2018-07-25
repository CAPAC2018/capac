package ro.capac.android.capac2018.ui.events;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
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
    private Context mContext;

    public FoldingCellListAdapter(Context context, List<Event> objects) {
        super(context, 0, objects);
        this.mContext = context;
    }


    @NonNull
    @Override
    public View getView(final int position, View convertView, @NonNull ViewGroup parent) {
        // get item for selected view
        Event event = getItem(position);
        // if cell is exists - reuse it, if not - create the new one from resource
        FoldingCell cell = (FoldingCell) convertView;
        final ViewHolder viewHolder;
        if (cell == null) {
            viewHolder = new ViewHolder();
            LayoutInflater vi = LayoutInflater.from(getContext());
            cell = (FoldingCell) vi.inflate(R.layout.event_cell, parent, false);
            // binding view parts to view holder
            viewHolder.tezaDetails = (RelativeLayout) cell.findViewById(R.id.teza_details);
            viewHolder.disciplineName = (TextView) cell.findViewById(R.id.discipline_name_in_cell_list);
            viewHolder.addGradeButton = (TextView) cell.findViewById(R.id.add_grade_button_in_custom_adapter);
            viewHolder.average = (TextView) cell.findViewById(R.id.average_text_in_list_view);
            viewHolder.discipline = (TextView) cell.findViewById(R.id.discipline_text_in_list_view);
            viewHolder.disciplineGrades = (TextView) cell.findViewById(R.id.grades_in_cell_content);
            viewHolder.teza = (TextView) cell.findViewById(R.id.teza_grade);
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

        assert event != null;
        viewHolder.disciplineName.setText(event.getName());

        viewHolder.addGradeButton.setOnClickListener(defaultRequestBtnClickListener);


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

    // View lookup cache
    private static class ViewHolder {
        TextView disciplineName;
        TextView discipline;
        TextView disciplineGrades;
        TextView average;
        TextView teza;
        RelativeLayout tezaDetails;
        TextView addGradeButton;
    }
}
