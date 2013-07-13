package com.github.mahmoudhossam.chat;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

public class ChatWindow extends ListActivity {

    private EditText messageText;
    private MessageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_window);
        ArrayList<Message> messages = new ArrayList<Message>();
        adapter = new MessageAdapter(this, R.layout.message, messages);
        setListAdapter(adapter);
        messageText = (EditText) findViewById(R.id.editText);
        messageText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            boolean handled = false;
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    String text = textView.getText().toString();
                    if (!text.isEmpty()){
                        sendMessage(text);
                    } else {
                        Toast.makeText(getApplicationContext(), "Please enter a message.",
                                Toast.LENGTH_SHORT).show();
                    }
                }
                return handled;
            }
        });

    }

    public void onSendClicked(View view){
        messageText.onEditorAction(EditorInfo.IME_ACTION_SEND);
    }

    private void sendMessage(String message) {
        Message msg = new Message(message, new Date());
        adapter.addItem(msg);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.chat_window, menu);
        return true;
    }

}
