package com.github.mahmoudhossam.chat;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ConversationFragment extends ListFragment {

    private MessageAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<Message> messages = new ArrayList<Message>();
        adapter = new MessageAdapter(getActivity(), R.layout.message, messages);
        setListAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.conversation, container, false);
    }

    public void addMessage(Message message) {
        adapter.addItem(message);

    }
}
