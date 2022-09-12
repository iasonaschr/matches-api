package com.example.matches.utilities;

public enum SportKind {
    FOOTBALL(1),
    BASKETBALL(2);

    public final int val;

    private SportKind(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return String.valueOf(this.val);
    }
}
