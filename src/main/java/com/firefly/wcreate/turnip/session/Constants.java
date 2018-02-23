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
package com.firefly.wcreate.turnip.session;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.firefly.wcreate.turnip.Globals;
import com.firefly.wcreate.turnip.valves.CrawlerSessionManagerValve;

/**
 * Manifest constants for the <code>com.firefly.wcreate.turnip.session</code>
 * package.
 *
 * @author Craig R. McClanahan
 */

public class Constants {

    /**
     * Set of session attribute names used internally by Tomcat that should
     * always be removed from the session before it is persisted, replicated or
     * equivalent.
     */
    public static final Set<String> excludedAttributeNames;

    static {
        Set<String> names = new HashSet<String>();
        names.add(Globals.SUBJECT_ATTR);
        names.add(Globals.GSS_CREDENTIAL_ATTR);
        names.add(CrawlerSessionManagerValve.class.getName());
        excludedAttributeNames = Collections.unmodifiableSet(names);
    }
}
