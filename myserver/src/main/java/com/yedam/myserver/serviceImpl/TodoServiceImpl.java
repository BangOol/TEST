package com.yedam.myserver.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.myserver.todo.mapper.TodoMapper;
import com.yedam.myserver.todo.service.TodoService;
import com.yedam.myserver.todo.vo.TodoVO;

@Service
public class TodoServiceImpl implements TodoService{
	@Autowired TodoMapper mapper;
	@Override
	public List<TodoVO> findAll() {
		// TODO Auto-generated method stub
		return mapper.findAll();
	}

	@Override
	@Transactional
	public void persist(TodoVO vo) {
		mapper.persist(vo);	// autoCommit
		//mapper.persist(vo); // error - rollback check
	}

	@Override
	public void merge(TodoVO vo) {
		mapper.merge(vo);

	}

	@Override
	public void remove(TodoVO vo) {
		mapper.remove(vo);

	}
	
}
