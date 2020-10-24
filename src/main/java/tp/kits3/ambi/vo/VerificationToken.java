package tp.kits3.ambi.vo;

public class VerificationToken {

	private Integer tokenId;

	private String token;

	private Integer userId;


	public Integer getTokenId() {
		return tokenId;
	}

	public void setTokenId(Integer tokenId) {
		this.tokenId = tokenId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public VerificationToken( String token, Integer userId) {
		this.token = token;
		this.userId = userId;
	}

	public VerificationToken() {
		
	}
	
	


	
}
