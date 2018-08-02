package datasourcespkg.persistence;

import datasourcespkg.domain.DataSource;
import datasourcespkg.domain.HistoryUpdates;
import datasourcespkg.utils.DBConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class HistoryUpdatesDaoImpl implements HistoryUpdatesDao {
    private static final Logger logger = LoggerFactory.getLogger(HistoryUpdatesDaoImpl.class);

    @Override
    public List<HistoryUpdates> getHistoryUpdatesForDataSource(Long dataSourceId) {
        Sql2o sql2o = DBConnection.getDb();
        String sql = "SELECT * FROM HistoryUpdates " +
                     "WHERE dataSourceId = :dataSourceId " +
                     "ORDER BY updateReceived ASC ";
        System.out.println("getDataSourceById sql=" + sql);
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("dataSourceId", dataSourceId)
                    .executeAndFetch(HistoryUpdates.class);
        }
    }

    @Override
    public HistoryUpdates getHistoryUpdatesCurrent(Long dataSourceId) {
        // get most recent update for 1 data source
        Sql2o sql2o = DBConnection.getDb();
/*
        String sql = "SELECT TOP (1) * FROM HistoryUpdates " +
                     "WHERE dataSourceId = :dataSourceId " +
                     "ORDER BY updateReceived DESC ";
*/
        String sql = "SELECT * FROM HistoryUpdates " +
                "WHERE dataSourceId = :dataSourceId " +
                "ORDER BY updateReceived DESC " +
                "LIMIT 1";
        System.out.println("getHistoryUpdatesCurrent sql=" + sql);

//        select * from historyupdates where historyupdatesid in (
//        select max(historyupdatesid) from historyupdates group by datasourceid)

        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("dataSourceId", dataSourceId)
                    .executeAndFetchFirst(HistoryUpdates.class);
        }
    }

    @Override
    public HistoryUpdates addHistoryUpdates(HistoryUpdates historyUpdates) {
        // insert new HistoryUpdates item
        Sql2o sql2o = DBConnection.getDb();
        String sql = "INSERT into HistoryUpdates(dataSourceId, nextUpdateDue, updateReceived, updateTransferredToMaster, updateProcessed, updateComments) " +
                     "VALUES (:dataSourceId, :nextUpdateDue, :updateReceived, :updateTransferredToMaster, :updateProcessed, :updateComments)";
        System.out.println("addHistoryUpdates sql=" + sql);

        try (Connection con = sql2o.open()) {
            Long key = (Long)con.createQuery(sql)
                         .bind(historyUpdates)
                         .executeUpdate()
                         .getKey();
            historyUpdates.setHistoryUpdatesId(key);
            return historyUpdates;
        }
    }

    @Override
    public List<HistoryUpdates> getAllCurrentHistoryUpdates() {
        Sql2o sql2o = DBConnection.getDb();
        String sql = "SELECT * from historyupdates where historyupdatesid in " +
                           "(SELECT max(historyupdatesid) from historyupdates group by datasourceid) ";
        System.out.println("getDataSourceById sql=" + sql);
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(HistoryUpdates.class);
        }
    }
}