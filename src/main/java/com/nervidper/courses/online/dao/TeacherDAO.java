package com.nervidper.courses.online.dao;

import com.nervidper.courses.online.model.Teacher;

public interface TeacherDAO {
	
	public Teacher findTeacherByEmail(String email);

}
