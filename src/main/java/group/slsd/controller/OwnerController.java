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
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

@RestController
@Api(tags = "业主")
@RequestMapping("/owner")
@Slf4j
public class OwnerController {
	@Autowired
	private OwnerService ownerService;

	@ApiOperation("添加业主")
	@PostMapping("addOwner")
	public ResponseEntity<String> addOwner(OwnerVo ownerVo) {
		int num = ownerService.insertSelective(ownerVo);
		log.info("添加业主 { }" , num);
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
	
	@ApiOperation("通过字段查询业主")
	@GetMapping("searchOwnersByParameter")
	public List searchOwnersByParameter(@ApiParam("业主查询字段") OwnerVo ownerVo) {
		List<OwnerVo> manList =  ownerService.searchOwnersByParameter(ownerVo);
		return manList;
	}
	
	@ApiOperation("批量删除业主")
	@PostMapping("batchDeleteMansById")
	public ResponseEntity<String> batchDeleteMansById(@RequestParam String ids) {
		String[] idStringArr = ids.split(",");
		Integer[] idIntegerArr = new Integer[idStringArr.length];
		for (int i = 0; i < idStringArr.length; i++) {
			idIntegerArr[i] = Integer.valueOf(idStringArr[i]);
		}

		int num = ownerService.batchDeleteManByIds(idIntegerArr);
		log.info(" num = {} ", num);
		return ResponseEntity.ok("200");
	}
	
	@ApiOperation("更新业主字段")
	@PostMapping("updateManById")
	public ResponseEntity<String> updateManById(@ApiParam("管理员实体")  OwnerVo ownerVo) {
		int num = ownerService.updateByPrimaryKeySelective(ownerVo);
		log.info(" num = {} ", num);
		return ResponseEntity.ok("200");
	}
	
	
	@ApiOperation("根据Id删除业主")
	@PostMapping("deleteManById")
	public ResponseEntity<String> deleteByPrimaryKey(@ApiParam("业主主键") @RequestParam(required = true) Integer ownerId) {
		log.info("ownerId = {}", ownerId);
		int num = ownerService.deleteByPrimaryKey(ownerId);
		log.info("ownerId = {} , num = {} ", ownerId, num);
		return ResponseEntity.ok("200");
	}


}
