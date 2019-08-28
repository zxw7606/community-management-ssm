package group.slsd.mapper;

import group.slsd.vo.ManVo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ManVoMapper {
	
	int insert(ManVo record);

	int insertSelective(ManVo record);

	List<ManVo> findAll();

	ManVo selectByPrimaryKey(Integer manId);

	int deleteByPrimaryKey(Integer manId);

	int updateByPrimaryKeySelective(ManVo manVo);

	int batchDeleteManByIds(Integer[] ids);

	List<ManVo> searchMansByParameter(ManVo manVo);
}