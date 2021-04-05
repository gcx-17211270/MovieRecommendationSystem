package POJO;

import org.apache.ibatis.type.Alias;

/**
 * 类           Recommendation2
 * 类的作用:    返回推荐结果的JSON对象
 * Description: 同不带2的区别是，这里使用了多表连接，推荐结果的返回值不再是一个movieId
 *              而是一个具体的电影名称
 * @Date:       2021/4/4 10:24
 * @author:     32353
 * @version     V1.0.0
*/
public class Recommendation2 {
    private int id;
    private double score;
    private String recommendation;

    public Recommendation2() {
    }

    public Recommendation2(int id, String recommendation, double score) {
        this.id = id;
        this.recommendation = recommendation;
        this.score = score;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":\"" + id +
                "\", \"recommendation\":\"" + recommendation +
                "\", \"score\":\"" + score +
                "\"}";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public double getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
