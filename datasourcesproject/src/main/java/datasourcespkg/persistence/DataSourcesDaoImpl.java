package datasourcespkg.persistence;

import datasourcespkg.domain.DataSource;
import datasourcespkg.domain.Portal;
import datasourcespkg.utils.DBConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.util.List;

public class DataSourcesDaoImpl implements DataSourcesDao {
    private static final Logger logger = LoggerFactory.getLogger(DataSourcesDaoImpl.class);

    @Override
    public List<DataSource> getAllDataSources() {
        Sql2o sql2o = DBConnection.getDb();
        String sql = "SELECT * FROM DataSources " +
                     "WHERE deactivated IS NULL OR deactivated = '' " +
                     "ORDER BY nextUpdateLatest ASC, dataSourcename ASC ";
        System.out.println("getDataSourceById sql=" + sql) ;
        try(Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(DataSource.class);
        }
    }

    @Override
    public List<DataSource> getAllDeactivatedDataSources() {
        Sql2o sql2o = DBConnection.getDb();
        String sql = "SELECT * FROM DataSources " +
                    "WHERE deactivated <> '' AND deactivated IS NOT NULL " +
               //  "WHERE deactivated <> '' AND deactivated IS NOT NULL" +
                "ORDER BY dataSourcename ASC ";
        System.out.println("getDataSourceById sql=" + sql) ;
        try(Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(DataSource.class);
        }
    }

    @Override
    public DataSource getDataSourceById(Long id) {
        Sql2o sql2o = DBConnection.getDb();
             String sql = "SELECT * " +
                          "FROM DataSources " +
                          "WHERE dataSourceId = :id " ;
        System.out.println("getDataSourceById sql=" + sql) ;
        try(Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(DataSource.class);
        }
    }

    @Override
    public List<Portal> getPortalsForDataSource(Long dataSourceId) {
        /* get all portals for 1 data source      */
        Sql2o sql2o = DBConnection.getDb();
        String sql = "SELECT Portals.portalId, " +
                            "Portals.portalName, " +
                            "Portals.url, " +
                            "Portals.ewControllerPortal " +
                     "FROM PortalSources " +
                     "INNER JOIN Portals ON PortalSources.portalId=Portals.portalId " +
                     "WHERE PortalSources.dataSourceId = :dataSourceId ";
        System.out.println("getPortalsForDataSource sql = " + sql);
        try(Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("dataSourceId", dataSourceId)
                    .executeAndFetch(Portal.class);
        }
    }

    @Override
    public List<DataSource> getDataSourcesForPortal(Long portalId) {
        /* get all Data Sources for 1 Portal      */
        Sql2o sql2o = DBConnection.getDb();
        String sql = "SELECT  DataSources.dataSourceId, DataSources.dataSourceName, DataSources.url, DataSources.sourceType, DataSources.updateInterval, DataSources.nextUpdateEarliest, DataSources.nextUpdateLatest, DataSources.latestUpdate, DataSources.transferredToMaster, DataSources.comments, DataSources.parentId, DataSources.updateMethod, DataSources.processedUpdate, DataSources.commentsUpdate, DataSources.dependancyBrotherId, DataSources.dependancySisterId, DataSources.deactivated, DataSources.ewController, DataSources.wacheteUrl " +
                     "FROM PortalSources " +
                     "INNER JOIN DataSources ON PortalSources.dataSourceId=DataSources.dataSourceId " +
        //             "WHERE PortalSources.portalId = :portalId AND deactivated = '' ";
            "WHERE PortalSources.portalId = :portalId AND (deactivated = '' OR deactivated IS NULL) ";
        System.out.println("getDataSourcesForPortal sql = " + sql);
        try(Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("portalId", portalId)
                    .executeAndFetch(DataSource.class);
        }
    }

    @Override
    public DataSource addDataSource(DataSource dataSource) {
        // create new Data Sources item
        logger.info(dataSource.toString());

        Sql2o sql2o = DBConnection.getDb();
        String sql = "INSERT into DataSources(dataSourceName, url, sourceType, updateInterval, nextUpdateEarliest, nextUpdateLatest, latestUpdate, transferredToMaster, processedUpdate, comments, parentId, updateMethod, ewControllerId, wacheteUrl) " +
                     "VALUES (:dataSourceName, :url, :sourceType, :updateInterval, :nextUpdateEarliest, :nextUpdateLatest, :latestUpdate, :transferredToMaster, :processedUpdate, :comments, :parentId, :updateMethod, :ewControllerId, :wacheteUrl)";
        System.out.println("sql = " + sql);
        try(Connection con = sql2o.open()) {
            Long key = (Long)con.createQuery(sql)
                    .bind(dataSource)
                    .executeUpdate()
                    .getKey(Long.class);
            dataSource.setDataSourceId(key);
            return dataSource;
        }
    }

    @Override
    public void deleteDataSource(Long id) {
        Sql2o sql2o = DBConnection.getDb();
        String sql = "DELETE FROM DataSources " +
                     "WHERE dataSourceId = :dataSourceId";
        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("dataSourceId", id)
                    .executeUpdate();
        }
    }

    @Override
    public DataSource updateDataSource(DataSource dataSource) {
        Sql2o sql2o = DBConnection.getDb();
        String sql = "UPDATE DataSources " +
                "SET dataSourceName = :dataSourceName, url = :url, sourceType = :sourceType, updateInterval = :updateInterval, nextUpdateLatest = :nextUpdateLatest, " +
                      "latestUpdate = :latestUpdate, transferredToMaster = :transferredToMaster, comments = :comments, parentId = :parentId, " +
                      "updateMethod = :updateMethod, processedUpdate = :processedUpdate, commentsUpdate = :commentsUpdate, dependancyBrotherId = :dependancyBrotherId, " +
                      "dependancySisterId = :dependancySisterId, deactivated = :deactivated, ewControllerId = :ewControllerId, wacheteUrl = :wacheteUrl " +
                "WHERE dataSourceId = :dataSourceId";
        System.out.printf("SET sql = " + sql);
        //System.out.printf("dataSource = " + dataSource);
        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .bind(dataSource)
                    .executeUpdate();
            return dataSource;
        }
    }

    @Override
    public void activateDataSource(Long id) {
        Sql2o sql2o = DBConnection.getDb();
        String emptyString = "";
        String sql = "UPDATE DataSources SET deactivated = '' WHERE dataSourceId = :id";
        System.out.println("activateDataSource deactivated -- sql = " + sql);
        System.out.println("     The value of id = " + id + "    ");
        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }
        catch(Exception e) {
            System.out.printf(e.getMessage());
        }
    }
}

