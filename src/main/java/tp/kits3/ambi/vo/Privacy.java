package tp.kits3.ambi.vo;

public class Privacy {

    private Integer privacyId;

    private String name;

    private String description;

    public Integer getPrivacyId() {
        return privacyId;
    }

    public void setPrivacyId(Integer privacyId) {
        this.privacyId = privacyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void CopyData(Privacy param)
    {
        this.privacyId = param.getPrivacyId();
        this.name = param.getName();
        this.description = param.getDescription();
    }
}