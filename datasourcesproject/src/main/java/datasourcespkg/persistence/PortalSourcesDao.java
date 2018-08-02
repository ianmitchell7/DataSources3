package datasourcespkg.persistence;

import datasourcespkg.domain.DataSource;
import datasourcespkg.domain.PortalSource;

import java.util.List;

public interface PortalSourcesDao {

      List<PortalSource> getPortalSourcesByDataSource(Long dataSourceId);
      List<PortalSource> getPortalSourcesByPortal(Long portalId);
      List<PortalSource> getPortalsForParent(Long parentId);
//    Portal getPortalById(Long id);
//    List<DataSource> getDataSourcesForPortal(Long id);

      PortalSource addPortalSource(PortalSource portalSource);
      void deletePortalSourceByPortal(Long portalId);
      void deletePortalSourceByDataSource(Long dataSourceId);
      void deletePortalSourceByDataSourceByPortal(Long dataSourceId, Long portalId);
      PortalSource updatePortalSource(PortalSource portalSource, Long portalSourceId);

}
