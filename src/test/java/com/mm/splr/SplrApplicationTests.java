package com.mm.splr;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mm.splr.mapper.StudentMapper;
import com.mm.splr.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootTest
class SplrApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private JdbcTemplate primaryJdbcTemplate;

	@Autowired
	private JdbcTemplate secondaryJdbcTemplate;

	@Autowired
	private StudentMapper studentMapper;

	@Test
	public void dataSourceTest(){
		Student student = new Student("weiz多数据源",0,30);
		primaryJdbcTemplate.update("INSERT INTO student(name, sex, age) values(?, ?, ?)",
				student.getName(), student.getSex(), student.getAge());

		secondaryJdbcTemplate.update("INSERT INTO student(name, sex, age) values(?, ?, ?)",
				student.getName(), student.getSex(), student.getAge());
	}

	@Test
	public void testSelectListPaged() {
		PageHelper.startPage(1, 5);
		List<Student> students = studentMapper.selectAll();
		PageInfo<Student> pageInfo = new PageInfo<Student>(students);
		System.out.println("总页数:"+pageInfo.getPages()+",总条数:"+pageInfo.getTotal()+",当前页:"+pageInfo.getPageNum());
		for (Student stu : students){
			System.out.println("name:"+stu.getName()+",age:"+stu.getAge());
		}
	}
}
