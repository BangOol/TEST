package com.yedam.myserver.users.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.myserver.users.mapper.UserMapper;
import com.yedam.myserver.users.vo.UserVO;

@CrossOrigin(origins = {"*"}, maxAge = 3600)
@RestController
public class UserController {

	@Autowired UserMapper mapper;
	
	//전체 조회
	@GetMapping("/users")
	public List<UserVO> userSelect() {
		return mapper.find();
	}
	
	// 단건 조회
	@GetMapping("/users/{id}")
	public UserVO userSelectList(@PathVariable String id, UserVO vo) {
		vo.setId(id);
		return mapper.findById(vo);
	}
		
	// 등록(query string)
	@PostMapping("/users")
	public UserVO userInsert(UserVO vo) {
		 mapper.persist(vo);
		 return vo;
	}
	// 수정 (parameter(json string))
	@PutMapping("/users")
	public UserVO userUpdate(@RequestBody UserVO vo) {
		 mapper.merge(vo);
		 return vo;
	}	
	// 삭제
	@DeleteMapping("/userDelete/{id}")
	public UserVO userDelete(@RequestBody String id, UserVO vo) {
		vo.setId(id);
		 mapper.remove(vo);
		 return vo;
	}		
}
