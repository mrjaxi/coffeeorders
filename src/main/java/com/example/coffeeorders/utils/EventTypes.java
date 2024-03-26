package com.example.coffeeorders.utils;

import java.util.Arrays;

public enum EventTypes {
    CANCEL(0),
    REGISTER(1),
    IN_WORK(2),
    PREPARE(3),
    FINISH(4);

    private final int type;
    EventTypes(int type) {
        this.type = type;
    }

    public int getType(){
        return type;
    }
}
