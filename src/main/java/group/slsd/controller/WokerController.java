package group.slsd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import group.slsd.service.WorkerService;
import group.slsd.vo.WorkerVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/worker")
@Api(tags = "员工")
@Slf4j
public class WokerController {
	@Autowired
	private WorkerService workerService;

	@ApiOperation("添加员工")
	@PostMapping("addWorker")
	public ResponseEntity<String> addOwner(@RequestParam WorkerVo WokerVo) {
		workerService.insertSelective(WokerVo);
		return ResponseEntity.ok("200");
	}

	@ApiOperation("获取所有员工")
	@GetMapping("getAllWorker")
	public Object getWorker() {
		List<WorkerVo> list = workerService.findAll();
		return list;
	}

	@ApiOperation(value = "根据主键查询员工", notes = "根据url的id来获取用户详细信息")
	@GetMapping("/getWorkerById")
	public Object selectByPrimaryKey(@RequestParam(required = true) Integer workerId) {
		return workerService.selectByPrimaryKey(workerId);
	}

	@ApiOperation("根据Id删除员工")
	@PostMapping("deleteWorkerById")
	public ResponseEntity<String> deleteByPrimaryKey(@ApiParam("员工主键") @RequestParam(required = true) Integer workerId) {
		log.info("workerId = {}", workerId);
		int num = workerService.deleteByPrimaryKey(workerId);
		log.info("workerId = {} , num = {} ", workerId, num);
		return ResponseEntity.ok("200");
	}
	
	@ApiOperation("更新员工字段")
	@PostMapping("updateWorkerById")
	public ResponseEntity<String> updateWorkerById(@ApiParam("员工实体")  WorkerVo workerVo) {
		int num = workerService.updateByPrimaryKeySelective(workerVo);
		log.info(" num = {} ", num);
		return ResponseEntity.ok("200");
	}

	
	
	@ApiOperation("批量删除管理员")
	@PostMapping("batchDeleteWorkersById")
	public ResponseEntity<String> batchDeleteWorkerById(@RequestParam String ids) {
		String[] idStringArr = ids.split(",");
		Integer[] idIntegerArr = new Integer[idStringArr.length];
		for (int i = 0; i < idStringArr.length; i++) {
			idIntegerArr[i] = Integer.valueOf(idStringArr[i]);
		}

		int num = workerService.batchDeleteWorkerByIds(idIntegerArr);
		log.info(" num = {} ", num);
		return ResponseEntity.ok("200");
	}
	
	@ApiOperation("通过字段查询管理员")
	@GetMapping("searchWorkersByParameter")
	public List searchWorkersByParameter(@ApiParam("管理员查询字段") WorkerVo workerVo) {
		List<WorkerVo> WorkerList =  workerService.searchWorkerByParameter(workerVo);
		return WorkerList;
	}
}
