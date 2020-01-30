/*
 * Copyright 2017-2019 Lemonframework Group Holding Ltd.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package io.cubita.base.auth;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.cubita.base.auth.dao.entity.User;
import io.cubita.base.auth.dao.service.IUserService;
import io.cubita.commons.RequestContext;
import org.assertj.core.api.Assertions;
import org.junit.Before;
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

    @Before
    public void init() {
        RequestContext.getCurrentContext().setTenant("test");
    }

    @Test
    public void insert() {
        User user = new User();
        user.setName("tianqi");
        user.setPwd("1234567898");
        user.setStatus(1);
        user.setRoleId(1);
        Assertions.assertThat(userService.save(user))
                .isEqualTo(true);
    }

    @Test
    public void queryById() {
        List<Integer> ids = Arrays.asList(1, 2, 3);
        final List<User> users = userService.listByIds(ids);
        System.out.println(users);
    }

    @Test
    public void queryByMap() {
        Map<String, Object> maps = new HashMap<>();
        maps.put("name", "zhangsan");
        final List<User> users = userService.listByMap(maps);
        System.out.println(users);
    }

    @Test
    public void queryByWrapper() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.likeRight("name", "zhang")
                .gt("id", 2);
        final List<User> users = userService.list(wrapper);
        System.out.println(users);
    }

    @Test
    public void queryOrderByWrapper() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.likeRight("name", "zhang")
                .gt("id", 2)
                .orderByAsc("id");
        final List<User> users = userService.list(wrapper);
        System.out.println(users);
    }

    @Test
    public void queryInByWrapper() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.apply("date_format(create_time, '%Y-%m-%d') = {0}", "2020-01-26")
                .inSql("name", "select name from t_user where id=1");
        final List<User> users = userService.list(wrapper);
        System.out.println(users);
    }

    @Test
    public void queryByWrapper2() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.likeRight("name", "zhang")
                .and(w -> w.lt("id", 8)
                    .or().isNotNull("pwd"));

        final List<User> users = userService.list(wrapper);
        System.out.println(users);
    }

    @Test
    public void queryByWrapper3() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.nested(w -> w.lt("id", 8)
                        .or().isNotNull("pwd"))
                .eq("pwd", "123456");

        final List<User> users = userService.list(wrapper);
        System.out.println(users);
    }

    @Test
    public void queryByWrapper4() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.nested(w -> w.lt("id", 8)
                .or().isNotNull("pwd"))
                .likeRight("pwd", "123456")
                .last("limit 1");

        final List<User> users = userService.list(wrapper);
        System.out.println(users);
    }

    @Test
    public void queryByWrapper5() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select("id", "name").nested(w -> w.lt("id", 8)
                .or().isNotNull("pwd"))
                .likeRight("pwd", "123456");

        final List<User> users = userService.list(wrapper);
        System.out.println(users);
    }

    @Test
    public void queryByWrapper6() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select(User.class, u -> !u.getColumn().equals("pwd") && !u.getColumn().equals("name")).nested(w -> w.lt("id", 8)
                .or().isNotNull("pwd"))
                .likeRight("pwd", "123456");

        final List<User> users = userService.list(wrapper);
        System.out.println(users);
    }

    @Test
    public void queryByAllEq() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.nested(w -> w.lt("id", 8)
                .or().isNotNull("pwd"))
                .likeRight("pwd", "123456");

        final List<User> users = userService.list(wrapper);
        System.out.println(users);
    }

    @Test
    public void queryByLambda() {
        final LambdaQueryWrapper<User> wrapper1 = Wrappers.<User>lambdaQuery();
        wrapper1.likeRight(User::getName, "zhang")
            .eq(User::getPwd, "123456");
        final List<User> users = userService.list(wrapper1);
        System.out.println(users);

    }

//    @Test
//    public void queryByLambda2() {
//        final LambdaQueryWrapper<User> wrapper1 = Wrappers.<User>lambdaQuery();
//        wrapper1.select(User.class, info -> !info.getColumn().equals("pwd"))
//                .likeRight(User::getName, "zhang");
//        final List<User> users = userService.selectAll(wrapper1);
//        System.out.println(users);
//
//    }

    @Test
    public void queryByLambda3() {
        final LambdaQueryWrapper<User> wrapper1 = Wrappers.<User>lambdaQuery();
        wrapper1.select(User.class, info -> !info.getColumn().equals("pwd"))
                .likeRight(User::getName, "zhang");
        final List<User> users = userService.list(wrapper1);
        System.out.println(users);
    }

    @Test
    public void queryByPage() {
        final Page<User> page = new Page<>(1, 2, false);
        final LambdaQueryWrapper<User> wrapper1 = Wrappers.<User>lambdaQuery();
        wrapper1.select(User.class, info -> !info.getColumn().equals("pwd"))
                .likeRight(User::getName, "zhang");
        final Page<User> page1 = userService.page(page, wrapper1);
        System.out.println("总页数:" + page1.getPages());
        System.out.println("总记录数:" + page1.getTotal());
        final List<User> records = page1.getRecords();
        records.forEach(System.out::println);
    }
}
