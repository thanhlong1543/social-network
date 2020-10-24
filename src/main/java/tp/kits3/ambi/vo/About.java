package tp.kits3.ambi.vo;

public class About {

    private Integer aboutId;

    private String education;

    private String country;

    private String lives;

    private String birthday;

    private Integer userId;
    
    private String bio;
    
    private String comeFrom;
    
    private String company;
    
    public Integer getAboutId() {
        return aboutId;
    }

    public void setAboutId(Integer aboutId) {
        this.aboutId = aboutId;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLives() {
        return lives;
    }

    public void setLives(String lives) {
        this.lives = lives;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    
    public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}
	
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getComeFrom() {
		return comeFrom;
	}

	public void setComeFrom(String comeFrom) {
		this.comeFrom = comeFrom;
	}

	public About() {
	}

	public About(String education, String country, String lives, String birthday, Integer userId, String bio,
			String comeFrom, String company) {
		super();
		this.education = education;
		this.country = country;
		this.lives = lives;
		this.birthday = birthday;
		this.userId = userId;
		this.bio = bio;
		this.comeFrom = comeFrom;
		this.company = company;
	}

	@Override
	public String toString() {
		return "About [aboutId=" + aboutId + ", education=" + education + ", country=" + country + ", lives=" + lives
				+ ", birthday=" + birthday + ", userId=" + userId + ", bio=" + bio + ", comeFrom=" + comeFrom + ", company="
				+ company + "]";
	}

	

	
}
