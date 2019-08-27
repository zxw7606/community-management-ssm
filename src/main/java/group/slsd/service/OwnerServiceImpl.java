package group.slsd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group.slsd.mapper.OwnerVoMapper;
import group.slsd.vo.OwnerVo;

@Service
public class OwnerServiceImpl implements OwnerService {
	
	@Autowired
	private OwnerVoMapper ownerVoMapper;

	@Override
	public int deleteByPrimaryKey(Integer ownerId) {
		return ownerVoMapper.deleteByPrimaryKey(ownerId);
	}

	@Override
	public int insert(OwnerVo record) {
		return ownerVoMapper.insert(record);
	}

	@Override
	public int insertSelective(OwnerVo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public OwnerVo selectByPrimaryKey(Integer ownerId) {
		return ownerVoMapper.selectByPrimaryKey(ownerId);
	}

	@Override
	public int updateByPrimaryKeySelective(OwnerVo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(OwnerVo record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
