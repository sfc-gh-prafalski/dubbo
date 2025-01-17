/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.dubbo.common.serialize.hessian2;

import com.alibaba.com.caucho.hessian.io.SerializerFactory;

public class Hessian2SerializerFactory extends SerializerFactory {

    private Hessian2AllowClassManager hessian2AllowClassManager;

    public Hessian2SerializerFactory(Hessian2AllowClassManager hessian2AllowClassManager) {
        this.hessian2AllowClassManager = hessian2AllowClassManager;
    }

    @Override
    public Class<?> loadSerializedClass(String className) throws ClassNotFoundException {
        return hessian2AllowClassManager.loadClass(getClassLoader(), className);
    }
}
