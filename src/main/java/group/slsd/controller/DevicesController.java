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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

@RestController
@Api(tags = "设备")
@RequestMapping("/devices")
@Slf4j
public class DevicesController {

	@Autowired
	private DevicesService devicesService;
	
	@ApiOperation("添加设备")
	@PostMapping("addDevices")
	public ResponseEntity<String> addDevices(DevicesVo devicesVo) {
		devicesService.insertSelective(devicesVo);
		return ResponseEntity.ok("200");
	}
	
	@ApiOperation("获取所有设备")
	@GetMapping("getAllDevices")
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
	
	@ApiOperation("根据Id删除设备")
	@PostMapping("deleteDevicesById")
	public ResponseEntity<String> deleteByPrimaryKey(@ApiParam("管理员主键") @RequestParam(required = true) Integer dId) {
		log.info("dId = {}", dId);
		int num = devicesService.deleteByPrimaryKey(dId);
		log.info("dId = {} , num = {} ", dId, num);
		return ResponseEntity.ok("200");
	}

	@ApiOperation("更新管理员字段")
	@PostMapping("updateDevicesById")
	public ResponseEntity<String> updateDevicesById(@ApiParam("管理员实体")  DevicesVo devicesVo) {
		int num = devicesService.updateByPrimaryKeySelective(devicesVo);
		log.info(" num = {} ", num);
		return ResponseEntity.ok("200");
	}

	@ApiOperation("批量删除管理员")
	@PostMapping("batchDeleteDevicessById")
	public ResponseEntity<String> batchDeleteDevicessById(@RequestParam String ids) {
		String[] idStringArr = ids.split(",");
		Integer[] idIntegerArr = new Integer[idStringArr.length];
		for (int i = 0; i < idStringArr.length; i++) {
			idIntegerArr[i] = Integer.valueOf(idStringArr[i]);
		}

		int num = devicesService.batchDeleteDevicesByIds(idIntegerArr);
		log.info(" num = {} ", num);
		return ResponseEntity.ok("200");
	}
	
	@ApiOperation("通过字段查询管理员")
	@GetMapping("searchDevicessByParameter")
	public List searchDevicessByParameter(@ApiParam("管理员查询字段") DevicesVo devicesVo) {
		
		List<DevicesVo> devicesList =  devicesService.searchDevicesByParameter(devicesVo);
		return devicesList;
	}

	
}
