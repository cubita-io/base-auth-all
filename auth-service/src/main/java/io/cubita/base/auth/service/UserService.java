package io.cubita.base.auth.service;

import java.time.LocalDate;

import io.cubita.base.auth.service.dto.UserDto;
import io.cubita.commons.exceptions.NotImplementMethodException;

/**
 * <p>
 *    用户
 * </p>
 *
 * @author jiawei
 * @since 1.0.0
 */
public interface UserService {

    /**
     * 登录.
     * @param userDto 用户实体
     * @return
     */
    default void login(UserDto userDto) {
        final LocalDate startDate = LocalDate.of(2020, 2, 1);
        throw new NotImplementMethodException("login",
                startDate,
                startDate.plusDays(1),
                "V1.0.0");
    }

}
