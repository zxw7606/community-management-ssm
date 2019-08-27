package group.slsd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import group.slsd.service.OwnerService;

@RestController
public class HelloController {
	
	@Autowired
	private OwnerService ownerService;

	@RequestMapping("hello")
	public Object hello() {
		System.out.println("///");
		return ownerService.selectByPrimaryKey(0);
	}
}
