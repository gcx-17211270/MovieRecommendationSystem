package POJO;

import utils.Seconds2TimeStamp;

public class tag {
    int userId;
    int movieId;
    String tag;
    int timestamp;

    @Override
    public String toString() {
        return "{" +
                "\"userId\":\"" + userId +
                "\", \"movieId\":\"" + movieId +
                "\", \"tag\":\"" + tag +
                "\", \"timestamp\":\"" + Seconds2TimeStamp.int2time(timestamp) +
                "\"}";
    }

    public tag() {}

    public tag(int userId, int movieId, String tag, int timestamp) {
        this.userId = userId;
        this.movieId = movieId;
        this.tag = tag;
        this.timestamp = timestamp;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }
}
