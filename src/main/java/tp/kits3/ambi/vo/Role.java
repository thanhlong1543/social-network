package tp.kits3.ambi.vo;

public class Role {

    private Integer roleId;

    private String description;

    private String name;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
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

    public void CopyData(Role param)
    {
        this.roleId = param.getRoleId();
        this.description = param.getDescription();
        this.name = param.getName();
    }
}