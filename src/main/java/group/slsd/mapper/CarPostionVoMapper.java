package group.slsd.mapper;

import group.slsd.vo.CarPostionVo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CarPostionVoMapper {
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