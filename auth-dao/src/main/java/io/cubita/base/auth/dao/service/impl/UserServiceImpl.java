package io.cubita.base.auth.dao.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.cubita.base.auth.dao.entity.User;
import io.cubita.base.auth.dao.mapper.UserMapper;
import io.cubita.base.auth.dao.service.IUserService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cubita
 * @since 2020-01-27
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public List<User> selectAll(Wrapper<User> wrapper) {
        return this.getBaseMapper().selectAll(wrapper);
    }
}
