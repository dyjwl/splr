package com.mm.splr.model;

import javax.validation.constraints.*;

import com.mm.splr.common.CustomAgeValidator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import java.util.Date;

@ApiModel(description = "用户对象")
public class User {

    @ApiModelProperty(value = "用户ID", name = "userId")
    private String userId;

    @ApiModelProperty(value = "姓名", name = "name")
    @NotBlank(message = "姓名不允许为空！")
    @Length(min = 2,max = 10,message = "姓名长度错误，姓名长度2-10！")
    private String name;

    @ApiModelProperty(value = "年龄", name = "age")
    @CustomAgeValidator
    private int age;


    @Digits(integer=20, fraction=0,message = "数值超出范围")
    private int sex;

    @NotBlank(message = "密码不允许为空！")
    @Length(min = 6,max = 20,message = "密码长度错误，密码长度6-20！")
    private  String password;

    @Email(message = "邮箱格式错误")
    private String email;

    @NotBlank(message = "地址不能爲空")
    private String address;

    public User(String name, int age, String password) {
        this.name=name;
        this.age=age;
        this.password=password;
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Pattern(regexp = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$", message = "手机号格式错误")
    @NotBlank(message = "手機號不允许为空！")
    private String phone;

    private  String desc;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }
    public String getPassword() {
        return password;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDesc() {
        return desc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}