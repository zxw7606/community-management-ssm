package group.slsd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import group.slsd.vo.DevicesVo;

@Mapper
public interface DevicesVoMapper {
	
	int insert(DevicesVo record);

	int insertSelective(DevicesVo record);

	List<DevicesVo> findAll();

	DevicesVo selectByPrimaryKey(@Param("dId") Integer dId);
	
	int deleteByPrimaryKey(Integer ownerId);

	int updateByPrimaryKeySelective(DevicesVo record);

	int updateByPrimaryKey(DevicesVo record);
	
	int batchDeleteDevicesByIds(Integer[] ids);

	List<DevicesVo> searchDevicesByParameter(DevicesVo devicesVo);
	
}
