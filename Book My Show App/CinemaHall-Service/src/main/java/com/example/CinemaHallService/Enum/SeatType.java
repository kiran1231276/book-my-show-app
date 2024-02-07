package com.example.CinemaHallService.Enum;


public enum SeatType {

    DIAMOND("Diamond"),
    GOLD("Gold"),
    PLATINUM("Platinum");

    private final String displayName;

    SeatType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
