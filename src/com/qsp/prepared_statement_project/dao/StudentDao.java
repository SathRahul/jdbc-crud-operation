package com.qsp.prepared_statement_project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qsp.prepared_statement_project.connection.StudentConnection;
import com.qsp.prepared_statement_project.controller.StudentController;
import com.qsp.prepared_statement_project.dto.Student;

public class StudentDao {
	Connection connection = null;
	public void insertStudent(List<Student> students) {
		connection = StudentConnection.getConnection();
		try {
			String insert = "insert into student value(?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(insert);
			for (Student student : students) {
				preparedStatement.setInt(1, student.getId());
				preparedStatement.setString(2, student.getName());
				preparedStatement.setString(3, student.getEmail());
				System.out.println(student.getId());
				preparedStatement.addBatch();
			}
			preparedStatement.executeBatch();
			System.out.println("data inserted");
		}catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		
	}

//getById
public int getById(int id) {
	connection=StudentConnection.getConnection();
	String select= "select*from student where id=?";
	try {
	PreparedStatement preparedStatement=connection.prepareStatement(select);
	preparedStatement.setInt(1, id);
	ResultSet resultSet=preparedStatement.executeQuery();
	resultSet.next();
	int id1 = resultSet.getInt("id");
	return id1;
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return 0;
}	
	
//update method
public void updateStudent(int id,String name) {
	connection=StudentConnection.getConnection();
	String update = "update student set name=?where id=?";
	try {
	PreparedStatement preparedStatement=connection.prepareStatement(update);
	preparedStatement.setInt(2, id);
	preparedStatement.setString(1, name);
	preparedStatement.executeUpdate();
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
	public void updateStudentByEmail(int id,String email) {
		connection=StudentConnection.getConnection();
		String update = "update student set email=?where id=?";
		try {
		PreparedStatement preparedStatement=connection.prepareStatement(update);
		preparedStatement.setInt(2, id);
		preparedStatement.setString(1, email);
		preparedStatement.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
	}
	}
		public void updateStudentByName(int id,String name) {
			connection=StudentConnection.getConnection();
			String update = "update student set name=?where id=?";
			try {
			PreparedStatement preparedStatement=connection.prepareStatement(update);
			preparedStatement.setInt(2, id);
			preparedStatement.setString(1, name);
			preparedStatement.executeUpdate();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
		}
		}
		//deletemethod
		public int deleteStudent(int id ) {
			connection = StudentConnection.getConnection();
			String delete = "delete from student where id =?";

			try {
				PreparedStatement preparedStatement=connection.prepareStatement(delete);
				preparedStatement.setInt(1, id);
				preparedStatement.execute();
			}catch (Exception e) {
				e.printStackTrace();

			}// TODO: handle exception
			return id;
}	
		//displayMethod
		public List<Student> displayStudents() 
		{
			connection = StudentConnection.getConnection();
			String select = "SELECT * FROM student";
			try {

				PreparedStatement preparedStatement =connection.prepareStatement(select);

				ResultSet resultSet= preparedStatement.executeQuery(select);
				List<Student> list = new ArrayList<Student>();
				
				while(resultSet.next()) {
					
					Student student = new Student();
					
					student.setId(resultSet.getInt("id"));
					student.setName(resultSet.getString("name"));
					student.setEmail(resultSet.getString("email"));	
					list.add(student);
				}	
				return list;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
}

