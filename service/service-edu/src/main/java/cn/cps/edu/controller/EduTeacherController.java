package cn.cps.edu.controller;


import cn.cps.edu.entity.EduTeacher;
import cn.cps.commonutils.Result;
import cn.cps.edu.entity.vo.TeacherQuery;
import cn.cps.edu.service.EduTeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author Mr丶Cps
 * @since 2020-03-29
 */
@Api(description="讲师管理")
@CrossOrigin
@RestController
@RequestMapping("/eduservice/teacher")
public class EduTeacherController {

    @Resource
    private EduTeacherService eduTeacherService;

    /**
     * 查询所有讲师信息
     * @return
     */
    @GetMapping("/findAll")
    @ApiOperation(value = "所有讲师信息")
    public Result findAllTeacher(){
        List<EduTeacher> userList = eduTeacherService.list(null);
        return Result.ok(userList);
    }


    /**
     * 分页查询讲师信息
     * @return
     */
    @PostMapping("/pageTeacher/{current}/{pageSize}")
    @ApiOperation(value = "分页查询讲师列表")
    public Result pageTeacher(
            @ApiParam(name="current", value = "当前页",required = true) @PathVariable long current,
            @ApiParam(name="pageSize", value = "页容量",required = true) @PathVariable long pageSize,
            @RequestBody(required = false) TeacherQuery teacherQuery
    ){
        Page<EduTeacher> eduTeacherPage = new Page<EduTeacher>(current,pageSize);
        QueryWrapper<EduTeacher> queryWrapper = new QueryWrapper<>();
        if(teacherQuery!=null){
            String name = teacherQuery.getName();
            Integer level = teacherQuery.getLevel();
            String begin = teacherQuery.getBegin();
            String end = teacherQuery.getEnd();
            if(!StringUtils.isEmpty(name)){
                queryWrapper.like("name",name);
            }
            if(null != level){
                queryWrapper.eq("level",level);
            }
            if(!StringUtils.isEmpty(begin)){
                queryWrapper.ge("gmt_create",begin);
            }
            if(!StringUtils.isEmpty(end)) {
                queryWrapper.le("gmt_create", end);
            }
        }
        eduTeacherService.page(eduTeacherPage,queryWrapper);
        return Result.ok(eduTeacherPage);
    }

    /**
     * 根据ID删除教师(逻辑删除)
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "逻辑删除讲师")
    public Result removeTeacher(
            @ApiParam(name="id", value = "讲师ID",required = true) @PathVariable String id
    ){
        boolean flag = eduTeacherService.removeById(id);
        if(flag) {
            return Result.ok();
        } else {
            return Result.error();
        }
    }


    //添加讲师接口的方法
    @PostMapping("addTeacher")
    @ApiOperation(value = "添加讲师")
    public Result addTeacher(@RequestBody EduTeacher eduTeacher) {
        boolean save = eduTeacherService.save(eduTeacher);
        if(save) {
            return Result.ok();
        } else {
            return Result.error();
        }
    }

    //根据讲师id进行查询
    @GetMapping("getTeacher/{id}")
    @ApiOperation(value = "根据讲师id进行查询")
    public Result getTeacher(@PathVariable String id) {
        EduTeacher eduTeacher = eduTeacherService.getById(id);
        return Result.ok(eduTeacher);
    }

    //讲师修改功能
    @PatchMapping("updateTeacher")
    @ApiOperation(value = "讲师修改功能")
    public Result updateTeacher(@RequestBody EduTeacher eduTeacher) {
        boolean flag = eduTeacherService.updateById(eduTeacher);
        if(flag) {
            return Result.ok();
        } else {
            return Result.error();
        }
    }

}

