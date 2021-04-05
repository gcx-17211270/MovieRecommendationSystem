package POJO;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

public class RecommendationTest {
    @Test
    public void testRecommendation() {;
//        Recommendation rec = new Recommendation(1, 2, (float) 12.89);
//        System.out.println(rec.getResult());
//        System.out.println(rec.getResult().toString());
//
//        assert rec.getResult() instanceof JSONObject;

        String s = "{" +
                "\"1\": \"[('2011', 37.26389549621345), ('1527', 32.43401085554542), " +
                "('1036', 29.92681030941769), ('2003', 27.38377313948367), " +
                "('2571', 27.176642551837435), ('924', 24.880101039231096), " +
                "('541', 24.348590226299194), ('858', 22.08275926393216), " +
                "('1129', 21.623154132646768), ('1240', 21.1128971549334)]\", " +
                "\"2\": \"[('2959', 10.051327380330013), ('79132', 8.2517950348456), " +
                "('59315', 7.263594249323636), ('32587', 6.9115313137439855), " +
                "('33794', 6.447381772406242), ('122904', 6.260165319594581), " +
                "('64614', 5.220447536851168), ('99114', 5.118565412032975), " +
                "('58559', 5.092692852130803), ('2571', 4.899607395617865)]\""
                + "}";
        JSONObject jo = JSONObject.parseObject(s);
        System.out.println(jo);
    }
}