package group.slsd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import group.slsd.mapper.HourseVoMapper;
import group.slsd.mapper.MesVoMapper;
import group.slsd.vo.HourseVo;
import group.slsd.vo.MesVo;

@Service
public class HouseServiceImpl implements HourseService{

	@Autowired
	private HourseVoMapper hourseVoMapper;

	@Transactional
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return hourseVoMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(HourseVo record) {
		return insertSelective(record);
	}

	@Transactional
	@Override
	public int insertSelective(HourseVo record) {
		return hourseVoMapper.insertSelective(record);
	}

	@Override
	public HourseVo selectByPrimaryKey(Integer id) {
		return hourseVoMapper.selectByPrimaryKey(id);
	}

	@Transactional
	@Override
	public int updateByPrimaryKeySelective(HourseVo record) {
		return hourseVoMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(HourseVo record) {
		return updateByPrimaryKeySelective(record);
	}

	@Override
	public List<HourseVo> findAll() {
		return hourseVoMapper.findAll();
		
	}
}
