package group.slsd.service;

import java.util.List;

import group.slsd.vo.DevicesVo;;

public interface DevicesService {

	int deleteByPrimaryKey(Integer devicesId);

    int insert(DevicesVo record);

    int insertSelective(DevicesVo record);

    DevicesVo selectByPrimaryKey(Integer devicesId);

    int updateByPrimaryKeySelective(DevicesVo record);

    int updateByPrimaryKey(DevicesVo record);
    
    List<DevicesVo> findAll();
}
