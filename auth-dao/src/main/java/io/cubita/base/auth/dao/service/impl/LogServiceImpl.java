package io.cubita.base.auth.dao.service.impl;

import io.cubita.base.auth.dao.entity.Log;
import io.cubita.base.auth.dao.mapper.LogMapper;
import io.cubita.base.auth.dao.service.ILogService;
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
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements ILogService {

}
