package group.slsd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import group.slsd.service.OwnerService;
import group.slsd.vo.OwnerVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @Api：修饰整个类，描述Controller的作用
 * @ApiOperation：描述一个类的一个方法，或者说一个接口
 * @ApiParam：单个参数描述
 * @ApiModel：用对象来接收参数
 * @ApiProperty：用对象接收参数时，描述对象的一个字段
 * @ApiResponse：HTTP响应其中1个描述
 * @ApiResponses：HTTP响应整体描述
 * @ApiIgnore：使用该注解忽略这个API
 * @ApiError ：发生错误返回的信息
 * @ApiParamImplicitL：一个请求参数
 * @ApiParamsImplicit 多个请求参数
 * @Description：测试
 * @author 0
 * @date 2019年8月27日 上午9:08:05
 */
@Api(tags = "测试")
@RestController
public class HelloController {

	@Autowired
	private OwnerService ownerService;

	@ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
	@RequestMapping("hello")
	public Object selectByPrimaryKey() {
		System.out.println("///");
		return ownerService.selectByPrimaryKey(0);
	}
}
