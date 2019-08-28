package group.slsd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import group.slsd.mapper.OwnerVoMapper;
import group.slsd.vo.OwnerVo;

@Service
public class OwnerServiceImpl implements OwnerService {

	@Autowired
	private OwnerVoMapper ownerVoMapper;

	@Transactional
	@Override
	public int deleteByPrimaryKey(Integer ownerId) {
		return ownerVoMapper.deleteByPrimaryKey(ownerId);
	}

	@Transactional
	@Override
	public int insert(OwnerVo record) {
		return ownerVoMapper.insert(record);
	}

	@Transactional
	@Override
	public int insertSelective(OwnerVo record) {
		return ownerVoMapper.insertSelective(record);
	}

	@Override
	public OwnerVo selectByPrimaryKey(Integer ownerId) {
		return ownerVoMapper.selectByPrimaryKey(ownerId);
	}

	@Transactional
	@Override
	public int updateByPrimaryKeySelective(OwnerVo record) {
		return ownerVoMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional
	@Override
	public int updateByPrimaryKey(OwnerVo record) {
		return ownerVoMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<OwnerVo> findAll() {
		return ownerVoMapper.findAll();
	}

	@Override
	public int batchDeleteOwnerByIds(Integer[] idIntegerArr) {
		return ownerVoMapper.batchDeleteOwnerByIds(idIntegerArr);
	}

	@Override
	public List<OwnerVo> searchOwnersByParameter(OwnerVo ownerVo) {
		return ownerVoMapper.searchOwnersByParameter(ownerVo);
	}

}
