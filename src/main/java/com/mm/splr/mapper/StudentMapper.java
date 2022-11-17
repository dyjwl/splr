package com.mm.splr.mapper;

import com.mm.splr.model.Student;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.Map;

public interface StudentMapper {
    @Select("select * from student")
    List<Student> selectAll();

    @Select("select * from student where id=#{id,jdbcType=VARCHAR}")
    Student selectOne(Long id);

    //@Select("select * from student where name=#{name} and sex=#{sex}")
    //Student selectByNameAndSex(@Param("name") String name,@Param("sex")Integer sex);

    //@Select("select * from student where name=#{name} and sex=#{sex}")
    //Student selectByNameAndSex(@Param("name") String name,@Param("sex")Integer sex);


    //@Select("SELECT * FROM student WHERE name = #{param1} and sex = #{param2}")
    //Student selectByNameAndSex(String name, Integer sex);

    @Select("SELECT * FROM student WHERE name = #{name} and sex = #{sex}")
    Student selectByNameAndSex(Map<String, Object> map);

    @Insert({
            "insert into student (",
            "name, ",
            "age, ",
            "sex)",
            "values (",
            "#{name,jdbcType=VARCHAR},",
            "#{age,jdbcType=INTEGER},",
            "#{sex,jdbcType=INTEGER})"
    })
    int insert(Student record);

    @Update({
            "update student",
            "set name =#{name,jdbcType=VARCHAR},",
            "age=#{age,jdbcType=INTEGER},",
            "sex=#{sex,jdbcType=INTEGER}",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    void update(Student record);

    @Select("delete from student where id=#{id,jdbcType=VARCHAR}")
    void delete(Long id);

    @Select({
            "select",
            "id, name as student_name,age, sex as student_sex",
            "from student",
            "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.VARCHAR, id=true),
            @Result(column="student_name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="student_sex", property="sex", jdbcType=JdbcType.TIMESTAMP)
    })
    Student selectById(Long id);

    @UpdateProvider(type=StudentSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Student record);


}

