package datasourcespkg.persistence;

import datasourcespkg.domain.Dependencies;
import datasourcespkg.domain.DataSource;
import datasourcespkg.utils.DBConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.List;

public class DependenciesDaoImpl implements DependenciesDao {
    private static final Logger logger = LoggerFactory.getLogger(DependenciesDaoImpl.class);

    @Override
    public List<Dependencies> getAllDependenciesForDataSource(Long dataSourceId) {
        Sql2o sql2o = DBConnection.getDb();
        String sql = "SELECT Dependencies.dependentOnDataSourceId, Dependencies.dependentForDataSourceId FROM Dependencies " +
                     "INNER JOIN DataSources ON DataSources.dataSourceId=Dependencies.dataSourceId " +
                     "WHERE Dependencies.dataSourceId = :dataSourceId " +
                     "ORDER BY DataSources.dataSourceName ASC ";
        System.out.println("getAllDependenciesForDataSource sql=" + sql);
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("dataSourceId", dataSourceId)
                    .executeAndFetch(Dependencies.class);
        }
    }
}

 //  ADD



// DELETE


