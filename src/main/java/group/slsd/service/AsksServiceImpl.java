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

	public int deleteByPrimaryKey(Integer asksId) {

		return asksVoMapper.deleteByPrimaryKey(asksId);
	}

	@Transactional
	public int insert(AsksVo record) {

		return asksVoMapper.insert(record);
	}

	@Transactional
	public int insertSelective(AsksVo record) {

		return asksVoMapper.insertSelective(record);
	}

	public AsksVo selectByPrimaryKey(Integer asksId) {

		return asksVoMapper.selectByPrimaryKey(asksId);
	}

	@Transactional
	public int updateByPrimaryKeySelective(AsksVo record) {

		return asksVoMapper.updateByPrimaryKeySelective(record);
	}

	@Transactional
	public int updateByPrimaryKey(AsksVo record) {

		return asksVoMapper.updateByPrimaryKey(record);
	}

	public List<AsksVo> findAll() {

		return asksVoMapper.findAll();
	}

	@Override
	public int batchDeleteAsksByIds(Integer[] ids) {
		return asksVoMapper.batchDeleteAsksByIds(ids);
	}

	@Override
	public List<AsksVo> searchAsksByParameter(AsksVo record) {
		return asksVoMapper.searchAsksByParameter(record);
	}

}