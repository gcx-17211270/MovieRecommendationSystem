package mapper;

import POJO.movie;
import POJO.rating;
import POJO.tag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 类           SearchMovie
 * 类的作用:    提供对搜索电影信息时的各种信息
 * Description:
 * @Date:       2021/4/5 21:07
 * @author:     32353
 * @version     V1.0.0
*/

public interface SearchMovieMapper {
    /**
     * 两个系列分别提供对电影ID、电影名的信息搜索
     * */
    public List<movie> searchMovieIdForInfo(int movieId);
    public List<rating> searchMovieIdForRatings(int movieId);
    public List<tag> searchMovieIdForTags(int movieId);

    public List<movie> searchMovieNameForInfo(String movieName);
}
