
package group.slsd.mapper;

import group.slsd.vo.OwnerVo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OwnerVoMapper {
	int insert(OwnerVo record);

	int insertSelective(OwnerVo record);
	
	List<OwnerVo> findAll();

	OwnerVo selectByPrimaryKey(@Param("ownerId") Integer ownerId);
	
	int deleteByPrimaryKey(Integer ownerId);

	int updateByPrimaryKeySelective(OwnerVo record);

	int updateByPrimaryKey(OwnerVo record);

	int batchDeleteOwnerByIds(Integer[] idIntegerArr);

	List<OwnerVo> searchOwnersByParameter(OwnerVo ownerVo);

}