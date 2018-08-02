package datasourcespkg.persistence;

import datasourcespkg.domain.DataSource;
import datasourcespkg.domain.ParentSource;
import datasourcespkg.utils.DBConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class ParentSourcesDaoImpl implements ParentSourcesDao {

    private static final Logger logger = LoggerFactory.getLogger(ParentSourcesDaoImpl.class);

    @Override
    public List<ParentSource> getAllParentSources() {
        Sql2o sql2o = DBConnection.getDb();
        String sql = "SELECT * FROM ParentSources " +
                     "ORDER BY parentSourceName ASC ";
        System.out.println("sql = " + sql);

        System.out.println("sql = " + sql);
        try(Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(ParentSource.class);
        }
    }

    @Override
    public ParentSource getParentSourceById(Long parentSourceId) {
        Sql2o sql2o = DBConnection.getDb();
        String sql = "SELECT * FROM ParentSources " +
                "WHERE parentSourceId = :parentSourceId " +
                "ORDER BY parentSourceName ";
        System.out.println("sql = " + sql);

        try(Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("parentSourceId", parentSourceId)
                    .executeAndFetchFirst(ParentSource.class);
        }
    }

    @Override
    public List<DataSource> getDataSourcesForParent(Long parentId) {
        /* get all data sources for a parent */
        Sql2o sql2o = DBConnection.getDb();
        String sql = "SELECT * FROM DataSources " +
      //          "WHERE parentId = :parentId " +
                "WHERE parentId = :parentId AND (deactivated = '' OR deactivated is null) " +
                "ORDER BY nextUpdateLatest ASC, dataSourceName ";;
        System.out.println("sql = " + sql);

        try(Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("parentId", parentId)
                    .executeAndFetch(DataSource.class);
        }
    }

    @Override
    public ParentSource addParentSource(ParentSource parentSource) {

        logger.info(parentSource.toString());

        Sql2o sql2o = DBConnection.getDb();
        String sql = "INSERT into ParentSources(parentSourceName, url) " +
                     "VALUES (:parentSourceName, :url)";
        System.out.println("sql = " + sql);

        try(Connection con = sql2o.open()) {
            Long key = (Long)con.createQuery(sql)
                    .bind(parentSource)
                    .executeUpdate()
                    .getKey();
            parentSource.setParentSourceId(key);
            return parentSource;
        }
    }

    @Override
    public void deleteParentSource(Long parentSourceId) {
        Sql2o sql2o = DBConnection.getDb();
        String sql = "DELETE FROM ParentSources " +
                     "WHERE parentSourceId = :parentSourceId ";
        System.out.println("sql = " + sql);

        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("parentSourceId", parentSourceId)
                    .executeUpdate();
        }
    }

    @Override
    public ParentSource updateParentSource(ParentSource parentSource) {
        Sql2o sql2o = DBConnection.getDb();
        String sql = "UPDATE ParentSources " +
                     "SET parentSourceName = :parentSourceName, url = :url " +
                     "WHERE parentSourceId = :parentSourceId";
        System.out.println("sql = " + sql);
        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .bind(parentSource)
                    .executeUpdate();
            return parentSource;
        }
    }
}
