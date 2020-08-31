package tp.kits3.ambi.vo;

public class Relationship {

    private Integer reId;

    private String description;

    private String name;

    public Integer getReId() {
        return reId;
    }

    public void setReId(Integer reId) {
        this.reId = reId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void CopyData(Relationship param)
    {
        this.reId = param.getReId();
        this.description = param.getDescription();
        this.name = param.getName();
    }
}
