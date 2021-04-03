package POJO;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
/**
 * 类           Recommendation
 * 类的作用:    前端与后端之间，用JSON对象形式传递数据，这里返回一个用户的推荐结果
 * Description:
 * @Date:       2021/3/30 17:19
 * @author:     32353
 * @version     V1.0.0
*/

public class Recommendation {
    private int id;
    private int recommendation;
    private float score;

    public Recommendation(int id, int recommendation, float score) {
        this.id = id;
        this.recommendation = recommendation;
        this.score = score;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":\"" + id +
                "\", \"recommendation\":\"" + recommendation +
                "\"}";
    }

    public JSONObject getResult() {
        return JSON.parseObject(this.toString());
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRecommendation(int recommendation) {
        this.recommendation = recommendation;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public int getRecommendation() {
        return recommendation;
    }

    public float getScore() {
        return score;
    }
}
