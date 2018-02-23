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
package com.firefly.wcreate.turnip.filters;


/**
 * Manifest constants for this Java package.
 *
 *
 * @author Craig R. McClanahan
 */
public final class Constants {

    public static final String Package = "com.firefly.wcreate.turnip.filters";
    
    public static final String CSRF_NONCE_SESSION_ATTR_NAME =
        "com.firefly.wcreate.turnip.filters.CSRF_NONCE";
    
    public static final String CSRF_NONCE_REQUEST_PARAM =
        "com.firefly.wcreate.turnip.filters.CSRF_NONCE";

    public static final String METHOD_GET = "GET";

    public static final String CSRF_REST_NONCE_HEADER_NAME = "X-CSRF-Token";

    public static final String CSRF_REST_NONCE_HEADER_FETCH_VALUE = "Fetch";

    public static final String CSRF_REST_NONCE_HEADER_REQUIRED_VALUE = "Required";

    public static final String CSRF_REST_NONCE_SESSION_ATTR_NAME =
        "com.firefly.wcreate.turnip.filters.CSRF_REST_NONCE";
}
