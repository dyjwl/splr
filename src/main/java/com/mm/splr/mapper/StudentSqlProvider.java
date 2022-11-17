package com.mm.splr.mapper;

import com.mm.splr.model.Student;

import static org.apache.ibatis.jdbc.SqlBuilder.*;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;

public class StudentSqlProvider {
    public String updateByPrimaryKeySelective(Student record) {
        BEGIN();
        UPDATE("student");

        if (record.getName() != null) {
            SET("name = #{name,jdbcType=VARCHAR}");
        }

        if (record.getSex()>=0) {
            SET("sex = #{sex,jdbcType=VARCHAR}");
        }

        if (record.getAge() >0) {
            SET("age = #{age,jdbcType=INTEGER}");
        }

        WHERE("id = #{id,jdbcType=VARCHAR}");

        return SQL();
    }
}