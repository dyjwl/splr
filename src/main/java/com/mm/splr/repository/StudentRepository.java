package com.mm.splr.repository;


import com.mm.splr.model.Student;

public interface StudentRepository {
    int save(Student user);
    int update(Student user);
    int delete(long id);
    Student findById(long id);
}
