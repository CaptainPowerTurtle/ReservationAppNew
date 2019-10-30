package com.jacob.reservationapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "reservation_table")
public class Reservation {
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("fromTime")
    @Expose
    private long fromTime;
    @SerializedName("toTime")
    @Expose
    private long toTime;
    @SerializedName("userId")
    @Expose
    private String userId;
    @SerializedName("purpose")
    @Expose
    private String purpose;
    @SerializedName("roomId")
    @Expose
    private int roomId;

    public Reservation(long fromTime, long toTime, String userId, String purpose, int roomId) {
        this.fromTime = fromTime;
        this.toTime = toTime;
        this.userId = userId;
        this.purpose = purpose;
        this.roomId = roomId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public long getFromTime() {
        return fromTime;
    }

    public long getToTime() {
        return toTime;
    }

    public String getUserId() {
        return userId;
    }

    public String getPurpose() {
        return purpose;
    }

    public int getRoomId() {
        return roomId;
    }
}
