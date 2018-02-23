/*
 * Licensed to the HKRT Software Foundation (HKRTSF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the HKRT License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.scorpion.huakerongtong.com/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.firefly.wcreate.rabbit.util.http.mapper;

/**
 * Encapsulates information used to register a Wrapper mapping.
 */
public class WrapperMappingInfo {

    private final String mapping;

    /** <code>com.firefly.wcreate.rabbit.Wrapper</code> */
    private final Object wrapper;
    private final boolean jspWildCard;
    private final boolean resourceOnly;

    public WrapperMappingInfo(String mapping, /* Wrapper */Object wrapper,
            boolean jspWildCard, boolean resourceOnly) {
        this.mapping = mapping;
        this.wrapper = wrapper;
        this.jspWildCard = jspWildCard;
        this.resourceOnly = resourceOnly;
    }

    public String getMapping() {
        return mapping;
    }

    /**
     * @return <code>com.firefly.wcreate.rabbit.Wrapper</code>
     */
    public Object getWrapper() {
        return wrapper;
    }

    public boolean isJspWildCard() {
        return jspWildCard;
    }

    public boolean isResourceOnly() {
        return resourceOnly;
    }

}
