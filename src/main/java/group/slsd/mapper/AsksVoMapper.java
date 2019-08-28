
package group.slsd.mapper;

import group.slsd.vo.AsksVo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AsksVoMapper {
	int deleteByPrimaryKey(Integer asksId);

	int insert(AsksVo record);

	int insertSelective(AsksVo record);

	AsksVo selectByPrimaryKey(@Param("asksId") Integer asksId);

	int updateByPrimaryKeySelective(AsksVo record);

	int updateByPrimaryKey(AsksVo record);
	
	List<AsksVo> findAll();
}