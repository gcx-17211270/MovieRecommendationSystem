package POJO;

import utils.Seconds2TimeStamp;

/**
 * 类           movie
 * 类的作用:    电影id与其他信息的一个包装类
 * Description: 用于从movies表中获得一条电影信息
 * @Date:       2021/4/5 20:04
 * @author:     32353
 * @version     V1.0.0
*/

public class movie {
    private int movieId;
    private String title;
    private String genres;
    private int ratingsNum;

    public movie() {};
    public movie(int movieId, String title, String genres) {
        this.movieId = movieId;
        this.title = title;
        this.genres = genres;
    }

    public movie(String title, String genres, int ratingsNum) {
        this.title = title;
        this.genres = genres;
        this.ratingsNum = ratingsNum;
    }

    @Override
    public String toString() {
        return "{" +
                "\"movieId\":\"" + movieId +
                "\", \"title\":\"" + title +
                "\", \"genres\":\"" + genres +
                "\", \"ratingsNum\":\"" + ratingsNum +
                "\"}";
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }
}
