
package group.slsd.mapper;

import group.slsd.vo.OwnerVo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OwnerVoMapper {
	int deleteByPrimaryKey(Integer ownerId);

	int insert(OwnerVo record);

	int insertSelective(OwnerVo record);

	OwnerVo selectByPrimaryKey(@Param("ownerId") Integer ownerId);

	int updateByPrimaryKeySelective(OwnerVo record);

	int updateByPrimaryKey(OwnerVo record);
	
	List<OwnerVo> findAll();

	int batchDeleteOwnerByIds(Integer[] idIntegerArr);


	List<OwnerVo> searchOwnersByParameter(OwnerVo ownerVo);

}