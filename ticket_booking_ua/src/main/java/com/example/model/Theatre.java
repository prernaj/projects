package com.example.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class Theatre {
    String id;
    String name;
    List<Screen> screens;

    public Theatre(String id, String name) {
        this.id = id;
        this.name = name;
        this.screens = new ArrayList<>();
    }

    public void addScreen(Screen screen) {
        screens.add(screen);
    }
}
