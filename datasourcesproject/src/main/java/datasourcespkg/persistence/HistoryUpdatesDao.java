package datasourcespkg.persistence;

import datasourcespkg.domain.HistoryUpdates;
import java.util.List;

public interface HistoryUpdatesDao {

    List<HistoryUpdates> getHistoryUpdatesForDataSource(Long dataSourceId);
    List<HistoryUpdates> getAllCurrentHistoryUpdates();
    HistoryUpdates getHistoryUpdatesCurrent(Long id);
    HistoryUpdates addHistoryUpdates(HistoryUpdates historyUpdates);


/*
//    List<DataSource> getAllDataSources();
//    DataSource getDataSourceById(Long id);
//    List<Portal> getPortalsForDataSource(Long id);
//    DataSource addDataSource(DataSource dataSource);
//    List<DataSource> getDataSourcesForPortal(Long portalId);
//    void deleteDataSource(Long id);
//    DataSource updateDataSource(DataSource dataSource);
*/


}