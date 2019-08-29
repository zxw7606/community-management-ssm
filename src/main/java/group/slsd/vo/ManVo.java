package group.slsd.vo;

import java.io.Serializable;

import group.slsd.validator.annotation.Phone;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ManVo implements Serializable {

	@ApiModelProperty("id")
	private Integer id;

	@ApiModelProperty("用户名")
	private String username;
	
	@ApiModelProperty("密码")
	private String pwd;

	@ApiModelProperty("电话")
	private String phone;

	@ApiModelProperty("邮件")
	private String email;

	@ApiModelProperty("备注")
	private String content;

	private static final long serialVersionUID = 1L;

	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd == null ? null : pwd.trim();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}
}