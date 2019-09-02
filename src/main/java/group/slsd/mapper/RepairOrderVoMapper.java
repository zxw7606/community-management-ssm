package group.slsd.mapper;

import group.slsd.vo.RepairOrderVo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RepairOrderVoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RepairOrderVo record);

    int insertSelective(RepairOrderVo record);

    RepairOrderVo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RepairOrderVo record);

    int updateByPrimaryKey(RepairOrderVo record);

	RepairOrderVo selectByOutTradeNo(String out_trade_no);

	List<RepairOrderVo> findAll();
}