package group.slsd.vo;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

//投诉
@ApiModel
public class AsksVo implements Serializable {

	@ApiModelProperty("id")
	private Integer aId;

	@ApiModelProperty("投诉对象")
	private String aTarget;

	@ApiModelProperty("投诉内容")
	private String aContent;

	@ApiModelProperty("投诉人")
	private Integer aPersonId;

	@ApiModelProperty("受理人")
	private Integer aEmpId;

	@ApiModelProperty("处理结果")
	private String aResult;

	@ApiModelProperty("受理时间")
	private Date aTime;
	
	private static final long serialVersionUID = 1L;

	public Integer getaId() {
		return aId;
	}

	public void setaId(Integer aId) {
		this.aId = aId;
	}

	public String getaTarget() {
		return aTarget;
	}

	public void setaTarget(String aTarget) {
		this.aTarget = aTarget == null ? null : aTarget.trim();
	}

	public String getaContent() {
		return aContent ;
	}

	public void setaContent(String aContent) {
		this.aContent = aContent == null ? null : aContent.trim();
	}

	public Integer getaPersonId() {
		return aPersonId;
	}

	public void setaPersonId(Integer aPersonId) {
		this.aPersonId = aPersonId;
	}

	public Integer getaEmpId() {
		return aEmpId;
	}

	public void setaEmpId(Integer aEmpId) {
		this.aEmpId = aEmpId;
	}

	public String getaResult() {
		return aResult;
	}

	public void setaResult(String aResult) {
		this.aResult = aResult == null ? null : aResult.trim();
	}

	public Date getaTime() {
		return aTime;
	}

	public void setaTime(Date aTime) {
		this.aTime = aTime ;
	}
	
}
