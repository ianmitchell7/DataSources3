package datasourcespkg.persistence;

import datasourcespkg.domain.DataSource;
import datasourcespkg.domain.ParentSource;

import java.util.List;

public interface ParentSourcesDao {

    List<ParentSource> getAllParentSources();
    ParentSource getParentSourceById(Long id);
    List<DataSource> getDataSourcesForParent(Long id);
    ParentSource addParentSource(ParentSource parentSource);
    void deleteParentSource(Long id);
    ParentSource updateParentSource(ParentSource parentSource);
}
