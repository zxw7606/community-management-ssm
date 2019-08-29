package group.slsd.mapper;

import group.slsd.vo.WorkerVo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WorkerVoMapper {
	
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