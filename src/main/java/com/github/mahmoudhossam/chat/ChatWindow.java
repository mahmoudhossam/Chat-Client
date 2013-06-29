package com.github.mahmoudhossam.chat;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

public class ChatWindow extends FragmentActivity {

    private EditText messageText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_window);
        messageText = (EditText) findViewById(R.id.editText);
        messageText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            boolean handled = false;
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    String text = textView.getText().toString();
                    if (!text.isEmpty()){
                        sendMessage(text);
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
        ConversationFragment fragment = (ConversationFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment);
        fragment.addMessage(msg);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.chat_window, menu);
        return true;
    }

}
