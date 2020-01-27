package io.cutita.base.auth.dao.service.impl;

import io.cutita.base.auth.dao.entity.Role;
import io.cutita.base.auth.dao.mapper.RoleMapper;
import io.cutita.base.auth.dao.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cubita
 * @since 2020-01-27
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
