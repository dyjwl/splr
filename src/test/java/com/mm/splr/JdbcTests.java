package com.mm.splr;

import com.mm.splr.model.Student;
import com.mm.splr.model.StudentRowMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
class JdbcTests {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void querytest() throws SQLException {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from student ");
        System.out.println(list.size());
        Assert.assertNotNull(list);
        Assert.assertEquals(7,list.size());
    }

    @Test
    public void save2() {
        Student student = new Student("李四",1,20);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int id = jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("insert into student (name,sex,age) values (?,?,?);", Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, student.getName());
                ps.setInt(2, student.getSex());
                ps.setInt(3, student.getAge());
                return ps;
            }
        }, keyHolder);
        student.setId(keyHolder.getKey().longValue());
        System.out.println(keyHolder.getKey().longValue());
    }

    @Test
    void rowMapper() {
        List<Student> students = jdbcTemplate.query("SELECT * FROM student", new StudentRowMapper());
        for(Student student : students){
            System.out.println("id:"+student.getId()+",name:"+student.getName());
        }
    }
}
