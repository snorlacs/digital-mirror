package digitalmirror.domain;

public class UserBeaconLocation {

    private String userId;

    private String uuId;

    private String majorId;

    private String minorId;

    public String getUuId() {
        return uuId;
    }

    public void setUuId(String uuId) {
        this.uuId = uuId;
    }

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }

    public String getMinorId() {
        return minorId;
    }

    public void setMinorId(String minorId) {
        this.minorId = minorId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


}
