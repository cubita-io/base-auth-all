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
package io.cubita.base.auth.tests.v1x0x0;

import java.time.LocalDate;

import org.springframework.beans.BeansException;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.cubita.base.auth.service.UserService;
import io.cubita.base.auth.service.dto.UserDto;
import io.cubita.commons.exceptions.NotImplementMethodException;
import io.cubita.commons.tests.FinishStatus;
import io.cubita.commons.tests.TestResult;
import io.cubita.commons.utils.ResourceUtil;

import static io.cubita.commons.Constants.TEST_MOCK_ARGS;
import static io.cubita.commons.Constants.TEST_MOCK_DIRECTORY;
import static io.cubita.commons.Constants.TEST_MOCK_EXPECT;

/**
 * <p>
 * </p>
 *
 * @author jiawei
 * @since 1.0.0
 */
public class UserServiceMock extends AbstractServiceMockProvider {

    public void loginSuccess(JSONObject obj) {
        addTotal();
        final JSONArray args = obj.getJSONArray(TEST_MOCK_ARGS);
        final UserDto args0 = args.getObject(0, UserDto.class);
        final String expect = obj.getString(TEST_MOCK_EXPECT);

        final LocalDate startDate = LocalDate.of(2020, 02, 1);
        final TestResult result = new TestResult("测试登录成功", startDate, startDate.plusDays(1));
        try {
            final UserService userService = getApplicationContext().getBean(UserService.class);
            result.setAuthor(userService.author());
            userService.login(args0);
            addSuccess();
            result.setFinishStatus(FinishStatus.SUCCESS.ordinal());
        } catch (BeansException ex) {
            result.setFinishStatus(FinishStatus.NOT_STARTED.ordinal());
        } catch (NotImplementMethodException ex) {
            result.setFinishStatus(FinishStatus.NOT_FINISH.ordinal());
        } catch (Exception ex) {
            result.setDetail(ex.getMessage());
            result.setFinishStatus(FinishStatus.FAIL.ordinal());
        }
        final String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        getInternalResultMap().put(methodName, result);
    }

    public void loginFail(JSONObject obj) {
        addTotal();
        final JSONArray args = obj.getJSONArray(TEST_MOCK_ARGS);
        final UserDto args0 = args.getObject(0, UserDto.class);
        final String expect = obj.getString(TEST_MOCK_EXPECT);

        final LocalDate startDate = LocalDate.of(2020, 02, 1);
        final TestResult result = new TestResult("测试登录失败", startDate, startDate.plusDays(1));
        try {
            final UserService userService = getApplicationContext().getBean(UserService.class);
            userService.login(args0);
            addSuccess();
            result.setFinishStatus(FinishStatus.SUCCESS.ordinal());
        } catch (BeansException ex) {
            result.setFinishStatus(FinishStatus.NOT_STARTED.ordinal());
        } catch (NotImplementMethodException ex) {
            ex.getMessage();
            result.setFinishStatus(FinishStatus.NOT_FINISH.ordinal());
        } catch (Exception ex) {
            result.setDetail(ex.getMessage());
            result.setFinishStatus(FinishStatus.FAIL.ordinal());
        }
        final String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        getInternalResultMap().put(methodName, result);
    }

    @Override
    public String getDetail() {
        return "用户";
    }

    @Override
    public void execIntenal() {

        final String data = ResourceUtil.getContentQuietly(TEST_MOCK_DIRECTORY
                                                           + UserServiceMock.class.getName());

        final JSONObject obj = JSONObject.parseObject(data);
        loginSuccess(obj.getJSONObject("loginSuccess"));
        loginFail(obj.getJSONObject("loginFail"));
    }

}
