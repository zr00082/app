package com.example.bountyhunterapi;

import com.google.gson.annotations.SerializedName;

import java.util.UUID;

public class Friend {
    @SerializedName("id")
    private int id;
    @SerializedName("sender")
    private UUID sender;
    @SerializedName("receiver")
    private UUID receiver;
    @SerializedName("blocked")
    private boolean blocked;
    @SerializedName(value = "friend",alternate = {"followingUser","followedBy"})
    private User friend;

    public Friend(int id, UUID sender, UUID receiver, boolean blocked, User friend) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.blocked = blocked;
        this.friend = friend;
    }

    public int getId() {
        return this.id;
    }

    public UUID getSender() {
        return this.sender;
    }

    public UUID getReceiver() {
        return this.receiver;
    }

    public boolean isBlocked() {
        return this.blocked;
    }

    public User getFriend() {
        return this.friend;
    }
}
