package tp.kits3.ambi.vo;

public class Icon {

    private Integer iconId;

    private String name;

    private String description;

    public Integer getIconId() {
        return iconId;
    }

    public void setIconId(Integer iconId) {
        this.iconId = iconId;
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

    public void CopyData(Icon param)
    {
        this.iconId = param.getIconId();
        this.name = param.getName();
        this.description = param.getDescription();
    }
}