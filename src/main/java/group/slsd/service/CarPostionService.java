package group.slsd.service;

import java.util.List;

import group.slsd.vo.CarPostionVo;

public interface CarPostionService {

    int deleteByPrimaryKey(Integer cid);

    int insert(CarPostionVo record);

    int insertSelective(CarPostionVo record);

    CarPostionVo selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(CarPostionVo record);

    int updateByPrimaryKey(CarPostionVo record);

	int batchDeleteAsksByIds(Integer[] idIntegerArr);

	List<CarPostionVo> searchAsksByParameter(CarPostionVo carPostionVo);

	List<CarPostionVo> findAll();
	
}
