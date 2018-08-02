package datasourcespkg.persistence;

import datasourcespkg.domain.DataSource;
import datasourcespkg.domain.Portal;

import java.util.List;

public interface DataSourcesDao {

    List<DataSource> getAllDataSources();
    List<DataSource> getAllDeactivatedDataSources();
    DataSource getDataSourceById(Long id);
    List<Portal> getPortalsForDataSource(Long id);
    DataSource addDataSource(DataSource dataSource);
    List<DataSource> getDataSourcesForPortal(Long portalId);
    void deleteDataSource(Long id);
    DataSource updateDataSource(DataSource dataSource);
    void activateDataSource(Long id);
}