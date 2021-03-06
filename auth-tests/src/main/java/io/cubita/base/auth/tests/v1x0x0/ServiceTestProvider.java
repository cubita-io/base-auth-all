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

import java.util.Map;

import org.springframework.context.ApplicationContext;

import io.cubita.commons.extension.SPI;
import io.cubita.commons.tests.TestResult;

/**
 * <p>
 *     milestone: 1.0.0
 * </p>
 *
 * @author jiawei
 * @since 1.0.0
 */
@SPI
public interface ServiceTestProvider {

    void initContext(ApplicationContext context);

    void exec(int level);

    int getTotal();

    int getSuccess();

    Map<String, TestResult> getResultMap();

    default String getDetail() {
        return "";
    };

    default String name() {
        return this.getClass().getName();
    }

}
