package group.slsd.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface UserMapper {
	int insert(UserMapper user);
	int selectByPrimaryKey(int UserId);
	
}
