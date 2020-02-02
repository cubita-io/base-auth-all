package io.cubita.base.auth.mock.v1x0x0;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;

import io.cubita.commons.loader.LoadLevel;
import io.cubita.commons.tests.TestResult;

/**
 * <p>
 * </p>
 *
 * @author jiawei
 * @since 1.0.0
 */
public abstract class AbstractServiceMockProvider implements ServiceMockProvider {

    private ApplicationContext applicationContext;

    private Map<String, TestResult> internalResultMap;

    @Override
    public void initContext(ApplicationContext context) {
        this.applicationContext = context;
        this.internalResultMap = new HashMap<>();
    }

    @Override
    public Map<String, Map<String, TestResult>> exec(int level) {
        final LoadLevel annotation = this.getClass().getAnnotation(LoadLevel.class);
        int annotationLevel = 0;
        if (annotation != null) {
            annotationLevel = annotation.order();
        }
        if (level < annotationLevel) {
            return null;
        }
        execIntenal();
        if (internalResultMap.size() == 0) {
            return null;
        }
        final Map<String, Map<String, TestResult>> results = new HashMap<>();
        results.put(name(), internalResultMap);
        return results;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public Map<String, TestResult> getInternalResultMap() {
        return internalResultMap;
    }

    public abstract void execIntenal();

}
