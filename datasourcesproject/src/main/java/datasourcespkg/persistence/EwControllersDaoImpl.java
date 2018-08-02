package datasourcespkg.persistence;

import datasourcespkg.domain.EwControllers;
import datasourcespkg.domain.DataSource;
import datasourcespkg.utils.DBConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

public class EwControllersDaoImpl implements EwControllersDao {
    private static final Logger logger = LoggerFactory.getLogger(EwControllersDaoImpl.class);

    @Override
    public List<EwControllers> getAllEwControllers() {
        Sql2o sql2o = DBConnection.getDb();
        String sql = "SELECT * FROM EwControllers ORDER BY ewControllerName ASC ";
        System.out.println("getAllEwControllers sql=" + sql);
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(EwControllers.class);
        }
    }

    @Override
    public EwControllers getEwControllerById(Long id) {
        Sql2o sql2o = DBConnection.getDb();
        String sql = "SELECT * FROM EwControllers " +
                "WHERE ewControllerId = :id";
        System.out.println("getEwControllerById sql=" + sql);
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(EwControllers.class);
        }
    }
}

//  ADD



// DELETE
