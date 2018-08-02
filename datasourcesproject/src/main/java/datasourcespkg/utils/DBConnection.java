package datasourcespkg.utils;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.sql2o.Sql2o;
import org.sql2o.logging.SysOutLogger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBConnection {

    private static Sql2o sql2o;

    public static Sql2o getDb() {
        if (sql2o == null) {
            connect();
        }
        return sql2o;
    }

    private static void connect() {
        try(InputStream resourceAsStream = DBConnection.class.getResourceAsStream("/hikari.properties")) {
            Properties properties = new Properties();
            properties.load(resourceAsStream);
            HikariConfig config = new HikariConfig(properties);
            HikariDataSource hs = new HikariDataSource(config);
            sql2o = new Sql2o(hs);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
