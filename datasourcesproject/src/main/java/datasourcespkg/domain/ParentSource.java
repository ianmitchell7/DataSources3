package datasourcespkg.domain;

public class ParentSource {

    private Long parentSourceId;
    private String parentSourceName;
    private String url;

    public ParentSource() {
    }

    public ParentSource(Long parentId, String parentName, String url) {
        this.parentSourceId = parentId;
        this.parentSourceName = parentName;
        this.url = url;
    }

    public Long getParentSourceId() {
        return parentSourceId;
    }

    public String getParentSourceName() {
        return parentSourceName;
    }

    public String getUrl() {
        return url;
    }

    public void setParentSourceId(Long parentSourceId) {
        this.parentSourceId = parentSourceId;
    }

    public void setParentSourceName(String parentSourceName) {
        this.parentSourceName = parentSourceName;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ParentSource{" +
                "parentSourceId=" + parentSourceId +
                ", parentSourceName='" + parentSourceName + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
