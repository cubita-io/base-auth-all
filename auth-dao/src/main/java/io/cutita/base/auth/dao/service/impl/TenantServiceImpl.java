package io.cutita.base.auth.dao.service.impl;

import io.cutita.base.auth.dao.entity.Tenant;
import io.cutita.base.auth.dao.mapper.TenantMapper;
import io.cutita.base.auth.dao.service.ITenantService;
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
public class TenantServiceImpl extends ServiceImpl<TenantMapper, Tenant> implements ITenantService {

}
