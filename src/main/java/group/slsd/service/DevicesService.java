package group.slsd.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import group.slsd.vo.DevicesVo;;

public interface DevicesService {

	int insert(DevicesVo record);

	int insertSelective(DevicesVo record);

	List<DevicesVo> findAll();

	DevicesVo selectByPrimaryKey(@Param("dId") Integer dId);
	
	int deleteByPrimaryKey(Integer dId);

	int updateByPrimaryKeySelective(DevicesVo record);

	int updateByPrimaryKey(DevicesVo record);
	
	int batchDeleteDevicesByIds(Integer[] ids);

	List<DevicesVo> searchDevicesByParameter(DevicesVo devicesVo);
}
