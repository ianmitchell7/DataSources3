package datasourcespkg.domain;

public class HistoryUpdates {

    private Long historyUpdatesId;
    private Long dataSourceId;
    private String nextUpdateDue;
    private String updateReceived;
    private String updateTransferredToMaster;
    private String updateProcessed;
    private String updateComments;

    public HistoryUpdates() {
    }

    public HistoryUpdates(Long historyUpdatesId, Long dataSourceId, String nextUpdateDue, String updateReceived, String updateTransferredToMaster, String updateProcessed, String updateComments) {
        this.historyUpdatesId = historyUpdatesId;
        this.dataSourceId     = dataSourceId;
        this.nextUpdateDue    = nextUpdateDue;
        this.updateReceived   = updateReceived;
        this.updateTransferredToMaster = updateTransferredToMaster;
        this.updateProcessed  = updateProcessed;
        this.updateComments   = updateComments;
    }

    public Long getHistoryUpdatesId() {
        return historyUpdatesId;
    }

    public Long getDataSourceId() {
        return dataSourceId;
    }

    public String getNextUpdateDue() {
        return nextUpdateDue;
    }

    public String getUpdateReceived() {
        return updateReceived;
    }

    public String getUpdateTransferredToMaster() {
        return updateTransferredToMaster;
    }

    public String getUpdateProcessed() {
        return updateProcessed;
    }

    public String getUpdateComments() {
        return updateComments;
    }


    public void setHistoryUpdatesId(Long historyUpdatesId) {
        this.historyUpdatesId = historyUpdatesId;
    }

    public void setDataSourceId(Long dataSourceId) {
        this.dataSourceId = dataSourceId;
    }

    public void setUpdateReceived(String updateReceived) {
        this.updateReceived = updateReceived;
    }

    public void setUpdateTransferredToMaster(String updateTransferredToMaster) {this.updateTransferredToMaster = updateTransferredToMaster;}

    public void setUpdateProcessed(String updateProcessed) {
        this.updateProcessed = updateProcessed;
    }

    public void setUpdateComments(String updateComments) {
        this.updateComments = updateComments;
    }

    @Override
    public String toString() {
        return "HistoryUpdates{" +
                "historyUpdatesId=" + historyUpdatesId +
                "dataSourceId=" + dataSourceId +
                ", updateReceived='" + updateReceived + '\'' +
                ", updateTransferredToMaster='" + updateTransferredToMaster + '\'' +
                ", updateProcessed='" + updateProcessed + '\'' +
                ", updateComments='" + updateComments + '\'' +
                '}';
    }
}






