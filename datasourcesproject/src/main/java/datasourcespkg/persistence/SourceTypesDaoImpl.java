package datasourcespkg.persistence;

        import datasourcespkg.domain.SourceTypes;
        import datasourcespkg.utils.DBConnection;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.sql2o.Connection;
        import org.sql2o.Sql2o;
        import java.util.List;

public class SourceTypesDaoImpl implements SourceTypesDao {

    private static final Logger logger = LoggerFactory.getLogger(UpdateIntervalsDao.class);

    @Override
    public List<SourceTypes> getAllSourceTypes() {
        Sql2o sql2o = DBConnection.getDb();
        String sql = "SELECT * FROM SourceTypes ORDER BY sourceTypeName ASC ";
        System.out.println("getAllSourceTypes sql=" + sql);
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(SourceTypes.class);
        }
    }

    @Override
    public SourceTypes getSourceTypeById(Long id) {
        Sql2o sql2o = DBConnection.getDb();
        String sql = "SELECT * FROM SourceTypes " +
                     "WHERE sourceTypeId = :id";
        System.out.println("getUpdateIntervalById sql=" + sql);
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(SourceTypes.class);
        }
    }
}

//  ADD



// DELETE
