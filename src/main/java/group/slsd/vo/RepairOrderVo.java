package group.slsd.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;

import org.springframework.lang.NonNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel
public class RepairOrderVo implements Serializable {
	
	@ApiModelProperty("id")
	private Integer id;
	@ApiModelProperty("订单号")
	private String outTradeNo;
	
	@ApiModelProperty("交易号")
	private String tradeNo;

	@NotEmpty(message = "维修名称不能为空")
	@ApiModelProperty("维修的名称")
	private String tradeName;
	
	@ApiModelProperty("报修人id")
	private Integer ownerId;

	@NotEmpty(message = "维修物主不能为空")
	@ApiModelProperty("业主名字")
	private String ownerName;

	@ApiModelProperty("受理人id")
	private Integer empId;

	@ApiModelProperty("受理人name")
	private String empName;

	@ApiModelProperty("维修数量")
	private Integer num;

	@ApiModelProperty("维修价格")
	private BigDecimal totalMount;

	@ApiModelProperty("维修单支付状态")
	private String tradeStatus;

	private static final long serialVersionUID = 1L;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo == null ? null : outTradeNo.trim();
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo == null ? null : tradeNo.trim();
	}

	public String getTradeName() {
		return tradeName;
	}

	public void setTradeName(String tradeName) {
		this.tradeName = tradeName == null ? null : tradeName.trim();
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName == null ? null : ownerName.trim();
	}

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

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public BigDecimal getTotalMount() {
		return totalMount;
	}

	public void setTotalMount(BigDecimal totalMount) {
		this.totalMount = totalMount;
	}

	public String getTradeStatus() {
		return tradeStatus;
	}

	public void setTradeStatus(String tradeStatus) {
		this.tradeStatus = tradeStatus == null ? null : tradeStatus.trim();
	}
}