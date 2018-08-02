package datasourcespkg.persistence;

import datasourcespkg.domain.EwControllers;
import java.util.List;

public interface EwControllersDao {

    List<EwControllers> getAllEwControllers();
    EwControllers getEwControllerById(Long id);

}
