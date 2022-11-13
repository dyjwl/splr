package com.mm.splr.controller;


import com.mm.splr.model.User;
import com.mm.splr.util.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Api(tags = {"用户接口"})
@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    @RequestMapping("/getUser")
    public User getUser(){
        User u = new User("weiz222",20,"weiz222");
        return u;
    }


    @PostMapping(path = "/check")
    public String check(@RequestBody @Valid User user, BindingResult result) {
        if(result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error : list) {
                System.out.println(error.getCode()+ "-" + error.getDefaultMessage());
            }
        }
        return user.getName()+" 检测完毕！没有问题";
    }

//    @RequestMapping("/query")
//    public String query(@Range(min = 1, max = 9, message = "姓名长度错误，姓名长度2-10！")
//                        @RequestParam(name = "name", required = true) String name,
//                        @Min(value = 18, message = "年龄最小18")
//                        @Max(value = 65, message = "年龄最大只能99")
//                        @RequestParam(name = "age", required = true) int age){
////        if(result.hasErrors()) {
////            List<ObjectError> list = result.getAllErrors();
////            for (ObjectError error : list) {
////                System.out.println(error.getCode()+ "-" + error.getDefaultMessage());
////            }
////        }
//        System.out.println(name + "," + age);
//        return name + "," + age;
//    }
    @RequestMapping(value="/query", method = RequestMethod.GET)
    public String query(@Length(min = 2, max = 10, message = "姓名长度错误，姓名长度2-10！")
                        @RequestParam(name = "name", required = true) String name,
                        @Min(value = 1, message = "年龄最小只能1")
                        @Max(value = 99, message = "年龄最大只能99")
                        @RequestParam(name = "age", required = true) int age){

        System.out.println(name + "," + age);
        return name + "," + age;
    }


    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @PostMapping(value = "user")
    public JSONResult save(@RequestBody User user){
        System.out.println("用户创建成功："+user.getName());
        return JSONResult.ok(201,"用户创建成功");
    }

    @ApiOperation(value="更新用户详细信息", notes="根据id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @PutMapping(value = "user")
    public JSONResult update(@RequestBody User user) {
        System.out.println("用户修改成功："+user.getName());
        return JSONResult.ok(203,"用户修改成功");
    }

    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @DeleteMapping("user/{userId}")
    public JSONResult delete(@PathVariable String userId) {
        System.out.println("用户删除成功："+userId);
        return JSONResult.ok(204,"用户删除成功");
    }

    @ApiOperation(value="查询用户",notes = "通过用户ID获取用户信息")
    @GetMapping("user/{userId}")
    public JSONResult queryUserById(@PathVariable String userId) {
        User user =new User("weiz",20,"weiz");
        System.out.println("获取用户成功："+user.getName());
        return JSONResult.ok(200,"获取用户成功",user);
    }
}
