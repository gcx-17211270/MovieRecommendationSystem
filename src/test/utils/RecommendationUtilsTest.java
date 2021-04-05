package utils;

import mapper.RecommendationMapper;
import POJO.Recommendation;
import POJO.Recommendation2;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

/**
 * 类           RecommendationUtilsTest
 * 类的作用:    使用该工具类，从数据库中获取一个Recommendation对象实例
 * Description:
 * @Date:       2021/4/3 15:14
 * @author:     32353
 * @version     V1.0.0
*/

public class RecommendationUtilsTest {
    Logger log = Logger.getLogger(RecommendationUtilsTest.class);
    @Test
    public void testRecommendation(){
        SqlSession sqlSession = RecommendationUtils.getSqlSession();
//        log.info(sqlSession);

        RecommendationMapper rm = sqlSession.getMapper(RecommendationMapper.class);

        List<Recommendation> list = rm.getRecommendation();
        for (Recommendation recommendation : list) {
            System.out.println(recommendation);
        }

//        List<POJO.Recommendation2> list2 = rm.getRecommendation2(2);
//        for (Recommendation2 recommendation : list2) {
//            System.out.println(recommendation);
//        }
        List<POJO.Recommendation2> list3 = rm.getNthRecommendation("itembasedcf", 2, 1);
        for (Recommendation2 recommendation : list3) {
            System.out.println(recommendation);
        }

        sqlSession.close();
    }

    @Test
    public void testSELECT() {
        SqlSession sqlSession = RecommendationUtils.getSqlSession();
        System.out.println("新创建的SqlSession:" + sqlSession);

        RecommendationMapper rm = sqlSession.getMapper(RecommendationMapper.class);
        Recommendation2 rm2 = rm.getOne("itembasedcf", 1, 2011);
        System.out.println(rm2);
        sqlSession.close();
    }

    @Test
    public void testINSERT() {
        SqlSession sqlSession = RecommendationUtils.getSqlSession();
        System.out.println("新创建的SqlSession:" + sqlSession);

        RecommendationMapper rm = sqlSession.getMapper(RecommendationMapper.class);
        int n = rm.addRecommendation("itembasedcf",
                new Recommendation(1, 1000,10.0));
        //没有提交事务，就不会插入到数据库中
//            sqlSession.commit();
        System.out.println(n);
        sqlSession.close();
    }

    @Test
    public void testDELETE() {
        try (SqlSession sqlSession = RecommendationUtils.getSqlSession();) {
            System.out.println("新创建的SqlSession:" + sqlSession);

            RecommendationMapper rm = sqlSession.getMapper(RecommendationMapper.class);
            int n = rm.deleteRecommendation("itembasedcf", 1, 1000);
            //没有提交事务，就不会删除到数据库中
//            sqlSession.commit();
            System.out.println(n);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void testUPDATE() {
        try (SqlSession sqlSession = RecommendationUtils.getSqlSession();) {
            System.out.println("新创建的SqlSession:" + sqlSession);

            RecommendationMapper rm = sqlSession.getMapper(RecommendationMapper.class);
            int n = rm.updateRecommendation("itembasedcf",
                    new Recommendation(1, 1000, 22.33));
            //没有提交事务，不会更新到数据库中
//            sqlSession.commit();
            System.out.println(n);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}