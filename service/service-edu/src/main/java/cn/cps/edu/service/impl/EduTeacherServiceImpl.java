package cn.cps.edu.service.impl;

import cn.cps.edu.entity.EduTeacher;
import cn.cps.edu.mapper.EduTeacherMapper;
import cn.cps.edu.service.EduTeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author Mr丶Cps
 * @since 2020-03-29
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {

    @Override
    public List<EduTeacher> getTeacherList() {
        //this.baseMapper ServiceImpl中注入了
        return this.baseMapper.selectList(null);
    }
}
