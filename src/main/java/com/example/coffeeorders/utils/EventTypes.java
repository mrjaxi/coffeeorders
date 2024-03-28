package com.example.coffeeorders.utils;

public enum EventTypes {
    REGISTER(1),
    IN_WORK(2),
    PREPARE(3),
    FINISH(4),
    CANCEL(5);

    private final int type;
    EventTypes(int type) {
        this.type = type;
    }

    public int getType(){
        return type;
    }
}
