package datasourcespkg.domain;

public class SourceTypes {

    private Long sourceTypeId;
    private String sourceTypeName;

    public SourceTypes() {
    }

    public SourceTypes(Long sourceTypeId, String sourceTypeName) {
        this.sourceTypeId   = sourceTypeId;
        this.sourceTypeName = sourceTypeName;
    }

    public Long getSourceTypeId() {
        return sourceTypeId;
    }
    public String getSourceTypeName() { return sourceTypeName; }

    public void setSourceTypeId(Long sourceTypeId) {
        this.sourceTypeId = sourceTypeId;
    }
    public void setSourceTypeName(String sourceTypeName) {
        this.sourceTypeName = sourceTypeName;
    }


    @Override
    public String toString() {
        return "SourceTypes{" +
                "sourceTypeId=" + sourceTypeId +
                "sourceTypeName=" + sourceTypeName +
                '}';
    }
}






