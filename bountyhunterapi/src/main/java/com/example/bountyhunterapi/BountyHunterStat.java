package com.example.bountyhunterapi;

import java.util.UUID;

public class BountyHunterStat {
    private int id;
    private UUID gid;
    private UUID uid;
    private int points;
    private int captures;
    private boolean won;

    public BountyHunterStat(int id, UUID gid, UUID uid, int points, int captures, boolean won) {
        this.id = id;
        this.gid = gid;
        this.uid = uid;
        this.points = points;
        this.captures = captures;
        this.won = won;
    }

    public int getId() {
        return this.id;
    }

    public UUID getGid() {
        return this.gid;
    }

    public UUID getUid() {
        return this.uid;
    }

    public int getPoints() {
        return this.points;
    }

    public int getCaptures() {
        return this.captures;
    }

    public boolean isWon() {
        return this.won;
    }
}
