package datasourcespkg.domain;

public class UpdateMethods {

    private Long updateMethodId;
    private String updateMethodName;
    private String updateMethodComments;

    public UpdateMethods() {
    }

    public UpdateMethods(Long updateMethodId, String updateMethodName, String updateMethodComments) {
        this.updateMethodId            = updateMethodId;
        this.updateMethodName          = updateMethodName;
        this.updateMethodComments      = updateMethodComments;
    }

    public Long getUpdateMethodId() { return updateMethodId; }
    public String getUpdateMethodName() { return updateMethodName; }
    public String getUpdateMethodComments() {
        return updateMethodComments;
    }

    public void setUpdateMethodId(Long updateMethodId) {
        this.updateMethodId = updateMethodId;
    }
    public void setUpdateMethodName(String updateMethodName) {
        this.updateMethodName = updateMethodName;
    }
    public void setUpdateMethodComments(String updateMethodComments) { this.updateMethodComments = updateMethodComments; }

    @Override
    public String toString() {
        return "UpdateMethods{" +
                "updateMethodId=" + updateMethodId + "\n" +
                "updateMethodName=" + updateMethodName +
                "updateMethodComments=" + updateMethodComments +
                '}';
    }
}


