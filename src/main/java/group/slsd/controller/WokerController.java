package group.slsd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import group.slsd.service.WorkerService;
import group.slsd.vo.WorkerVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "员工")
@RestController("/worker")
public class WokerController {
	@Autowired
	private WorkerService workerService;

	@ApiOperation("添加管理员")
	@PostMapping("addWorker")
	public ResponseEntity<String> addOwner(@RequestParam WorkerVo WokerVo) {
		workerService.insertSelective(WokerVo);
		return ResponseEntity.ok("200");
	}

	@ApiOperation("获取所有管理员")
	@GetMapping("getAllWorker")
	public Object getWorker() {
		List<WorkerVo> list = workerService.findAll();
		return list;
	}

	@ApiOperation(value = "根据主键查询业主", notes = "根据url的id来获取用户详细信息")
	@GetMapping("/getWorkerById")
	public Object selectByPrimaryKey(@RequestParam(required = true) Integer workerId) {
		return workerService.selectByPrimaryKey(workerId);
	}

}
