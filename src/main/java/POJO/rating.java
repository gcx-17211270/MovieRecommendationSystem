package POJO;

import utils.Seconds2TimeStamp;

public class rating {
    private int userId;
    private int movieId;
    private double rating;
    private int timestamp;

    @Override
    public String toString() {
        return "{" +
                "\"userId\":\"" + userId +
                "\", \"movieId\":\"" + movieId +
                "\", \"rating\":\"" + rating +
                "\", \"timestamp\":\"" + Seconds2TimeStamp.int2time(timestamp) +
                "\"}";
    }

    public rating() {
    }

    public rating(int userId, int movieId, double rating, int timestamp) {
        this.userId = userId;
        this.movieId = movieId;
        this.rating = rating;
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

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }
}
