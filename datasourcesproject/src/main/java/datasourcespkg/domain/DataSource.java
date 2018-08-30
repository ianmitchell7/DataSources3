package datasourcespkg.domain;

public class DataSource {

    private Long dataSourceId;
    private String dataSourceName;
    private String url;
    private int sourceType;
    private int updateInterval;
    private int updateMethod;
    private String nextUpdateEarliest;
    private String nextUpdateLatest;
    private String latestUpdate;
    private String transferredToMaster;
    private String comments;
    private Long   parentId;
    private String processedUpdate;
    private String commentsUpdate;
    private Integer dependancyBrotherId = null;
    private Integer dependancySisterId = null;
    private Integer deactivated = null;
    private String ewControllerId;
    private String wacheteUrl;


    public DataSource() {
    }

    public DataSource(Long dataSourceId, String dataSourceName, String url, int sourceType, int updateInterval, String nextUpdate, String transferredToMaster, String comments, Long parentId, int updateMethod, String processedUpdate, String commentsUpdate, Integer dependancyBrotherId, Integer dependancySisterId, Integer deactivated, String ewControllerId, String wacheteUrl) {
        this.dataSourceId        = dataSourceId;
        this.dataSourceName      = dataSourceName;
        this.url                 = url;
        this.sourceType          = sourceType;
        this.updateInterval      = updateInterval;
        this.updateMethod        = updateMethod;
        this.nextUpdateEarliest  = nextUpdateEarliest;
        this.nextUpdateLatest    = nextUpdateLatest;
        this.latestUpdate        = latestUpdate;
        this.latestUpdate        = transferredToMaster;
        this.comments            = comments;
        this.parentId            = parentId;
        this.processedUpdate     = processedUpdate;
        this.commentsUpdate      = commentsUpdate;
        this.dependancyBrotherId = dependancyBrotherId;
        this.dependancySisterId  = dependancySisterId;
        this.deactivated         = deactivated;
        this.ewControllerId      = ewControllerId;
        this.wacheteUrl          = wacheteUrl;
    }

    public Long getDataSourceId() {
        return dataSourceId;
    }

    public String getDataSourceName() {
        return dataSourceName;
    }

    public String getUrl() {
        return url;
    }

    public int getSourceType() {
        return sourceType;
    }

    public int getUpdateInterval() {
        return updateInterval;
    }

    public int getUpdateMethod() {
        return updateMethod;
    }

    public String getNextUpdateEarliest() {
        return nextUpdateEarliest;
    }

    public String getLatestUpdate() {
        return latestUpdate;
    }

    public String getTransferredToMaster() {
        return transferredToMaster;
    }

    public String getNextUpdateLatest() {
        return nextUpdateLatest;
    }

    public String getComments() {
        return comments;
    }

    public Long getParentId() {
        return parentId;
    }

    public String getProcessedUpdate() { return processedUpdate; }

    public String getCommentsUpdate() {
        return commentsUpdate;
    }

    public Integer getDependancyBrotherId() {
        return dependancyBrotherId;
    }

    public Integer getDependancySisterId() {
        return dependancySisterId;
    }

    public Integer getDeactivated() {
        return deactivated;
    }

    public String getEwControllerId() {
        return ewControllerId;
    }

    public String getWacheteUrl() {
        return wacheteUrl;
    }


    public void setDataSourceId(Long dataSourceId) {
        this.dataSourceId = dataSourceId;
    }

    public void setDataSourceName(String dataSourceName) {
        this.dataSourceName = dataSourceName;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setSourceType(int sourceType) {
        this.sourceType = sourceType;
    }

    public void setUpdateInterval(int updateInterval) {
        this.updateInterval = updateInterval;
    }

    public void setUpdateMethod(int updateMethod) {
        this.updateMethod = updateMethod;
    }

    public void setNextUpdateEarliest(String nextUpdateEarliest) {
        this.nextUpdateEarliest = nextUpdateEarliest;
    }

    public void setNextUpdateLatest(String nextUpdateLatest) {
        this.nextUpdateLatest = nextUpdateLatest;
    }

    public void setLatestUpdate(String latestUpdate) {
        this.latestUpdate = latestUpdate;
    }

    public void setTransferredToMaster(String transferredToMaster) {
        this.transferredToMaster = transferredToMaster;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public void setProcessedUpdate(String processedUpdate) {
        this.processedUpdate = processedUpdate;
    }

    public void setCommentsUpdate(String commentsUpdate) {
        this.commentsUpdate = commentsUpdate;
    }

    public void setDependancyBrotherId(Integer dependancyBrotherId) {
        this.dependancyBrotherId = dependancyBrotherId;
    }

    public void setDependancySisterId(Integer dependancySisterId) {
        this.dependancySisterId = dependancySisterId;
    }

    public void setDeactivated(Integer deactivated) {
        this.deactivated = deactivated;
    }

    public void setEwControllerId(String ewControllerId) {
        this.ewControllerId = ewControllerId;
    }

    public void setWacheteUrl(String wacheteUrl) {
        this.wacheteUrl = wacheteUrl;
    }



    @Override
    public String toString() {
        return "DataSource{"   +
                "dataSourceId="           + dataSourceId        +
                ", dataSourceName='"      + dataSourceName      + '\'' +
                ", url='"                 + url                 + '\'' +
                ", sourceType='"          + sourceType          + '\'' +
                ", updateInterval='"      + updateInterval      + '\'' +
                ", updateMethod='"        + updateMethod        + '\'' +
                ", nextUpdateEarliest='"  + nextUpdateEarliest  + '\'' +
                ", nextUpdateLatest='"    + nextUpdateLatest    + '\'' +
                ", latestUpdate='"        + latestUpdate        + '\'' +
                ", transferredToMaster='" + transferredToMaster + '\'' +
                ", comments='"            + comments            + '\'' +
                ", parentId='"            + parentId            + '\'' +
                ", processedUpdate='"     + processedUpdate     + '\'' +
                ", commentsUpdate='"      + commentsUpdate      + '\'' +
                ", dependancyBrotherId='" + dependancyBrotherId + '\'' +
                ", dependancySisterId='"  + dependancySisterId  + '\'' +
                ", deactivated='"         + deactivated         + '\'' +
                ", ewControllerId='"      + ewControllerId      + '\'' +
                ", wacheteUrl='"          + wacheteUrl          + '\'' +
        '}';
    }
}
