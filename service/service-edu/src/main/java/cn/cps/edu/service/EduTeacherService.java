package cn.cps.edu.service;

import cn.cps.edu.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author Mr丶Cps
 * @since 2020-03-29
 */
public interface EduTeacherService extends IService<EduTeacher> {

    List<EduTeacher> getTeacherList();

}
