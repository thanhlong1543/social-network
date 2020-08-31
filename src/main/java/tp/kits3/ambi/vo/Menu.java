package tp.kits3.ambi.vo;

public class Menu {

    private Integer menuId;

    private String name;

    private String description;

    private Integer categoryId;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
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

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
    public void CopyData(Menu param)
    {
        this.menuId = param.getMenuId();
        this.name = param.getName();
        this.description = param.getDescription();
        this.categoryId = param.getCategoryId();
    }
}