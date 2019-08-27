package group.slsd.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import group.slsd.service.OwnerService;
import group.slsd.vo.OwnerVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "业主")
@RequestMapping("/owner")
public class OwnerController {
	@Autowired
	private OwnerService ownerService;

	@ApiOperation("添加用户")
	@PostMapping("addOwner")
	public ResponseEntity<String> addOwner(OwnerVo ownerVo) {
		return ResponseEntity.ok("200");
	}

	@GetMapping("getAllOwner")
	public Object getOwner() {
		Page<Object> page = PageHelper.startPage(1, 3);
		List<OwnerVo> list = ownerService.findAll();
//		LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
		HashMap<String,Object> map = new HashMap<String, Object>();
		PageInfo<Object> pageInfo = new PageInfo<>(page.getResult());
		map.put("page", pageInfo);
		map.put("data", list);
		return map;
	}

	@ApiOperation(value = "根据主键查询业主", notes = "根据url的id来获取用户详细信息")
	@GetMapping("/getOwnerById")
	public Object selectByPrimaryKey(@RequestParam(required = true) Integer ownerId) {
		return ownerService.selectByPrimaryKey(ownerId);
	}

}
