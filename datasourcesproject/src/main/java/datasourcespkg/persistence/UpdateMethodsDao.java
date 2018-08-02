package datasourcespkg.persistence;

import datasourcespkg.domain.UpdateMethods;
import java.util.List;

public interface UpdateMethodsDao {

    List<UpdateMethods> getAllUpdateMethods();
    UpdateMethods getUpdateMethodById(Long id);

}
