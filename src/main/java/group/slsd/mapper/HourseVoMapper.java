package group.slsd.mapper;

import group.slsd.vo.HourseVo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HourseVoMapper {
    int deleteByPrimaryKey(Integer hid);

    int insert(HourseVo record);

    int insertSelective(HourseVo record);

    HourseVo selectByPrimaryKey(Integer hid);

    int updateByPrimaryKeySelective(HourseVo record);

    int updateByPrimaryKey(HourseVo record);

	List<HourseVo> findAll();
}