package com.demo;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentResource {

	@Autowired
	StudentRepository repo;

	@RequestMapping("student")
	public List<Student> getList() {

		List<Student> stdlist = (List<Student>) repo.findAll();
		return stdlist;

	}
	
	@DeleteMapping("delete/{id}")
	public Student deleteStudent(@PathParam("id")int id) {
		Student std = (Student) repo.findAll();
		if(std.getId()!=0) {
			repo.deleteById(id);
		}
		return std;

	}

}
