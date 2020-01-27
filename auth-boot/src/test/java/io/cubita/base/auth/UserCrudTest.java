package io.cubita.base.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.cubita.base.auth.dao.entity.User;
import io.cubita.base.auth.dao.service.IUserService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * <p>
 * </p>
 *
 * @author jiawei
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserCrudTest {

    @Autowired
    private IUserService userService;

    @Test
    public void insert() {
        User user = new User();
        user.setName("zhangsan");
        user.setPwd("12345678");
        user.setStatus(1);
        user.setCreateBy("张三");
        Assertions.assertThat(userService.save(user))
                .isEqualTo(true);
    }

}
