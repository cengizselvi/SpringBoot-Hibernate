package com.crud.cruddemo.dao;


import com.crud.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

     void save(Student theStudent);

     Student findById(Integer id);

     List<Student> findAll();

     List<Student> findbyLastName(String theLastName);

     void update(Student theStudent);
}
