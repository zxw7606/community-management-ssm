package group.slsd.mapper;

import org.apache.ibatis.annotations.Mapper;

import group.slsd.vo.OwnerVo;
/**
 * 业主
 * 
 * @author hang
 *
 */

@Mapper
public interface OwnerVoMapper {

    int deleteByPrimaryKey(Integer ownerId);

    int insert(OwnerVo record);

    int insertSelective(OwnerVo record);

    OwnerVo selectByPrimaryKey(Integer ownerId);

    int updateByPrimaryKeySelective(OwnerVo record);

    int updateByPrimaryKey(OwnerVo record);
}