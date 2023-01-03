package com.qsp.prepared_statement_project.service;

import java.util.List;

import com.qsp.prepared_statement_project.dao.StudentDao;
import com.qsp.prepared_statement_project.dto.Student;

public class StudentService {
	StudentDao dao = new StudentDao();
	public void insertStudent(List<Student> students) {
		dao.insertStudent(students);
}
 public int getById(int id) {
	return dao.getById(id);	
		
	}
 public void updateStudent(int id,String name) {
	 if(id==dao.getById(id)) {
		 dao.updateStudent(id, name);
	 }else {
		 System.out.println("given id is not present");
	 }
 }
	 public void updateStudentByEmail(int id,String email) {
	 
		 if(id==dao.getById(id)) {
			 dao.updateStudent(id, email);
		 }else {
			 System.out.println("given id is not present");
		 }
	 }
		 public void updateStudentByName(int id,String name) {
			 if(id==dao.getById(id)) {
				 dao.updateStudent(id, name);
			 }else {
				 System.out.println("given id is not present");
		 }
		 }
			 //delete method
			 public int deleteStudent(int id) {
				 return dao.deleteStudent(id);
				 
			 }
			 public List<Student> displayStudents(){
				return dao.displayStudents();
				
			 }
	 } 
 
