package com.github.mahmoudhossam.chat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MessageAdapter extends ArrayAdapter<Message> {

    private ArrayList<Message> messages;
    private Context ctx;
    private int messageViewId;

    public MessageAdapter(Context context, int textViewResourceId, ArrayList<Message> objects) {
        super(context, textViewResourceId, objects);
        messages = objects;
        messageViewId = textViewResourceId;
        ctx = context;
    }

    public void addItem(Message message) {
        messages.add(message);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return messages.size();
    }

    @Override
    public Message getItem(int i) {
        return messages.get(i);
    }

    @Override
    public long getItemId(int i) {
        return getItem(i).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(ctx).inflate(messageViewId, null);
        }
        TextView text = (TextView) convertView.findViewById(R.id.textView);
        text.setText(messages.get(position).getText());
        return convertView;
    }

}
