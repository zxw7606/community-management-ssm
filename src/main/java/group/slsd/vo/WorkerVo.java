package group.slsd.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class WorkerVo implements Serializable {

	@ApiModelProperty("id")
	private Integer empId;
	@ApiModelProperty("员工名字")
	private String empName;
	@ApiModelProperty("用户名")
	private String uName;
	@ApiModelProperty("密码id")
	private String pwd;
	@ApiModelProperty("员工职位")
	private String empPosition;
	@ApiModelProperty("电话")
	private String empTel;
	@ApiModelProperty("描述")
	private String empDescript;
	@ApiModelProperty("角色")
	private String roles;

	private static final long serialVersionUID = 1L;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName == null ? null : empName.trim();
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName == null ? null : uName.trim();
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd == null ? null : pwd.trim();
	}

	public String getEmpPosition() {
		return empPosition;
	}

	public void setEmpPosition(String empPosition) {
		this.empPosition = empPosition == null ? null : empPosition.trim();
	}

	public String getEmpTel() {
		return empTel;
	}

	public void setEmpTel(String empTel) {
		this.empTel = empTel == null ? null : empTel.trim();
	}

	public String getEmpDescript() {
		return empDescript;
	}

	public void setEmpDescript(String empDescript) {
		this.empDescript = empDescript == null ? null : empDescript.trim();
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles == null ? null : roles.trim();
	}
}