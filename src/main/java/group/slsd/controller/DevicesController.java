package group.slsd.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import group.slsd.service.DevicesService;
import group.slsd.vo.DevicesVo;
import group.slsd.vo.ManVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(tags = "设备")
@RequestMapping("/devices")
public class DevicesController {

	@Autowired
	private DevicesService devicesService;
	
	@ApiOperation("添加设备")
	@PostMapping("addDevices")
	public ResponseEntity<String> addDevices(DevicesVo devicesVo) {
		devicesService.insertSelective(devicesVo);
		return ResponseEntity.ok("200");
	}
	
	@ApiOperation("获取设备")
	@GetMapping
	public Object getDevices() {
//		Page<Object> page = PageHelper.startPage(1,3);
		List<DevicesVo> list = devicesService.findAll();
//		HashMap<String, Object> map = new HashMap<String, Object>();
//		PageInfo<Object> pageInfo = new PageInfo<Object>(page.getResult());
//		map.put("page", pageInfo);
//		map.put("data", list);
		return list;
	}
	
	@ApiOperation(value = "根据主键查询设备", notes = "根据url的id来获取设备详细信息")
	@GetMapping("/getDevicesById")
	public Object selectByPrimaryKey(@RequestParam(required = true) Integer dId) {
		return devicesService.selectByPrimaryKey(dId);
	}
	

	
	
//	@ApiOperation("根据Id删除管理员")
//	@PostMapping("deleteManById")
//	public ResponseEntity<String> deleteByPrimaryKey(@ApiParam("管理员主键") @RequestParam(required = true) Integer manId) {
//		log.info("manId = {}", manId);
//		int num = manVoService.deleteByPrimaryKey(manId);
//		log.info("manId = {} , num = {} ", manId, num);
//		return ResponseEntity.ok("200");
//	}
//
//	@ApiOperation("更新管理员字段")
//	@PostMapping("updateManById")
//	public ResponseEntity<String> updateManById(@ApiParam("管理员实体")  ManVo manVo) {
//		int num = manVoService.updateByPrimaryKeySelective(manVo);
//		log.info(" num = {} ", num);
//		return ResponseEntity.ok("200");
//	}
//
//	@ApiOperation("批量删除管理员")
//	@PostMapping("batchDeleteMansById")
//	public ResponseEntity<String> batchDeleteMansById(@RequestParam String ids) {
//		String[] idStringArr = ids.split(",");
//		Integer[] idIntegerArr = new Integer[idStringArr.length];
//		for (int i = 0; i < idStringArr.length; i++) {
//			idIntegerArr[i] = Integer.valueOf(idStringArr[i]);
//		}
//
//		int num = manVoService.batchDeleteManByIds(idIntegerArr);
//		log.info(" num = {} ", num);
//		return ResponseEntity.ok("200");
//	}
//	
//	@ApiOperation("通过字段查询管理员")
//	@GetMapping("searchMansByParameter")
//	public List searchMansByParameter(@ApiParam("管理员查询字段") ManVo manVo) {
//		
//		List<ManVo> manList =  manVoService.searchMansByParameter(manVo);
//		return manList;
//	}

	
}
