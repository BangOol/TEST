package com.yedam.myserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.myserver.emp.vo.Employee;

@RestController

public class AjaxController {
	@GetMapping("req")
	public String regGet() {
		return "get";
	}
	
	@PostMapping("req")
	@ResponseBody // java 객체를 json String으로 변환
	//@RequestBody => json String parsing -> VO 객체 변화
	public String regPost(@RequestBody Employee vo) throws InterruptedException {
//		Thread.sleep(3000);
		System.out.println(vo.getFirst_name());
		return "post";
	}
}
