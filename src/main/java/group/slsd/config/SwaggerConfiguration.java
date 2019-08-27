package group.slsd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfiguration {

	/**
	 * 
	 * @Title：createRestApi
	 * @Description：单页面API
	 * @return ：Docket
	 */
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("group.slsd.controller")).paths(PathSelectors.any()).build()
				.ignoredParameterTypes(ApiIgnore.class).enableUrlTemplating(true);
	}

	/**
	 * @Title：apiInfo
	 * @Description：Api描述信息
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("小区物业 api文档").description("小区物业 api文档")
				// .termsOfServiceUrl("http://blog.csdn.net/saytime")
				.version("1.0").build();
	}
}
