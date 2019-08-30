package group.slsd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import group.slsd.mapper.ManVoMapper;
import group.slsd.vo.ManVo;

@Service
public class ManVoServiceImpl {

	@Autowired
	private ManVoMapper manVoMapper;

	@Transactional
	public int insert(ManVo record) {
		return manVoMapper.insert(record);
	}

	@Transactional
	public int insertSelective(ManVo record) {
		return manVoMapper.insertSelective(record);
	}

	public List<ManVo> findAll() {
		return manVoMapper.findAll();
	}

	public ManVo selectByPrimaryKey(Integer manId) {
		return manVoMapper.selectByPrimaryKey(manId);
	}

	public int deleteByPrimaryKey(Integer manId) {
		return manVoMapper.deleteByPrimaryKey(manId);
	}
	
	@Transactional
	public int updateByPrimaryKeySelective(ManVo manVo) {
		return manVoMapper.updateByPrimaryKeySelective(manVo);
	}

	public int batchDeleteManByIds(Integer[] ids) {
		return manVoMapper.batchDeleteManByIds(ids);
	}

	public List<ManVo> searchMansByParameter(ManVo manVO) {
		return manVoMapper.searchMansByParameter(manVO);
	}


	public List<ManVo> selectManByUsername(String username) {
		return manVoMapper.selectManByUsername(username);
	}

}
