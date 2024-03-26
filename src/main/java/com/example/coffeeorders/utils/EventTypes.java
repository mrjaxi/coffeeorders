package com.example.coffeeorders.utils;

import java.util.Arrays;

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

    public static boolean byEventId(int eventId) {
        return Arrays.stream(EventTypes.values())
                .anyMatch(item -> item.getType() == eventId);
    }
}
