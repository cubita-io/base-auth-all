package io.cubita.base.auth.mock.v1x0x0;

import java.time.LocalDate;

import org.springframework.beans.BeansException;

import io.cubita.base.auth.service.UserService;
import io.cubita.base.auth.service.dto.UserDto;
import io.cubita.commons.exceptions.NotImplementMethodException;
import io.cubita.commons.loader.LoadLevel;
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
        TestResult result = new TestResult(startDate, startDate.plusDays(1),
                "测试登录成功");
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
        TestResult result = new TestResult(startDate, startDate.plusDays(1),
                "测试登录失败");
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
