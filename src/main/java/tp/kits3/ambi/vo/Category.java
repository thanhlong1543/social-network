package tp.kits3.ambi.vo;

public class Category {

    private Integer categoryId;

    private String name;

    private String description;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
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

    public void CopyData(Category param)
    {
        this.categoryId = param.getCategoryId();
        this.name = param.getName();
        this.description = param.getDescription();
    }
}