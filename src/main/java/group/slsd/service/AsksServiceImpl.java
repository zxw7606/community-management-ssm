package group.slsd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import group.slsd.mapper.AsksVoMapper;
import group.slsd.vo.AsksVo;;

@Service
public class AsksServiceImpl implements AsksService {
	@Autowired
	private AsksVoMapper asksVoMapper;

	@Transactional
	@Override
	public int deleteByPrimaryKey(Integer asksId) {
		
		return asksVoMapper.deleteByPrimaryKey(asksId);
	}

	
	@Transactional
	@Override
	public int insert(AsksVo record) {
		
		return asksVoMapper.insert(record);
	}

	@Transactional
	@Override
	public int insertSelective(AsksVo record) {
		
		return asksVoMapper.insertSelective(record);
	}

	@Override
	public AsksVo selectByPrimaryKey(Integer asksId) {
		
		return asksVoMapper.selectByPrimaryKey(asksId);
	}

	@Transactional
	@Override
	public int updateByPrimaryKeySelective(AsksVo record) {
		
		return asksVoMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional
	@Override
	public int updateByPrimaryKey(AsksVo record) {
		
		return asksVoMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<AsksVo> findAll() {
		
		return asksVoMapper.findAll();
	}

}