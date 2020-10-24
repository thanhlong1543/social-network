package tp.kits3.ambi.websocket;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
/**
 *@author Pham Thanh Tam
 */
public class Message {

    @JsonProperty("username")
    private String userName;
    @JsonProperty
    private String message;
    @JsonProperty
    private String id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String useravt;
    @JsonProperty
    private String userid;
    @JsonProperty
    private String sendtype;
    @JsonInclude(value = Include.NON_NULL)
    @JsonProperty
    private String commentid;
    @JsonCreator
    public Message(@JsonProperty("username") String userName,
    		@JsonProperty("message") String message,
    		@JsonProperty("id") String id,
    		@JsonProperty("name") String name,
    		@JsonProperty("useravt") String useravt,
    		@JsonProperty("userid") String userid,
    		@JsonProperty ("sendtype" ) String sendtype,
    		@JsonInclude(value = Include.NON_NULL)@JsonProperty ("commentid" ) String commentid) {
        Objects.requireNonNull(userName);
        Objects.requireNonNull(message);
        Objects.requireNonNull(id);
        Objects.requireNonNull(name);
        Objects.requireNonNull(useravt);
        Objects.requireNonNull(userid);
        Objects.requireNonNull(sendtype);
        this.userName = userName;
        this.message = message;
        this.id = id;
        this.name = name;
        this.useravt = useravt;
        this.userid = userid;
        this.sendtype = sendtype;
        this.commentid = commentid;
        
    }
    public String getCommentid() {
		return commentid;
	}

	public String getUserid() {
		return userid;
	}

	public String getSendtype() {
		return sendtype;
	}

	public String getName() {
		return name;
	}

	public String getUseravt() {
		return useravt;
	}

	String getUserName() {
        return this.userName;
    }

    String getMessage() {
        return this.message;
    }
    String getId() {
        return this.id;
    }
    
}
