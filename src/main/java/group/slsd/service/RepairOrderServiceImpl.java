package group.slsd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import group.slsd.mapper.RepairOrderVoMapper;
import group.slsd.vo.RepairOrderVo;

@Service
public class RepairOrderServiceImpl {

	@Autowired
	private RepairOrderVoMapper repairOrderVoMapper;

	@Transactional
	public int deleteByPrimaryKey(Integer id) {
		return repairOrderVoMapper.deleteByPrimaryKey(id);
	}

	@Transactional
	public int insert(RepairOrderVo record) {
		return insertSelective(record);
	}

	@Transactional
	public int insertSelective(RepairOrderVo record) {
		return repairOrderVoMapper.insertSelective(record);
	}

	public RepairOrderVo selectByPrimaryKey(Integer id) {
		return repairOrderVoMapper.selectByPrimaryKey(id);
	}

	@Transactional
	public int updateByPrimaryKeySelective(RepairOrderVo record) {
		return repairOrderVoMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(RepairOrderVo record) {
		return updateByPrimaryKeySelective(record);
	}

	public RepairOrderVo selectByOutTradeNo(String out_trade_no) {
		return repairOrderVoMapper.selectByOutTradeNo(out_trade_no);
	}

}
