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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import io.cubita.commons.extension.ExtensionFactory;
import io.cubita.commons.extension.ExtensionLoader;
import io.cubita.commons.tests.TestMetric;
import io.cubita.commons.tests.TestResult;

/**
 * <p>
 * </p>
 *
 * @author jiawei
 * @since 1.0.0
 */
@Service
public class TestService implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public List<TestMetric> exec(int level) {
        final Set<ServiceTestProvider> testServices = ExtensionLoader.getExtensionLoader(ServiceTestProvider.class).getSupportedExtensionInstances();

        final List<TestMetric> metrics = new ArrayList<>();
        for (ServiceTestProvider mock : testServices) {
            mock.initContext(this.applicationContext);
            mock.exec(level);
            if (mock.getResultMap() != null && mock.getResultMap().size() > 0) {
                final Map<String, Map<String, TestResult>> result = new HashMap<>();
                result.put(mock.name(), mock.getResultMap());
                metrics.add(new TestMetric(mock.getTotal(), mock.getSuccess(),
                        mock.getDetail(), result));
            }
        }
        return metrics;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
