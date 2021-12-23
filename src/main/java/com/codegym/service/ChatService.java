package com.codegym.service;

import com.codegym.model.Chat;

import java.util.List;

public interface ChatService {
    List<Chat> findAll();
    void save(Chat chat);
}
