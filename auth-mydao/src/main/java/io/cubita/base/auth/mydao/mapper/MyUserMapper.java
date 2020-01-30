package io.cubita.base.auth.mydao.mapper;

import com.baomidou.mybatisplus.core.mapper.Mapper;
import io.cubita.base.auth.mydao.entity.MyUser;

/**
 * <p>
 * </p>
 *
 * @author jiawei
 * @since 1.0.0
 */
public interface MyUserMapper extends Mapper<MyUser> {

    MyUser select();

}
