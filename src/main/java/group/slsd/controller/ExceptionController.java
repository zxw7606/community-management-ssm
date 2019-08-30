package group.slsd.controller;

import java.nio.file.AccessDeniedException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class ExceptionController {

	
	@ResponseBody
	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<String> Forbidden(){
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body("forbidden");
	}
}
