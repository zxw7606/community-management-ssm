package group.slsd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;

import group.slsd.service.ManVoServiceImpl;
import group.slsd.service.WorkerService;
import group.slsd.vo.ManVo;
import group.slsd.vo.WorkerVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/man")
@Api(tags = "管理员")
@Slf4j
public class ManController {
	@Autowired
	private ManVoServiceImpl manVoService;

	@ApiOperation("添加管理员")
	@PostMapping("addMan")
	public ResponseEntity<String> addMan(ManVo manVo) {
		manVoService.insertSelective(manVo);
		return ResponseEntity.ok("200");
	}

	@ApiOperation("获取所有管理员")
	@GetMapping("getAllMan")
	public Object getWorker() {
		
		List<ManVo> manlist = manVoService.findAll();
		return manlist;
	}

	@ApiOperation(value = "根据主键查询管理员")
	@GetMapping("/getManById/{manId}")
	public Object selectByPrimaryKey(@PathVariable("manId") Integer manId) {
		return manVoService.selectByPrimaryKey(manId);
	}
	
	@ApiOperation("根据Id删除管理员")
	@PostMapping("deleteManById")
	public ResponseEntity<String> deleteByPrimaryKey(@ApiParam("管理员主键") @RequestParam(required = true)Integer manId) {
		log.info("manId = {}",manId);
		int num = manVoService.deleteByPrimaryKey(manId);
		log.info("manId = {} , num = {} ",manId, num);
		return ResponseEntity.ok("200");
	}
	@ApiOperation("更新管理员字段")
	@PostMapping("updateManById")
	public ResponseEntity<String> updateManById(@ApiParam("管理员实体") @RequestParam ManVo manVo){
		int num = manVoService.updateByPrimaryKeySelective(manVo);
		log.info(" num = {} ", num);
		return ResponseEntity.ok("200");
	}
	

}
