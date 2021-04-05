package POJO;
/**
 * 类           result
 * 类的作用:    从数据库中获得的一个推荐算法评价指标
 * Description:
 * @Date:       2021/4/6 4:30
 * @author:     32353
 * @version     V1.0.0
*/

public class result {
    private String algorithm;
    private double precision;
    private double recall;
    private double coverage;
    private double popularity;

    public result(){}

    public result(String algorithm, double precision, double recall, double coverage, double popularity) {
        this.algorithm = algorithm;
        this.precision = precision;
        this.recall = recall;
        this.coverage = coverage;
        this.popularity = popularity;
    }

    @Override
    public String toString() {
        return "{" +
                "\"algorithm\":\"" + algorithm +
                "\", \"precision\":\"" + precision +
                "\", \"recall\":\"" + recall +
                "\", \"coverage\":\"" + coverage +
                "\", \"popularity\":\"" + popularity +
                "\"}";
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public double getPrecision() {
        return precision;
    }

    public void setPrecision(double precision) {
        this.precision = precision;
    }

    public double getRecall() {
        return recall;
    }

    public void setRecall(double recall) {
        this.recall = recall;
    }

    public double getCoverage() {
        return coverage;
    }

    public void setCoverage(double coverage) {
        this.coverage = coverage;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }
}
