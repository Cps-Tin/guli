package cn.cps.edu.mapper;

import cn.cps.edu.entity.EduTeacher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 讲师 Mapper 接口
 * </p>
 *
 * @author Mr丶Cps
 * @since 2020-03-29
 */
public interface EduTeacherMapper extends BaseMapper<EduTeacher> {

    List<EduTeacher> getTeacherList();

}
