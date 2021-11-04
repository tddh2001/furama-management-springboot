package com.codegym.model;

import javax.persistence.*;

@Entity
@Table
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int chatID;
    private String nameUser;
    private String content;

    public Chat() {
    }

    public Chat(int chatID, String nameUser, String content) {
        this.chatID = chatID;
        this.nameUser = nameUser;
        this.content = content;
    }

    public int getChatID() {
        return chatID;
    }

    public void setChatID(int chatID) {
        this.chatID = chatID;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
