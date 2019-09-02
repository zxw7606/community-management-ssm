package group.slsd.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "楼宇")
public class HourseVo implements Serializable {

	@ApiModelProperty("单元号")
	private Integer hid;

	@ApiModelProperty("单元楼描述")
	private String hdescription;

	@ApiModelProperty("负责人id")
	private Integer empid;

	private static final long serialVersionUID = 1L;

	public Integer getHid() {
		return hid;
	}

	public void setHid(Integer hid) {
		this.hid = hid;
	}

	public String getHdescription() {
		return hdescription;
	}

	public void setHdescription(String hdescription) {
		this.hdescription = hdescription == null ? null : hdescription.trim();
	}

	public Integer getEmpid() {
		return empid;
	}

	public void setEmpid(Integer empid) {
		this.empid = empid;
	}
}