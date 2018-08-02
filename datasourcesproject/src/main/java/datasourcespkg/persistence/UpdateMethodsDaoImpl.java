package datasourcespkg.persistence;

import datasourcespkg.domain.UpdateMethods;
import datasourcespkg.utils.DBConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

public class UpdateMethodsDaoImpl implements UpdateMethodsDao {

    private static final Logger logger = LoggerFactory.getLogger(UpdateMethodsDao.class);

    @Override
    public List<UpdateMethods> getAllUpdateMethods() {
        Sql2o sql2o = DBConnection.getDb();
        String sql = "SELECT * FROM UpdateMethods ORDER BY updateMethodId ASC ";
        System.out.println("getAllUpdateMethods sql=" + sql);
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(UpdateMethods.class);
        }
    }

    @Override
    public UpdateMethods getUpdateMethodById(Long id) {
        Sql2o sql2o = DBConnection.getDb();
        String sql = "SELECT * FROM UpdateMethods " +
                "WHERE updateMethodId = :id";
        System.out.println("getUpdateMeyhodById sql=" + sql);
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(UpdateMethods.class);
        }
    }
}


//  ADD



// DELETE
