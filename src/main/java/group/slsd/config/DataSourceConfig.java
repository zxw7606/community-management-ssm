package group.slsd.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DataSourceConfig {

	/**
	 * @Title：Spring-jdbc dataSourceTransactionManager 。
	 * @Description：数据库事务
	 */
	@Bean
	public PlatformTransactionManager dataSourceTransactionManager(DataSource dataSource) {
		DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(dataSource);
		return dataSourceTransactionManager;
	}

	/**
	 * 
	 * @Title：SqlSessionFactory
	 * @Description：mybaits配置
	 */
	@Bean
	public SqlSessionFactoryBean SqlSessionFactory(DataSource dataSource) throws IOException {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource);

		PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
		Resource[] mapperLocations = pathMatchingResourcePatternResolver
				.getResources("classpath*:group/slsd/mapper/xml/*.xml");
		factoryBean.setMapperLocations(mapperLocations);
		factoryBean.setTypeAliasesPackage("group.slsd.vo");
		return factoryBean;
	}
}
