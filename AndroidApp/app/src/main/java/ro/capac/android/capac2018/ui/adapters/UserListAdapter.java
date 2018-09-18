package ro.capac.android.capac2018.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

import ro.capac.android.capac2018.R;
import ro.capac.android.capac2018.data.network.model.UserResponse;

public class UserListAdapter extends ArrayAdapter<UserResponse> {
    public UserListAdapter(Context context, List<UserResponse> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // get item for selected view
        UserResponse user = getItem(position);
        View view = convertView;
        if(view == null){
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            view = layoutInflater.inflate(R.layout.user_list_view_item, null);
        }
        TextView name = view.findViewById(R.id.user_name_in_dialog);
        RatingBar bar = view.findViewById(R.id.rating_bar_user);
        name.setText(user.getUserName());
        bar.setRating(3.5f);
        return view;
    }
}
