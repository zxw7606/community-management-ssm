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

	public int deleteByPrimaryKey(Integer devicesId) {
		
		return devicesVoMapper.deleteByPrimaryKey(devicesId);
	}

	@Transactional
	public int insert(DevicesVo record) {
		
		return devicesVoMapper.insert(record);
	}

	@Transactional
	public int insertSelective(DevicesVo record) {
		return devicesVoMapper.insertSelective(record);
	}

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

	public List<DevicesVo> findAll() {
		
		return devicesVoMapper.findAll();
	}

	@Override
	public int batchDeleteDevicesByIds(Integer[] ids) {
		return devicesVoMapper.batchDeleteDevicesByIds(ids);
	}

	@Override
	public List<DevicesVo> searchDevicesByParameter(DevicesVo devicesVo) {
		return devicesVoMapper.searchDevicesByParameter(devicesVo);
	}

}