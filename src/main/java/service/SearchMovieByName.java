package service;

import POJO.rating;
import POJO.tag;

import java.util.List;

/**
 * 类           SearchMovieByName
 * 类的作用:    用于处理从电影名获得相似电影系列，然后将全部结果传回
 * Description:
 * @Date:       2021/4/5 21:47
 * @author:     32353
 * @version     V1.0.0
*/

public class SearchMovieByName {

    public List<rating> searchMovieNameForRatings(String movieName){
        return null;
    }
    public List<tag> searchMovieNameForTags(String movieName){
        return null;
    }

    public static String List2Array(List list) {
        StringBuffer str = new StringBuffer("[");
        for (Object o : list) {
            if (str.toString().equals("[")) {
                str.append(o.toString());
            }
            else {
                str.append("," + o.toString());
            }
        }
        str.append("]");
        return str.toString();
    }
}
