package tp.kits3.ambi.vo;

public class User {

    private Integer userId;

    private String name;

    private String phone;

    private String email;

    private String password;

    private Boolean isactive;

    private String userUrl;
    
    private String useravt;
    
    private String userbgr;

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



    public String getUserUrl() {
        return userUrl;
    }

    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }
    
    
    public String getUseravt() {
		return useravt;
	}

	public void setUseravt(String useravt) {
		this.useravt = useravt;
	}

	public String getUserbgr() {
		return userbgr;
	}

	public void setUserbgr(String userbgr) {
		this.userbgr = userbgr;
	}

	public void CopyData(User param)
    {
        this.userId = param.getUserId();
        this.name = param.getName();
        this.phone = param.getPhone();
        this.email = param.getEmail();
        this.password = param.getPassword();
        this.isactive = param.getIsactive();
        this.userUrl = param.getUserUrl();
        this.useravt = param.getUseravt();
        this.userbgr = param.getUserbgr();
    }
}
