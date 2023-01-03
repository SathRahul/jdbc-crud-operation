package com.qsp.prepared_statement_project.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.qsp.prepared_statement_project.dto.Student;
import com.qsp.prepared_statement_project.service.StudentService;

public class StudentController {
	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		StudentService service = new StudentService();
		while(true) {
			System.out.println("1.insert\n2.getById\n3.update\n4.delete\n5.display");
			System.out.println("choose your option");
			int choice = scanner.nextInt();
			switch(choice) {
			case 1:{
				System.out.println("how many person you qwant to add data");
				int size = scanner.nextInt();
				List<Student> list= new ArrayList<Student>();
				for(int i=0;i<size;i++) {
					Student student = new Student();
					System.out.println("Enter the student Id");
					student.setId(scanner.nextInt());
					System.out.println("Enter the student Name");
					student.setName(scanner.next());
					System.out.println("Enter the student Email");
					student.setEmail(scanner.next());
					list.add(student);
			}
				service.insertStudent(list);
		}break;
			case 2: {
				System.out.println("enter the id to fetch the data");
				int id =service.getById(scanner.nextInt());
				System.out.println();
			}break;
			case 3:{
				System.out.println("1.updateByname\n2.updateByemail\n3.uodate");
				System.out.println("enter the choice");
				int ch = scanner.nextInt();
				switch(ch) {
				case 1: {
					System.out.println("enter the id to update the student data");
					int id =scanner.nextInt();
					System.out.println("enter the new name");
					String name= scanner.next();
					service.updateStudentByName(id, name);
					System.out.println("data updated name...");
				}break;
				case 2:{
					System.out.println("enter the id to update the student data");
					int id =scanner.nextInt();
					System.out.println("enter the new email");
					String email= scanner.next();
					service.updateStudentByEmail(id, email);
					System.out.println("data updated email...");
				}break;
				case 3:{
					return;
				}
				
				}
	
			}break;
			case 4:{
				System.out.println("enter the id to delete the data");
				int id =scanner.nextInt();
				service.deleteStudent(id);
				System.out.println("id is deleted succesfully");
			}break;
			case 5: {
				List<Student> students=service.displayStudents();
				for(Student student : students) {
					System.out.println("id="+student.getId());
					System.out.println("name"+ student.getName());
					System.out.println("email"+ student.getEmail());
				}
				//System.out.println("data displayed");
				
			}break;
			}
		}
	}
}
			
		
				
		
			

