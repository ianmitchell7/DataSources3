package datasourcespkg.domain;

public class PortalSource {

private Long portalSourceId;
private Long portalId;
private Long dataSourceId;

    public PortalSource() {
    }

    public PortalSource(Long portalSourceId, Long portalId, Long dataSourceId) {
        this.portalSourceId = portalSourceId;
        this.portalId = portalId;
        this.dataSourceId = dataSourceId;
    }

    public Long getPortalSourceId() {
        return portalSourceId;
    }

    public void setPortalSourceId(Long portalSourceId) {
        this.portalSourceId = portalSourceId;
    }

    public Long getPortalId() {
        return portalId;
    }

    public void setPortalId(Long portalId) {
        this.portalId = portalId;
    }

    public Long getDataSourceId() {
        return dataSourceId;
    }

    public void setDataSourceId(Long dataSourceId) {
        this.dataSourceId = dataSourceId;
    }

    @Override
    public String toString() {
        return "PortalSource{" +
                  "portalId="    + portalId + ", " +
                  "dataSourceId=" + dataSourceId +
                "}";
    }
}
