package io.cubita.base.auth.dao.service.impl;

import io.cubita.base.auth.dao.entity.AuthorizedUri;
import io.cubita.base.auth.dao.mapper.AuthorizedUriMapper;
import io.cubita.base.auth.dao.service.IAuthorizedUriService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cubita
 * @since 2020-01-31
 */
@Service
public class AuthorizedUriServiceImpl extends ServiceImpl<AuthorizedUriMapper, AuthorizedUri> implements IAuthorizedUriService {

}
