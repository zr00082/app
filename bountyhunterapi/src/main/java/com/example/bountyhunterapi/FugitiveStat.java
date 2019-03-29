package com.example.bountyhunterapi;

import android.net.Uri;

import java.util.UUID;

public class FugitiveStat {


    private int id;
    private UUID gid;
    private UUID uid;
    private int points;
    private int challengesCompleted;
    private int chanllengesFailed;
    private boolean won;

    public FugitiveStat(int id, UUID gid, UUID uid, int points, int challengesCompleted, int chanllengesFailed, boolean won) {
        this.id = id;
        this.gid = gid;
        this.uid = uid;
        this.points = points;
        this.challengesCompleted = challengesCompleted;
        this.chanllengesFailed = chanllengesFailed;
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

    public int getChallengesCompleted() {
        return this.challengesCompleted;
    }

    public int getChanllengesFailed() {
        return this.chanllengesFailed;
    }

    public boolean isWon() {
        return this.won;
    }
}
