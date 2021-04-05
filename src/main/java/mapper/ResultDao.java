package mapper;

import POJO.result;

import java.sql.ResultSet;

/**
 * 类           ResultDao
 * 类的作用:    定义获取result对象的方法
 * Description:
 * @Date:       2021/4/6 4:33
 * @author:     32353
 * @version     V1.0.0
*/

public interface ResultDao {
    public ResultSet getResultByName(String algorithmName);
}
