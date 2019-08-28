package group.slsd.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import group.slsd.vo.AsksVo;

public interface AsksService {

	int insert(AsksVo record);

	int insertSelective(AsksVo record);

	AsksVo selectByPrimaryKey(@Param("asksId") Integer asksId);

	int deleteByPrimaryKey(Integer asksId);

	int updateByPrimaryKeySelective(AsksVo record);

	int updateByPrimaryKey(AsksVo record);
	
	int batchDeleteAsksByIds(Integer[] ids);
	
	List<AsksVo> findAll();
	
	List<AsksVo> searchAsksByParameter(AsksVo record);
}
