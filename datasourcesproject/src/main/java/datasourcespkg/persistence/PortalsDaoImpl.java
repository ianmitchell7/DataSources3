package datasourcespkg.persistence;

import datasourcespkg.domain.Portal;
import datasourcespkg.domain.PortalSource;
import datasourcespkg.domain.DataSource;
import datasourcespkg.utils.DBConnection;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import javax.sound.sampled.Port;
import java.util.List;

public class PortalsDaoImpl implements PortalsDao {

    @Override
    public List<Portal> getAllPortals() {
        Sql2o sql2o = DBConnection.getDb();
        String sql = "SELECT * FROM Portals " +
                     "ORDER BY portalName ASC ";
        try(Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(Portal.class);
        }
    }

    @Override
    public Portal getPortalById(Long id) {
        Sql2o sql2o = DBConnection.getDb();
        String sql = "SELECT * FROM Portals " +
                     "WHERE portalId = :id";

        try(Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Portal.class);
        }
    }

    @Override
    public List<DataSource> getDataSourcesForPortal(Long id) {
        // get all data sources for 1 portal
        Sql2o sql2o = DBConnection.getDb();
        String sql = "SELECT DataSources.dataSourceId, " +
                            "DataSources.dataSourceName, " +
                            "DataSources.url, " +
                            "DataSources.sourceType, " +
                            "DataSources.updateInterval, " +
                            "DataSources.updateMethod, " +
                            "DataSources.nextUpdateEarliest, " +
                            "DataSources.nextUpdateLatest, " +
                            "DataSources.comments, " +
                            "DataSources.parentId, " +
                            "DataSources.ewControllerId, " +
                            "DataSources.wacheteUrl " +
                     "FROM PortalSources " +
                     "INNER JOIN DataSources ON PortalSources.dataSourceId=DataSources.dataSourceId " +
                     "WHERE portalId = :id AND (DataSources.deactivated = '' OR DataSources.deactivated IS NULL) "  +
                     "ORDER BY DataSources.nextUpdateLatest ";
System.out.println("getDataSourcesForPortal hhsql=" + sql);
        try(Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetch(DataSource.class);
        }
    }

    @Override
    public Portal addPortal(Portal portal) {
        Sql2o sql2o = DBConnection.getDb();
        String sql = "INSERT into Portals(portalName, url, ewControllerPortal) " +
                     "VALUES (:portalName, :url, :ewControllerPortal)";
        System.out.println("addPortal hhsql=" + sql);

        try(Connection con = sql2o.open()) {
            Long key = (Long)con.createQuery(sql)
                    .bind(portal)
                    .executeUpdate()
                    .getKey();
            portal.setPortalId(key);
            return portal;
        }
    }

    @Override
    public void deletePortal(Long portalId) {
        Sql2o sql2o = DBConnection.getDb();
        String sql = "DELETE FROM Portals " +
                     "WHERE portalId = :portalId";
        System.out.println("PORTAL DELETE sql = " + sql);
        System.out.println(" JAVA PORTAL DELETE = ");

        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                .addParameter("portalId", portalId)
                .executeUpdate();
        }
    }

    @Override
    public Portal updatePortal(Portal portal) {
        Sql2o sql2o = DBConnection.getDb();
        String sql = "UPDATE Portals " +
                     "SET portalName = :portalName, url = :url, ewControllerPortal = :ewControllerPortal " +
                     "WHERE portalId = :portalId";
        System.out.println("updatePortal hhsql=" + sql);
        try(Connection con = sql2o.open()) {
              con.createQuery(sql)
                    .bind(portal)
                    .executeUpdate();
            return portal;
        }
    }

}
