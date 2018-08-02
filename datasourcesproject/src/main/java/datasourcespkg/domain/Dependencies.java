package datasourcespkg.domain;

public class Dependencies {

    private Long dependenciesId;
    private Long dataSourceId;
    private Long dependentOnDataSourceId;
    private Long dependentForDataSourceId;

    public Dependencies() {
    }

    public Dependencies(Long dependenciesId, Long dataSourceId, Long dependentOnDataSourceId, Long dependentForDataSourceId) {
        this.dependenciesId           = dependenciesId;
        this.dataSourceId             = dataSourceId;
        this.dependentOnDataSourceId  = dependentOnDataSourceId;
        this.dependentForDataSourceId = dependentForDataSourceId;
    }

    public Long getDependenciesId() { return dependenciesId; }
    public Long getDataSourceId() { return dataSourceId; }
    public Long getDependentOnDataSourceId() {
        return dependentOnDataSourceId;
    }
    public Long getDependentForDataSourceId() {
        return dependentForDataSourceId;
    }

    public void getDependenciesId(Long sourceTypeId) {
        this.dependenciesId = dependenciesId;
    }
    public void getDataSourceId(Long sourceTypeId) {
        this.dataSourceId = dataSourceId;
    }
    public void getDependentOnDataSourceId(Long sourceTypeId) { this.dependentOnDataSourceId = dependentOnDataSourceId; }
    public void getDependentForDataSourceId(Long sourceTypeId) { this.dependentForDataSourceId = dependentForDataSourceId; }


    @Override
    public String toString() {
        return "Dependencies{" +
                "dataSourceId=" + dependenciesId +
                "dataSourceId=" + dataSourceId +
                "dependentOnDataSourceId=" + dependentOnDataSourceId +
                "dependentForDataSourceId=" + dependentForDataSourceId +
                '}';
    }
}


