package tp.kits3.ambi.vo;

public class NotiType {
	private int notiTypeId;
	private String nameType;
	private String description;
	public int getNotiTypeId() {
		return notiTypeId;
	}
	public void setNotiTypeId(int notiTypeId) {
		this.notiTypeId = notiTypeId;
	}
	public String getNameType() {
		return nameType;
	}
	public void setNameType(String nameType) {
		this.nameType = nameType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public NotiType(int notiTypeId, String nameType, String description) {
		this.notiTypeId = notiTypeId;
		this.nameType = nameType;
		this.description = description;
	}
	
}
