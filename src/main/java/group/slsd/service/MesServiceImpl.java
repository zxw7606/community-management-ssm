package group.slsd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import group.slsd.mapper.MesVoMapper;
import group.slsd.vo.MesVo;

@Service
public class MesServiceImpl implements MesService {

	@Autowired
	private MesVoMapper mesVoMapper;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return mesVoMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(MesVo record) {
		return insertSelective(record);
	}

	@Transactional
	@Override
	public int insertSelective(MesVo record) {
		return mesVoMapper.insertSelective(record);
	}

	@Override
	public MesVo selectByPrimaryKey(Integer id) {
		return mesVoMapper.selectByPrimaryKey(id);
	}

	@Transactional
	@Override
	public int updateByPrimaryKeySelective(MesVo record) {
		return mesVoMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(MesVo record) {
		return updateByPrimaryKeySelective(record);
	}

	@Override
	public List<MesVo> findAll() {
		return mesVoMapper.findAll();
	}

}
