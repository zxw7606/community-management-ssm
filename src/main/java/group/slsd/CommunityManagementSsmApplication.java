package group.slsd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("group.slsd.mapper")
public class CommunityManagementSsmApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommunityManagementSsmApplication.class, args);
	}

}
