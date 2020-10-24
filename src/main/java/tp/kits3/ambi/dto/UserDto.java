package tp.kits3.ambi.dto;

import java.util.List;

import tp.kits3.ambi.vo.User;

/** 
 * @author Vu Thanh Long
 */
public class UserDto extends User{
	private int mutual;
	private List<User> listMutual;
	public UserDto(int mutual) {
		super();
		this.mutual = mutual;
	}

	public UserDto() {
		super();

	}

	public int getMutual() {
		return mutual;
	}

	public void setMutual(int mutual) {
		this.mutual = mutual;
	}

	public List<User> getListMutual() {
		return listMutual;
	}

	public void setListMutual(List<User> listMutual) {
		this.listMutual = listMutual;
	}
	
	
}
