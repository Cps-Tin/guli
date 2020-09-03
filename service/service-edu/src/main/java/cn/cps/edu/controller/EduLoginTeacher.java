package cn.cps.edu.controller;

import cn.cps.commonutils.Result;
import cn.cps.edu.service.EduTeacherService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/eduservice/user")
public class EduLoginTeacher {

    @Resource
    EduTeacherService eduTeacherService;

    @RequestMapping("/login")
    public Result login(){
        Map map = new HashMap<>();
        map.put("token","admin");
        return Result.ok(map);
    }

    @RequestMapping("/info")
    public Result info(){
        Map map = new HashMap<>();
        map.put("name","admin");
        map.put("roles","[admin]");
        map.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        return Result.ok(map);
    }

}
