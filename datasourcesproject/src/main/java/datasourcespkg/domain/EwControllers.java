package datasourcespkg.domain;

public class EwControllers {

    private Long ewControllerId;
    private String ewControllerName;
    private String ewControllerComments;

    public EwControllers() {
    }

    public EwControllers(Long ewControllerId, String ewControllerName, String ewControllerComments) {
        this.ewControllerId       = ewControllerId;
        this.ewControllerName     = ewControllerName;
        this.ewControllerComments = ewControllerComments;
    }

    public Long getEwControllerId() { return ewControllerId; }
    public String getEwControllerName() { return ewControllerName; }
    public String getEwControllerComments() {
        return ewControllerComments;
    }

    public void getEwControllerId(Long ewControllerId) {
        this.ewControllerId = ewControllerId;
    }
    public void getEwControllerName(String ewControllerName) {
        this.ewControllerName = ewControllerName;
    }
    public void getEwControllerComments(String ewControllerComments) { this.ewControllerComments = ewControllerComments; }

    @Override
    public String toString() {
        return "EwControllers{" +
                "ewControllerId=" + ewControllerId +
                "ewControllerName=" + ewControllerName +
                "ewControllerComments=" + ewControllerComments +
                '}';
    }


}


