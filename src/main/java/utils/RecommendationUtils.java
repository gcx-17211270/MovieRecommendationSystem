package utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 * 类           RecommendationUtils
 * 类的作用:    获取sqlSessionFactory,操作Recommendation对象的工具类
 * Description:
 * @Date:       2021/4/3 15:09
 * @author:     32353
 * @version     V1.0.0
*/

public class RecommendationUtils {
    private static SqlSessionFactory sqlSessionFactory;
    /**
     *直接使用对象类的静态方法连接数据库获取对象，请勿创建对象实例
     */
    private RecommendationUtils(){}

    static {
        Logger Log = Logger.getLogger(RecommendationUtils.class);
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        Properties prop = new Properties();
        try {
            // 对数据库配置文件的解密
            inputStream = Resources.getResourceAsStream("db.properties");
            prop.load(inputStream);
            String password = prop.getProperty("password");
            decode(password);
            prop.put("password", password);
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
            Log.error(e);
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, prop);
    }

    private static void decode(String password) {
        // 炫个技，用反射修改String（不可变）类的内容(会报Warning)
        try {
            // 通过反射，将String中定义为private final byte[] value;的数组内容进行修改
            Field value = password.getClass().getDeclaredField("value");
            value.setAccessible(true);
            byte[] ch = (byte[])value.get(password);
            for (int i = 0; i < ch.length; i++) {
                // 学号中未涉及异常情况，所以直接修改
                ch[i] --;
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }
}
