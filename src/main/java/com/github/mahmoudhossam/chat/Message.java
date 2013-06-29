package com.github.mahmoudhossam.chat;

import java.util.Date;

public class Message {

    private String text;
    private Date sent;
    private Date received;

    public Message(String text, Date sent) {
        this.text = text;
        this.sent = sent;
    }

    public String getText() {
        return text;
    }

    public void setReceivedAt(Date at){
        received = at;
    }

    public Date getReceivedAt() {
        return received;
    }

    public Date getSentAt() {
        return sent;
    }

    @Override
    public boolean equals(Object o) {
        boolean equals = false;
        if (o instanceof Message){
            Message m = (Message) o;
            equals = this.text.equals(m.getText()) && this.sent == m.getSentAt()
                    && this.received == m.getReceivedAt();
        }
        return equals;
    }

    @Override
    public int hashCode() {
        return text.hashCode();
    }
}
