package group.slsd.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

//设备实体
@ApiModel
public class DevicesVo implements Serializable {

	@ApiModelProperty("id")
	private Integer dId;

	@ApiModelProperty("设备名字")
	private String dName;

	@ApiModelProperty("设备类型")
	private String dType;

	@ApiModelProperty("使用情况")
	private String dUse;

	@ApiModelProperty("负责人编号")
	private Integer dUser;

	@ApiModelProperty("维修方式")
	private String dCheckType;

	private static final long serialVersionUID = 1L;

	public Integer getdId() {
		return dId;
	}

	public void setdId(Integer dId) {
		this.dId = dId;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public String getdType() {
		return dType;
	}

	public void setdType(String dType) {
		this.dType = dType;
	}

	public String getdUse() {
		return dUse;
	}

	public void setdUse(String dUse) {
		this.dUse = dUse;
	}

	public Integer getdUser() {
		return dUser;
	}

	public void setdUser(Integer dUser) {
		this.dUser = dUser;
	}

	public String getdCheckType() {
		return dCheckType;
	}

	public void setdCheckType(String dCheckType) {
		this.dCheckType = dCheckType;
	}

	
}
