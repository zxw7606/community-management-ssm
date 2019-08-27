package group.slsd.mapper;

import org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import group.slsd.service.OwnerService;
import group.slsd.vo.OwnerVo;

@RunWith(SpringRunner.class)
@SpringBootTest

public class MapperTest {

	@Autowired
	private OwnerService ownerService;

	@Test
	public void OwnerVoMapperTest() {

		OwnerVo key = ownerService.selectByPrimaryKey(0);
		Assert.assertNotNull(key);
	}

}
