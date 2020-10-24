package tp.kits3.ambi.vo;

public class RoleUser {

    private Integer userId;

    private Integer roleId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public void CopyData(RoleUser param)
    {
        this.userId = param.getUserId();
        this.roleId = param.getRoleId();
    }

	public RoleUser() {
	}

	public RoleUser(Integer userId, Integer roleId) {
		this.userId = userId;
		this.roleId = roleId;
	}
    
    
}
