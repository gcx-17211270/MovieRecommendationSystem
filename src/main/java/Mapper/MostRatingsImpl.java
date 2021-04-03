package Mapper;

import Controller.MostRatingsController;
import org.apache.log4j.Logger;

import javax.servlet.ServletOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MostRatingsImpl implements MostRatingsDao {
    Logger Log = Logger.getLogger(MostRatingsImpl.class);
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    @Override
    public ResultSet getResult() {

        //从ratings表中，得出被评分最多的8部电影，作为最多观看(MySQL练习
        String sql =
                "SELECT  m.title, m.genres, COUNT(*) AS rated " +
                        "FROM ratings r " +
                        "JOIN movies m " +
                        "WHERE r.movieId = m.movieId " +
                        "GROUP BY r.movieId " +
                        "ORDER BY rated DESC " +
                        "LIMIT 10; ";

        try {
            conn = ConnMySQL.connectMovieData("movies_data2");
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            return rs;
        }
        catch (SQLException sqlex){
            Log.error(sqlex);
        }
        catch (Exception ex) {
            Log.error(ex);
        }
        return null;
    }

    public void finish()  {
        try {
            rs.close();
            stmt.close();
            conn.close();
        }
        catch (SQLException ex) {
            Log.error(ex);
        }
    }
}
