package group.slsd.service;

import java.util.List;

import group.slsd.vo.WorkerVo;

public interface WorkerService {
	
	 int insert(WorkerVo record);

	    int insertSelective(WorkerVo record);

	    List<WorkerVo> findAll();
	    
	    WorkerVo selectByPrimaryKey(Integer empId);
	    
	    int deleteByPrimaryKey(Integer empId);

	    int updateByPrimaryKeySelective(WorkerVo record);

	    int updateByPrimaryKey(WorkerVo record);

		int batchDeleteWorkerByIds(Integer[] ids);

		List<WorkerVo> searchWorkerByParameter(WorkerVo workerVo);
	    
}
