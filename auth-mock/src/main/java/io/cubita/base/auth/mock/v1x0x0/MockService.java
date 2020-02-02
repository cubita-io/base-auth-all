package io.cubita.base.auth.mock.v1x0x0;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import io.cubita.commons.loader.EnhancedServiceLoader;
import io.cubita.commons.tests.TestResult;

/**
 * <p>
 * </p>
 *
 * @author jiawei
 * @since 1.0.0
 */
@Service
public class MockService implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public List<Map<String, Map<String, TestResult>>> exec(int level) {
        final List<ServiceMockProvider> mockServices = EnhancedServiceLoader.loadAll(ServiceMockProvider.class);
        final List<Map<String, Map<String, TestResult>>> results = new ArrayList<>();
        for (ServiceMockProvider mock : mockServices) {
            mock.initContext(this.applicationContext);
            final Map<String, Map<String, TestResult>> result = mock.exec(level);
            if (result != null && result.size() > 0) {
                results.add(result);
            }
        }
        return results;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
