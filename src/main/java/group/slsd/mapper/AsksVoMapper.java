package group.slsd.mapper;

import group.slsd.vo.AsksVo;
import group.slsd.vo.ManVo;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AsksVoMapper {

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