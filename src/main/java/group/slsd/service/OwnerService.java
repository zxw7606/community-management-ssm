package group.slsd.service;

import group.slsd.vo.OwnerVo;

public interface OwnerService {
	

    int deleteByPrimaryKey(Integer ownerId);

    int insert(OwnerVo record);

    int insertSelective(OwnerVo record);

    OwnerVo selectByPrimaryKey(Integer ownerId);

    int updateByPrimaryKeySelective(OwnerVo record);

    int updateByPrimaryKey(OwnerVo record);
    
    
	
}