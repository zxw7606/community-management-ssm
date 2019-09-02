package group.slsd.mapper;

import group.slsd.vo.MesVo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MesVoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MesVo record);

    int insertSelective(MesVo record);

    MesVo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MesVo record);

    int updateByPrimaryKey(MesVo record);

	List<MesVo> findAll();

}