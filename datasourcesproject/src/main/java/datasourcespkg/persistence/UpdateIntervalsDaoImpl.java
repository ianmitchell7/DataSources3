package datasourcespkg.persistence;

import datasourcespkg.domain.UpdateIntervals;
import datasourcespkg.utils.DBConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

public class UpdateIntervalsDaoImpl implements UpdateIntervalsDao {

    private static final Logger logger = LoggerFactory.getLogger(UpdateIntervalsDao.class);

    @Override
    public List<UpdateIntervals> getAllUpdateIntervals() {
        Sql2o sql2o = DBConnection.getDb();
        String sql = "SELECT * FROM UpdateIntervals ORDER BY updateIntervalDaysIncrement ASC ";
        System.out.println("getAllUpdateIntervals sql=" + sql);
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(UpdateIntervals.class);
        }
    }

    @Override
    public UpdateIntervals getUpdateIntervalById(Long id) {
        Sql2o sql2o = DBConnection.getDb();
        String sql = "SELECT * FROM UpdateIntervals " +
                "WHERE updateIntervalId = :id";
        System.out.println("getUpdateIntervalById sql=" + sql);
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(UpdateIntervals.class);
        }
    }
}

//  ADD



// DELETE
