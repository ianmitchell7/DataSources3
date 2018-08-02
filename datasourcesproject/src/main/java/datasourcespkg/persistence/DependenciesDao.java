package datasourcespkg.persistence;

import datasourcespkg.domain.Dependencies;
import java.util.List;

public interface DependenciesDao {

    List<Dependencies> getAllDependenciesForDataSource(Long dataSourceId);
 //   List<Dependencies> getAllDependentForForDataSource(Long dataSourceId);
    // add
    // delete

}