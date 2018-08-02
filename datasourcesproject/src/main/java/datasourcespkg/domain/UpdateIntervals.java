package datasourcespkg.domain;

public class UpdateIntervals {

    private Long updateIntervalId;
    private String updateIntervalName;
    private Long updateIntervalDaysIncrement;
    private String updateIntervalComments;

    public UpdateIntervals() {
    }

    public UpdateIntervals(Long updateIntervalId, String updateIntervalName, Long updateIntervalDaysIncrement, String updateIntervalComments) {
        this.updateIntervalId            = updateIntervalId;
        this.updateIntervalName          = updateIntervalName;
        this.updateIntervalDaysIncrement = updateIntervalDaysIncrement;
        this.updateIntervalComments      = updateIntervalComments;
    }

    public Long getUpdateIntervalId() { return updateIntervalId; }
    public String getUpdateIntervalName() { return updateIntervalName; }
    public Long getupdateIntervalDaysIncrement() { return updateIntervalDaysIncrement; }
    public String getUpdateIntervalComments() {
        return updateIntervalComments;
    }

    public void setUpdateIntervalId(Long updateIntervalId) {
        this.updateIntervalId = updateIntervalId;
    }
    public void setUpdateIntervalName(String updateIntervalName) {
        this.updateIntervalName = updateIntervalName;
    }
    public void setUpdateIntervalDaysIncrement(Long updateIntervalDaysIncrement) {this.updateIntervalDaysIncrement = updateIntervalDaysIncrement;
    }
    public void setUpdateIntervalComments(String updateIntervalComments) { this.updateIntervalComments = updateIntervalComments; }

    @Override
    public String toString() {
        return "UpdateIntervals{" +
                "updateIntervalId=" + updateIntervalId +
                "updateIntervalName=" + updateIntervalName +
                "updateIntervalDaysIncrement=" + updateIntervalDaysIncrement +
                "updateIntervalComments=" + updateIntervalComments +
                '}';
    }
}

