package mapper;

import POJO.movie;
import POJO.rating;
import POJO.tag;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import utils.RecommendationUtils;

import java.util.List;

import static org.junit.Assert.*;

public class SearchMovieMapperTest {
    @Test
    public void testSearchMovieMapper() {
        try (SqlSession sqlSession = RecommendationUtils.getSqlSession();) {
            SearchMovieMapper smm = sqlSession.getMapper(SearchMovieMapper.class);
            List<movie> itemBasedCF = smm.searchMovieNameForInfo("%" + "Toy" + "%");
            for (movie movie : itemBasedCF) {
                System.out.println(movie.toString());
            }
        }
    }
}