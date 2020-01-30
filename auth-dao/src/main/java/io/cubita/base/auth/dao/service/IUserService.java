package io.cubita.base.auth.dao.service;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import io.cubita.base.auth.dao.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cubita
 * @since 2020-01-27
 */
public interface IUserService extends IService<User> {
    List<User> selectAll(Wrapper<User> wrapper);
}
