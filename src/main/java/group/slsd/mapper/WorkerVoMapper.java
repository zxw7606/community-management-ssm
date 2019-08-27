package group.slsd.mapper;

import group.slsd.vo.WorkerVo;

public interface WorkerVoMapper {
	
    int deleteByPrimaryKey(Integer empId);

    int insert(WorkerVo record);

    int insertSelective(WorkerVo record);

    int updateByPrimaryKeySelective(WorkerVo record);

    int updateByPrimaryKey(WorkerVo record);

    WorkerVo selectByPrimaryKey(Integer empId);
    
}