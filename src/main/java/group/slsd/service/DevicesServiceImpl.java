package group.slsd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import group.slsd.mapper.DevicesVoMapper;
import group.slsd.vo.DevicesVo;

@Service
public class DevicesServiceImpl implements DevicesService {

	@Autowired
	private DevicesVoMapper devicesVoMapper;

	@Transactional
	@Override
	public int deleteByPrimaryKey(Integer devicesId) {
		
		return devicesVoMapper.deleteByPrimaryKey(devicesId);
	}

	@Transactional
	@Override
	public int insert(DevicesVo record) {
		
		return devicesVoMapper.insert(record);
	}

	@Transactional
	@Override
	public int insertSelective(DevicesVo record) {
		return devicesVoMapper.insertSelective(record);
	}

	@Transactional
	@Override
	public DevicesVo selectByPrimaryKey(Integer devicesId) {
		
		return devicesVoMapper.selectByPrimaryKey(devicesId);
	}

	@Transactional
	@Override
	public int updateByPrimaryKeySelective(DevicesVo record) {
		
		return devicesVoMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional
	@Override
	public int updateByPrimaryKey(DevicesVo record) {
		
		return devicesVoMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<DevicesVo> findAll() {
		
		return devicesVoMapper.findAll();
	}

}