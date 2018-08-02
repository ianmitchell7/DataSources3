package datasourcespkg.persistence;

import datasourcespkg.domain.UpdateIntervals;
import java.util.List;

public interface UpdateIntervalsDao {

    List<UpdateIntervals> getAllUpdateIntervals();
    UpdateIntervals getUpdateIntervalById(Long id);

}
