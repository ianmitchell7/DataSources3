package datasourcespkg.persistence;

import datasourcespkg.domain.DataSource;
import datasourcespkg.domain.Portal;
import datasourcespkg.domain.PortalSource;
import datasourcespkg.utils.DBConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.util.List;

public class PortalSourcesDaoImpl implements PortalSourcesDao {
    private static final Logger logger = LoggerFactory.getLogger(DataSourcesDaoImpl.class);

    @Override
    public List<PortalSource> getPortalSourcesByPortal(Long portalId) {
        // GET all PortalSources for 1 portal id
        Sql2o sql2o = DBConnection.getDb();
        String sql = "SELECT PortalSources.portalSourceId, PortalSources.portalId, PortalSources.dataSourceId " +
                     "FROM PortalSources " +
                     "INNER JOIN DataSources ON PortalSources.dataSourceId=DataSources.dataSourceId " +
                     "WHERE portalId = " + portalId + " " +
                     "ORDER BY DataSources.dataSourceName ASC ";
        System.out.println("getPortalSourcesByPortal sql1=" + sql) ;
        try(Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(PortalSource.class);
        }
    }



    @Override
    public List<PortalSource> getPortalSourcesByDataSource(Long dataSourceId) {
        // GET all PortalSources for 1 data source id
        Sql2o sql2o = DBConnection.getDb();
        String sql = "SELECT * " +
                "FROM PortalSources " +
                "WHERE dataSourceId = :dataSourceId";
        System.out.println("getPortalSourcesByDataSource sqlX=" + sql) ;
        try(Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("dataSourceId", dataSourceId)
                    .executeAndFetch(PortalSource.class);
        }
    }

    @Override
    public List<PortalSource> getPortalsForParent(Long parentId) {
        /*   get all portals for a specific parent source -- no need to order by... */
        Sql2o sql2o = DBConnection.getDb();
        String sql = "SELECT PortalSources.portalSourceId, PortalSources.portalId, PortalSources.dataSourceId " +
                "FROM   DataSources " +
                "INNER JOIN PortalSources ON DataSources.dataSourceId=PortalSources.dataSourceId " +
                "WHERE DataSources.parentId = :parentId ";
        System.out.println("getPortalSourcesByDataSource ABCsql =" + sql) ;

        try(Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("parentId", parentId)
                    .executeAndFetch(PortalSource.class);
        }
    }

    @Override
    public PortalSource addPortalSource(PortalSource portalSource) {

        logger.info(portalSource.toString());
        // INSERT a new PortalSources
        Sql2o sql2o = DBConnection.getDb();
        String sql = "INSERT into PortalSources(portalId, dataSourceId) " +
                     "VALUES (:portalId, :dataSourceId)";
        System.out.println("addPortalSource sql= " + sql);
        try(Connection con = sql2o.open()) {
            Long key = (Long)con.createQuery(sql)
                    .bind(portalSource)
                    .executeUpdate()
                    .getKey();
            portalSource.setPortalSourceId(key);
            return portalSource;
        }
    }

    @Override
    public void deletePortalSourceByPortal(Long portalId) {
        // DELETE all PortalSources for 1 particular Portal
        Sql2o sql2o = DBConnection.getDb();
        String sql = "DELETE FROM PortalSources " +
                     "WHERE portalId = :portalId";
        System.out.println("sql = " + sql);

        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("portalId", portalId)
                    .executeUpdate();
        }
    }

    @Override
    public void deletePortalSourceByDataSource(Long dataSourceId) {
        // DELETE all PortalSources for 1 particular Data Source
        Sql2o sql2o = DBConnection.getDb();
        String sql = "DELETE FROM PortalSources " +
                     "WHERE dataSourceId = :dataSourceId";
        System.out.println("sql = " + sql);

        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("dataSourceId", dataSourceId)
                    .executeUpdate();
        }
    }

    @Override
    public void deletePortalSourceByDataSourceByPortal(Long dataSourceId, Long portalId) {
        // DELETE all PortalSources for 1 particular "Data Source x Portal"
        Sql2o sql2o = DBConnection.getDb();
        String sql = "DELETE FROM PortalSources " +
                "WHERE dataSourceId = :dataSourceId AND portalId = :portalId";
        System.out.println("deletePortalSourceByDataSourceByPortal sql = " + sql);

        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("dataSourceId", dataSourceId)
                    .addParameter("portalId", portalId)
                    .executeUpdate();
        }
    }

    @Override
    public PortalSource updatePortalSource(PortalSource portalSource, Long portalSourceId) {
        Sql2o sql2o = DBConnection.getDb();
        String sql = "UPDATE PortalSources " +
                     "SET portalId = :portalId " +
                     "WHERE portalSourceId = :portalSourceId";
        System.out.println("sql = " + sql);
        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .bind(portalSource)
                    .executeUpdate();
            return portalSource;
        }
    }

}
