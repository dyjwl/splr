package com.mm.splr.repository.impl;


import com.mm.splr.model.Student;
import com.mm.splr.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
//    @Autowired
//    private JdbcTemplate jdbcTemplate;

    @Autowired
    private JdbcTemplate primaryJdbcTemplate;

    @Autowired
    private JdbcTemplate secondaryJdbcTemplate;

    @Override
    public int save(Student user) {
        return primaryJdbcTemplate.update("INSERT INTO Student(name, sex, age) values(?, ?, ?)",
                user.getName(), user.getSex(), user.getAge());
    }

    @Override
    public int update(Student user) {
        return primaryJdbcTemplate.update("UPDATE Student SET name = ? , sex = ? , age = ?  WHERE id=?",user.getName(), user.getSex(), user.getAge(), user.getId());
    }


    @Override
    public int delete(long id) {
        return primaryJdbcTemplate.update("DELETE FROM Student where id = ? ",id);
    }

    @Override
    public Student findById(long id) {
        return primaryJdbcTemplate.queryForObject("SELECT * FROM Student WHERE id=?", new Object[] { id }, new BeanPropertyRowMapper<Student>(Student.class));
    }

}
