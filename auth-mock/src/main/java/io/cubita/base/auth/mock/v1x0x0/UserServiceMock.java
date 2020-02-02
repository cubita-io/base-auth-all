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
package io.cubita.base.auth.mock.v1x0x0;

import java.time.LocalDate;

import org.springframework.beans.BeansException;

import io.cubita.base.auth.service.UserService;
import io.cubita.base.auth.service.dto.UserDto;
import io.cubita.commons.exceptions.NotImplementMethodException;
import io.cubita.commons.tests.FinishStatus;
import io.cubita.commons.tests.TestResult;

/**
 * <p>
 * </p>
 *
 * @author jiawei
 * @since 1.0.0
 */
public class UserServiceMock extends AbstractServiceMockProvider {

    public void loginSuccess() {
        final LocalDate startDate = LocalDate.of(2020, 02, 1);
        final TestResult result = new TestResult(startDate, startDate.plusDays(1), "测试登录成功");
        try {
            final UserService userService = getApplicationContext().getBean(UserService.class);
            userService.login(mockLoginSuccess());
            result.setFinishStatus(FinishStatus.SUCCESS.ordinal());
        } catch (BeansException ex) {
            result.setFinishStatus(FinishStatus.NOT_STARTED.ordinal());
        } catch (NotImplementMethodException ex) {
            ex.getMessage();
            result.setFinishStatus(FinishStatus.NOT_FINISH.ordinal());
        } catch (Exception ex) {
            result.setFinishStatus(FinishStatus.FAIL.ordinal());
        }
        final String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        getInternalResultMap().put(methodName, result);
    }

    public void loginFail() {
        final LocalDate startDate = LocalDate.of(2020, 02, 1);
        final TestResult result = new TestResult(startDate, startDate.plusDays(1), "测试登录失败");
        try {
            final UserService userService = getApplicationContext().getBean(UserService.class);
            userService.login(mockLoginSuccess());
            result.setFinishStatus(FinishStatus.SUCCESS.ordinal());
        } catch (BeansException ex) {
            result.setFinishStatus(FinishStatus.NOT_STARTED.ordinal());
        } catch (NotImplementMethodException ex) {
            ex.getMessage();
            result.setFinishStatus(FinishStatus.NOT_FINISH.ordinal());
        } catch (Exception ex) {
            result.setFinishStatus(FinishStatus.FAIL.ordinal());
        }
        final String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        getInternalResultMap().put(methodName, result);
    }

    private UserDto mockLoginSuccess() {
        final UserDto userDto = new UserDto();
        userDto.setName("zhangsan");
        userDto.setPwd("123456");
        return userDto;
    }

    private boolean expectLoginSuccess() {
        return true;
    }

    private UserDto mockLoginFail() {
        final UserDto userDto = new UserDto();
        userDto.setName("zhangsan");
        userDto.setPwd("12345678");
        return userDto;
    }

    @Override
    public void execIntenal() {
        loginSuccess();
        loginFail();
    }

}
