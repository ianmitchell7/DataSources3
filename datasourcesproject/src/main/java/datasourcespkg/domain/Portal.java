package datasourcespkg.domain;

public class Portal {

    private Long portalId;
    private String portalName;
    private String url;
    private String ewControllerPortal;

    public Portal() {
    }

    public Portal(Long portalId, String portalName, String url) {
        this.portalId = portalId;
        this.portalName = portalName;
        this.url = url;
        this.ewControllerPortal = ewControllerPortal;
    }

    public Long getPortalId() {
        return portalId;
    }

    public void setPortalId(Long portalId) {this.portalId = portalId;}

    public String getPortalName() {return portalName;}

    public void setPortalName(String portalName) {
        this.portalName = portalName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEwControllerPortal() {
        return ewControllerPortal;
    }

    public void setEwControllerPortal(String ewControllerPortal) {
        this.ewControllerPortal = ewControllerPortal;
    }

    @Override
    public String toString() {
        return "Portal{" +
                "portalId="      + portalId +
                ", portalName='" + portalName + '\'' +
                ", url='"        + url + '\'' +
                ", ewControllerPortal='" + ewControllerPortal + '\'' +
                '}';
    }
}
