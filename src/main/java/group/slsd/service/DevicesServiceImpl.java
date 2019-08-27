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
	public int deleteByPrimaryKey(Integer ownerId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Transactional
	@Override
	public int insert(DevicesVo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Transactional
	@Override
	public int insertSelective(DevicesVo record) {
		return devicesVoMapper.insertSelective(record);
	}

	@Transactional
	@Override
	public DevicesVo selectByPrimaryKey(Integer ownerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public int updateByPrimaryKeySelective(DevicesVo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Transactional
	@Override
	public int updateByPrimaryKey(DevicesVo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<DevicesVo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}