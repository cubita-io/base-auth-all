package io.cubita.base.auth.tests;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import io.cubita.base.auth.service.TestService;
import io.cubita.commons.exceptions.NotImplementMethodException;

/**
 * <p>
 * </p>
 *
 * @author jiawei
 * @since 1.0.0
 */
@Component
public class UnitTest implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public void test() {
        try {
            final TestService testService = applicationContext.getBean(TestService.class);
            testService.hello();
        } catch (BeansException e) {
            e.printStackTrace();
        } catch (NotImplementMethodException ex) {
            final String methodName = ex.getStackTrace()[1].getMethodName();
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
