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
import group.slsd.service.HourseService;
import group.slsd.service.ManVoServiceImpl;
import group.slsd.service.MesService;
import group.slsd.service.OwnerService;
import group.slsd.service.WorkerService;
import group.slsd.vo.CarPostionVo;
import group.slsd.vo.ManVo;
import group.slsd.vo.MesVo;
import group.slsd.vo.OwnerVo;
import group.slsd.vo.WorkerVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

//@RestController
@RequestMapping("/mes")
@Api(tags = "公告消息")
@Slf4j
public class MesController {
	
	@Autowired
	private MesService mesService;

	@ApiOperation("添加消息")
	@PostMapping("addMes")
	public ResponseEntity<String> addAsks(MesVo mesVo) {
		mesService.insertSelective(mesVo);
		return ResponseEntity.ok("200");
	}

	@ApiOperation("获取所有停车位")
	@GetMapping("getAllMess")
	public Object getAllPositions() {
		List<MesVo> meslist = mesService.findAll();
		
		return meslist;
	}

	@ApiOperation(value = "根据主键查询消息")
	@GetMapping("/getMesById/{mesId}")
	public Object selectByPrimaryKey(@PathVariable("asksId") @ApiParam("用户id") Integer asksId) {
		return mesService.selectByPrimaryKey(asksId);
	}

	@ApiOperation("根据Id删除停车位")
	@PostMapping("deleteMesById")
	public ResponseEntity<String> deleteByPrimaryKey(@ApiParam("消息id") @RequestParam(required = true) Integer mesId) {
		log.info("asksId = {}", mesId);
		int num = mesService.deleteByPrimaryKey(mesId);
		log.info("asksId = {} , num = {} ", mesId, num);
		return ResponseEntity.ok("200");
	}

	@ApiOperation("更新停车位字段")
	@PostMapping("updateMesById")
	public ResponseEntity<String> updateAsksById( MesVo MesVo) {
		int num = mesService.updateByPrimaryKeySelective(MesVo);
		log.info(" num = {} ", num);
		return ResponseEntity.ok("200");
	}



}
