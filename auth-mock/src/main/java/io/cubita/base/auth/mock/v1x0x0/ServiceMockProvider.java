package io.cubita.base.auth.mock.v1x0x0;

import java.util.Map;

import org.springframework.context.ApplicationContext;

import io.cubita.commons.tests.TestResult;

/**
 * <p>
 *     milestone: 1.0.0
 * </p>
 *
 * @author jiawei
 * @since 1.0.0
 */
public interface ServiceMockProvider {

    void initContext(ApplicationContext context);

    Map<String, Map<String, TestResult>> exec(int level);

    default String name() {
        return this.getClass().getName();
    }

}
