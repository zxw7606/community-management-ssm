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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import group.slsd.service.AsksService;
import group.slsd.service.ManVoServiceImpl;
import group.slsd.service.OwnerService;
import group.slsd.service.WorkerService;
import group.slsd.vo.AsksVo;
import group.slsd.vo.ManVo;
import group.slsd.vo.OwnerVo;
import group.slsd.vo.WorkerVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/asks")
@Api(tags = "投诉")
@Slf4j
public class AsksController {
	@Autowired
	private AsksService asksService;
	@Autowired
	private OwnerService ownerService;
	@Autowired
	private WorkerService workerService;
	@Autowired
	private ManVoServiceImpl manVoService;

	@ApiOperation("添加投诉")
	@PostMapping("addAsks")
	public ResponseEntity<String> addAsks(AsksVo asksVo) {
		asksService.insertSelective(asksVo);
		return ResponseEntity.ok("200");
	}

	@ApiOperation("获取所有投诉")
	@GetMapping("getAllAsks")
	public Object getWorker() {
		List<AsksVo> Askslist = asksService.findAll();
		if (null == Askslist || Askslist.size() == 0) {
			return null;
		}
		ArrayList<Map> asksVoDetailMapList = new ArrayList<>();
		for (AsksVo asksVo : Askslist) {
			HashMap<String, Object> asksVoDetailMap = new HashMap<String, Object>();
			OwnerVo ownerVo = ownerService.selectByPrimaryKey(asksVo.getaPersonId());
			// WorkerVo workerVo = workerService.selectByPrimaryKey(asksVo.getaEmpId());
			ManVo manVo = manVoService.selectByPrimaryKey(asksVo.getaEmpId());
			asksVoDetailMap.put("owner", ownerVo);
			asksVoDetailMap.put("asks", asksVo);
			asksVoDetailMap.put("man", manVo);

			asksVoDetailMapList.add(asksVoDetailMap);
		}
		return asksVoDetailMapList;
	}

	@ApiOperation(value = "根据主键查询投诉")
	@GetMapping("/getAsksById/{asksId}")
	public Object selectByPrimaryKey(@PathVariable("asksId") @ApiParam("用户id") Integer asksId) {
		return asksService.selectByPrimaryKey(asksId);
	}

	@ApiOperation("根据Id删除投诉")
	@PostMapping("deleteAsksById")
	public ResponseEntity<String> deleteByPrimaryKey(@ApiParam("投诉主键") @RequestParam(required = true) Integer asksId) {
		log.info("asksId = {}", asksId);
		int num = asksService.deleteByPrimaryKey(asksId);
		log.info("asksId = {} , num = {} ", asksId, num);
		return ResponseEntity.ok("200");
	}

	@ApiOperation("更新投诉字段")
	@PostMapping("updateAsksById")
	public ResponseEntity<String> updateAsksById(@ApiParam("投诉实体") AsksVo asksVo) {
		int num = asksService.updateByPrimaryKeySelective(asksVo);
		log.info(" num = {} ", num);
		return ResponseEntity.ok("200");
	}

	@ApiOperation("批量删除投诉")
	@PostMapping("batchDeleteAsksById")
	public ResponseEntity<String> batchDeleteAsksById(@RequestParam String ids) {
		String[] idStringArr = ids.split(",");
		Integer[] idIntegerArr = new Integer[idStringArr.length];
		for (int i = 0; i < idStringArr.length; i++) {
			idIntegerArr[i] = Integer.valueOf(idStringArr[i]);
		}

		int num = asksService.batchDeleteAsksByIds(idIntegerArr);
		log.info(" num = {} ", num);
		return ResponseEntity.ok("200");
	}

	@ApiOperation("通过字段查询投诉")
	@GetMapping("searchAsksByParameter")
	public List searchAsksByParameter(@ApiParam("投诉查询字段") AsksVo asksVo) {
		List<AsksVo> asksList = asksService.searchAsksByParameter(asksVo);
		return asksList;
	}

	@ApiOperation(value = "设置投诉处理结果")
	@PostMapping("/setAsksResultById")
	public Object setAsksResultById(@ApiParam("投诉信息") AsksVo asksVo) {
		asksVo.setaTime(new Date());
		return asksService.updateByPrimaryKeySelective(asksVo);
	}

}
