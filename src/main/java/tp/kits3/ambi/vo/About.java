package tp.kits3.ambi.vo;

public class About {

    private Integer aboutId;

    private String education;

    private String country;

    private String lives;

    private String birthday;

    private Integer userId;

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

    public void CopyData(About param)
    {
        this.aboutId = param.getAboutId();
        this.education = param.getEducation();
        this.country = param.getCountry();
        this.lives = param.getLives();
        this.birthday = param.getBirthday();
        this.userId = param.getUserId();
    }
}
