package group.slsd.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class OwnerVo implements Serializable {
	
	
	@ApiModelProperty("id")
    private Integer ownerId;
    @ApiModelProperty("业主名字")
    private String ownerName;
    @ApiModelProperty("用户名")
    private String uname;
    @ApiModelProperty("密码")
    private String pwd;
    @ApiModelProperty("房屋面积")
    private Float hsize;
    @ApiModelProperty("居住人员数量")
    private Integer num;
    @ApiModelProperty("电话")
    private String tel;
    @ApiModelProperty("职业")
    private String pro;
    @ApiModelProperty("门牌号")
    private Integer hourseId;
    @ApiModelProperty("家庭地址")
    private String address;
    @ApiModelProperty("是否有车")
    private Boolean iscar;
    @ApiModelProperty("车牌号")
    private Integer carId;
    @ApiModelProperty("车的类型")
    private String cartype;

    private static final long serialVersionUID = 1L;

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

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public Float getHsize() {
        return hsize;
    }

    public void setHsize(Float hsize) {
        this.hsize = hsize;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getPro() {
        return pro;
    }

    public void setPro(String pro) {
        this.pro = pro == null ? null : pro.trim();
    }

    public Integer getHourseId() {
        return hourseId;
    }

    public void setHourseId(Integer hourseId) {
        this.hourseId = hourseId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Boolean getIscar() {
        return iscar;
    }

    public void setIscar(Boolean iscar) {
        this.iscar = iscar;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getCartype() {
        return cartype;
    }

    public void setCartype(String cartype) {
        this.cartype = cartype == null ? null : cartype.trim();
    }
}