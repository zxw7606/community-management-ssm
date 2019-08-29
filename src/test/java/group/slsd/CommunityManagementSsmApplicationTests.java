package group.slsd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import group.slsd.config.WebSecurityConfig.MyHttpSessionListener;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommunityManagementSsmApplicationTests {

	@Autowired
	private MyHttpSessionListener myHttpSessionListener;
	
    @Test
    public void contextLoads() {
    	Assert.notNull(myHttpSessionListener,"null obj");
    }

}
