package group.slsd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import group.slsd.vo.DevicesVo;

@Mapper
public interface DevicesVoMapper {
	
	int deleteByPrimaryKey(Integer ownerId);

	int insert(DevicesVo record);

	int insertSelective(DevicesVo record);

	DevicesVo selectByPrimaryKey(@Param("ownerId") Integer ownerId);

	int updateByPrimaryKeySelective(DevicesVo record);

	int updateByPrimaryKey(DevicesVo record);
	
	List<DevicesVo> findAll();
	
}
