package ro.capac.android.capac2018.ui.chat;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import ro.capac.android.capac2018.R;
import ro.capac.android.capac2018.data.db.model.ChatMessage;

public class ChatAdapter extends BaseAdapter {

    private static LayoutInflater inflater = null;
    private ArrayList<ChatMessage> chatMessageList;

    ChatAdapter(Activity activity, ArrayList<ChatMessage> list) {
        chatMessageList = list;
        inflater = (LayoutInflater) activity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return chatMessageList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ChatMessage message = chatMessageList.get(position);
        View vi = convertView;
        if (convertView == null)
            vi = inflater.inflate(R.layout.chat_bubble, null);

        TextView msg = vi.findViewById(R.id.message_text);
        msg.setText(message.body);
        LinearLayout layout = vi
                .findViewById(R.id.bubble_layout);
        LinearLayout parent_layout = vi
                .findViewById(R.id.bubble_layout_parent);

        // if message is mine then align to right
        if (message.isMine) {
            layout.setBackgroundResource(R.drawable.chat);
            parent_layout.setGravity(Gravity.END);
        }
        // If not mine then align to left
        else {
            layout.setBackgroundResource(R.drawable.white_bubble_speech);
            parent_layout.setGravity(Gravity.START);
        }
        msg.setTextColor(Color.BLACK);
        return vi;
    }

    public void add(ChatMessage object) {
        chatMessageList.add(object);
    }
}