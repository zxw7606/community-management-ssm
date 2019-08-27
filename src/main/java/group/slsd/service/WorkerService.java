package group.slsd.service;

import java.util.List;

import group.slsd.vo.WorkerVo;

public interface WorkerService {
	

    int deleteByPrimaryKey(Integer ownerId);

    int insert(WorkerVo record);

    int insertSelective(WorkerVo record);

    WorkerVo selectByPrimaryKey(Integer ownerId);

    int updateByPrimaryKeySelective(WorkerVo record);

    int updateByPrimaryKey(WorkerVo record);
    
    List<WorkerVo> findAll();
}
