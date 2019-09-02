package group.slsd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import group.slsd.mapper.CarPostionVoMapper;
import group.slsd.vo.CarPostionVo;

@Service
public class CarPostionServiceImpl implements CarPostionService {

	@Autowired
	private CarPostionVoMapper carPostionVoMapper;

	@Transactional
	@Override
	public int deleteByPrimaryKey(Integer cid) {
		return carPostionVoMapper.deleteByPrimaryKey(cid);
	}

	@Override
	public int insert(CarPostionVo record) {
		return insertSelective(record);
	}

	@Transactional
	@Override
	public int insertSelective(CarPostionVo record) {
		return carPostionVoMapper.insertSelective(record);
	}

	@Override
	public CarPostionVo selectByPrimaryKey(Integer cid) {
		return carPostionVoMapper.selectByPrimaryKey(cid);
	}

	@Transactional
	@Override
	public int updateByPrimaryKeySelective(CarPostionVo record) {
		return carPostionVoMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(CarPostionVo record) {
		return updateByPrimaryKeySelective(record);
	}

	@Override
	public int batchDeleteAsksByIds(Integer[] idIntegerArr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CarPostionVo> searchAsksByParameter(CarPostionVo carPostionVo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CarPostionVo> findAll() {
		return carPostionVoMapper.findAll();
	}

}
