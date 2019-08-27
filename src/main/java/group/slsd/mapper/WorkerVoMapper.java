package group.slsd.mapper;

import group.slsd.vo.WorkerVo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WorkerVoMapper {
	
    int deleteByPrimaryKey(Integer empId);

    int insert(WorkerVo record);

    int insertSelective(WorkerVo record);

    WorkerVo selectByPrimaryKey(Integer empId);

    int updateByPrimaryKeySelective(WorkerVo record);

    int updateByPrimaryKey(WorkerVo record);
    
    List<WorkerVo> findAll();
}