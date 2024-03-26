package com.example.coffeeorders.utils;

import java.util.Arrays;

public enum EventTypes {
    REGISTER(0),
    CANCEL(-1),
    IN_WORK(1),
    PREPARE(2),
    FINISH(3);

    private final int type;
    EventTypes(int type) {
        this.type = type;
    }

    public int getType(){
        return type;
    }
}
