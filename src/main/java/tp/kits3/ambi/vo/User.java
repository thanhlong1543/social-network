package tp.kits3.ambi.vo;

public class User {

    private Integer userId;

    private String name;

    private String phone;

    private String email;

    private String password;

    private Boolean isactive;

    private Integer roleId;

    private String userUrl;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIsactive() {
        return isactive;
    }

    public void setIsactive(Boolean isactive) {
        this.isactive = isactive;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getUserUrl() {
        return userUrl;
    }

    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }
    public void CopyData(User param)
    {
        this.userId = param.getUserId();
        this.name = param.getName();
        this.phone = param.getPhone();
        this.email = param.getEmail();
        this.password = param.getPassword();
        this.isactive = param.getIsactive();
        this.roleId = param.getRoleId();
        this.userUrl = param.getUserUrl();
    }
}
