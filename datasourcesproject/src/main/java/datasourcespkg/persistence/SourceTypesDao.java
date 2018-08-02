package datasourcespkg.persistence;

import datasourcespkg.domain.SourceTypes;
import java.util.List;

public interface SourceTypesDao {

    List<SourceTypes> getAllSourceTypes();
    SourceTypes getSourceTypeById(Long sourceTypeId);

}