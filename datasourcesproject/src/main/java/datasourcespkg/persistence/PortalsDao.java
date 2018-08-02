package datasourcespkg.persistence;

import datasourcespkg.domain.DataSource;
import datasourcespkg.domain.Portal;

import java.util.List;

public interface PortalsDao {

    List<Portal> getAllPortals();
    Portal getPortalById(Long id);
    List<DataSource> getDataSourcesForPortal(Long id);
    Portal addPortal(Portal portal);
    void deletePortal(Long id);
    Portal updatePortal(Portal portal);

}
