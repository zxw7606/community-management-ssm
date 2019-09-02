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

import group.slsd.service.AsksService;
import group.slsd.service.CarPostionService;
import group.slsd.service.ManVoServiceImpl;
import group.slsd.service.OwnerService;
import group.slsd.service.WorkerService;
import group.slsd.vo.CarPostionVo;
import group.slsd.vo.ManVo;
import group.slsd.vo.OwnerVo;
import group.slsd.vo.WorkerVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/car")
@Api(tags = "停车位")
@Slf4j
public class CarPostionController {
	
	
	@Autowired
	private CarPostionService carPostionService;

	@ApiOperation("添加停车位")
	@PostMapping("addPosition")
	public ResponseEntity<String> addAsks(CarPostionVo CarPostionVo) {
		carPostionService.insertSelective(CarPostionVo);
		return ResponseEntity.ok("200");
	}

	@ApiOperation("获取所有停车位")
	@GetMapping("getAllPositions")
	public Object getAllPositions() {
		List<CarPostionVo> Askslist = carPostionService.findAll();
		
		return Askslist;
	}

	@ApiOperation(value = "根据主键查询停车位")
	@GetMapping("/getPositionById/{positionId}")
	public Object selectByPrimaryKey(@PathVariable("asksId") @ApiParam("用户id") Integer asksId) {
		return carPostionService.selectByPrimaryKey(asksId);
	}

	@ApiOperation("根据Id删除停车位")
	@PostMapping("deletePositionById")
	public ResponseEntity<String> deleteByPrimaryKey(@ApiParam("投诉主键") @RequestParam(required = true) Integer asksId) {
		log.info("asksId = {}", asksId);
		int num = carPostionService.deleteByPrimaryKey(asksId);
		log.info("asksId = {} , num = {} ", asksId, num);
		return ResponseEntity.ok("200");
	}

	@ApiOperation("更新停车位字段")
	@PostMapping("updatePositionById")
	public ResponseEntity<String> updateAsksById(@ApiParam("投诉实体") CarPostionVo CarPostionVo) {
		int num = carPostionService.updateByPrimaryKeySelective(CarPostionVo);
		log.info(" num = {} ", num);
		return ResponseEntity.ok("200");
	}

	@ApiOperation("批量删除停车位")
	@PostMapping("batchDeletePositionById")
	public ResponseEntity<String> batchDeleteAsksById(@RequestParam String ids) {
		String[] idStringArr = ids.split(",");
		Integer[] idIntegerArr = new Integer[idStringArr.length];
		for (int i = 0; i < idStringArr.length; i++) {
			idIntegerArr[i] = Integer.valueOf(idStringArr[i]);
		}

		int num = carPostionService.batchDeleteAsksByIds(idIntegerArr);
		log.info(" num = {} ", num);
		return ResponseEntity.ok("200");
	}

	@ApiOperation("通过字段查询停车位")
	@GetMapping("searchPositionByParameter")
	public List searchAsksByParameter(@ApiParam("车辆查询字段") CarPostionVo CarPostionVo) {
		List<CarPostionVo> asksList = carPostionService.searchAsksByParameter(CarPostionVo);
		return asksList;
	}


}
