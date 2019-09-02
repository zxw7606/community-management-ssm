package group.slsd.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import group.slsd.service.HourseService;
import group.slsd.service.ManVoServiceImpl;
import group.slsd.service.OwnerService;
import group.slsd.service.WorkerService;
import group.slsd.vo.HourseVo;
import group.slsd.vo.HourseVo;
import group.slsd.vo.ManVo;
import group.slsd.vo.OwnerVo;
import group.slsd.vo.WorkerVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/car")
@Api(tags = "楼宇")
@Slf4j
public class HouseController {
	
	
	@Autowired
	private HourseService hourService;

	@ApiOperation("添加楼宇")
	@PostMapping("addHouse")
	public ResponseEntity<String> addhouse(HourseVo hourseVo) {
		hourService.insertSelective(hourseVo);
		return ResponseEntity.ok("200");
	}

	@ApiOperation("获取所有楼宇")
	@GetMapping("getAllHouses")
	public Object getAllHouses() {
		List<HourseVo> houselist = hourService.findAll();
		
		return houselist;
	}

	@ApiOperation(value = "根据主键查询楼宇")
	@GetMapping("/getHouseById/{HouseId}")
	public Object selectByPrimaryKey(@PathVariable("houseId") @ApiParam("用户id") Integer houseId) {
		return hourService.selectByPrimaryKey(houseId);
	}

	@ApiOperation("根据Id删除楼宇")
	@PostMapping("deleteHouseById")
	public ResponseEntity<String> deleteByPrimaryKey(@ApiParam("投诉主键") @RequestParam(required = true) Integer houseId) {
		log.info("houseId = {}", houseId);
		int num = hourService.deleteByPrimaryKey(houseId);
		log.info("houseId = {} , num = {} ", houseId, num);
		return ResponseEntity.ok("200");
	}

	@ApiOperation("更新楼宇字段")
	@PostMapping("updateHouseById")
	public ResponseEntity<String> updatehouseById( HourseVo HourseVo) {
		int num = hourService.updateByPrimaryKeySelective(HourseVo);
		log.info(" num = {} ", num);
		return ResponseEntity.ok("200");
	}


}
