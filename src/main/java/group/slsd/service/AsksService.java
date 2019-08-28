package group.slsd.service;

import java.util.List;

import group.slsd.vo.AsksVo;

public interface AsksService {

	int deleteByPrimaryKey(Integer asksId);

    int insert(AsksVo record);

    int insertSelective(AsksVo record);

    AsksVo selectByPrimaryKey(Integer asksId);

    int updateByPrimaryKeySelective(AsksVo record);

    int updateByPrimaryKey(AsksVo record);
    
    List<AsksVo> findAll();
}
