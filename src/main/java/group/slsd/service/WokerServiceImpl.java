package group.slsd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import group.slsd.mapper.WorkerVoMapper;
import group.slsd.vo.WorkerVo;

@Service
public class WokerServiceImpl implements WorkerService {

	@Autowired
	private WorkerVoMapper workerVoMapper;

	@Transactional
	@Override
	public int deleteByPrimaryKey(Integer ownerId) {
		return workerVoMapper.deleteByPrimaryKey(ownerId);
	}

	@Transactional
	@Override
	public int insert(WorkerVo record) {
		return workerVoMapper.insert(record);
	}

	@Transactional
	@Override
	public int insertSelective(WorkerVo record) {
		return workerVoMapper.insertSelective(record);
	}

	@Override
	public WorkerVo selectByPrimaryKey(Integer ownerId) {
		return workerVoMapper.selectByPrimaryKey(ownerId);
	}

	@Transactional
	@Override
	public int updateByPrimaryKeySelective(WorkerVo record) {
		return workerVoMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional
	@Override
	public int updateByPrimaryKey(WorkerVo record) {
		return workerVoMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<WorkerVo> findAll() {
		return workerVoMapper.findAll();
	}

}
