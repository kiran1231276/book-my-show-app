package com.example.CinemaHallService.Enum;

public enum HallType {

    REGULAR("Regular"),
    IMAX("IMAX"),
    _3D("3D");

    private final String displayName;

    HallType(String displayName) {
        this.displayName = displayName;
    }
    public String getDisplayName() {
        return displayName;
    }
}
