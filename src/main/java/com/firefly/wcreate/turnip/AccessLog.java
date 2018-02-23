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

package com.firefly.wcreate.turnip;

import com.firefly.wcreate.turnip.connector.Request;
import com.firefly.wcreate.turnip.connector.Response;


/**
 * Intended for use by a {@link Valve} to indicate that the {@link Valve}
 * provides access logging. It is used by the Tomcat internals to identify a
 * Valve that logs access requests so requests that are rejected
 * earlier in the processing chain can still be added to the access log.
 * Implementations of this interface should be robust against the provided
 * {@link Request} and {@link Response} objects being null, having null
 * attributes or any other 'oddness' that may result from attempting to log
 * a request that was almost certainly rejected because it was mal-formed.
 */
public interface AccessLog {

    /**
     * Name of request attribute used to override the remote address recorded by
     * the AccessLog.
     */
    public static final String REMOTE_ADDR_ATTRIBUTE =
        "com.firefly.wcreate.turnip.AccessLog.RemoteAddr";

    /**
     * Name of request attribute used to override remote host name recorded by
     * the AccessLog.
     */
    public static final String REMOTE_HOST_ATTRIBUTE =
        "com.firefly.wcreate.turnip.AccessLog.RemoteHost";

    /**
     * Name of request attribute used to override the protocol recorded by the
     * AccessLog.
     */
    public static final String PROTOCOL_ATTRIBUTE =
        "com.firefly.wcreate.turnip.AccessLog.Protocol";

    /**
     * Name of request attribute used to override the server port recorded by
     * the AccessLog.
     */
    public static final String SERVER_PORT_ATTRIBUTE =
        "com.firefly.wcreate.turnip.AccessLog.ServerPort";


    /**
     * Add the request/response to the access log using the specified processing
     * time.
     *
     * @param request   Request (associated with the response) to log
     * @param response  Response (associated with the request) to log
     * @param time      Time taken to process the request/response in
     *                  milliseconds (use 0 if not known)
     */
    public void log(Request request, Response response, long time);

    /**
     * Should this valve set request attributes for IP address, hostname,
     * protocol and port used for the request? This are typically used in
     * conjunction with the {@link com.firefly.wcreate.turnip.valves.AccessLogValve}
     * which will otherwise log the original values.
     *
     * The attributes set are:
     * <ul>
     * <li>com.firefly.wcreate.turnip.RemoteAddr</li>
     * <li>com.firefly.wcreate.turnip.RemoteHost</li>
     * <li>com.firefly.wcreate.turnip.Protocol</li>
     * <li>com.firefly.wcreate.turnip.ServerPost</li>
     * </ul>
     *
     * @param requestAttributesEnabled  <code>true</code> causes the attributes
     *                                  to be set, <code>false</code> disables
     *                                  the setting of the attributes.
     */
    public void setRequestAttributesEnabled(boolean requestAttributesEnabled);

    /**
     * @see #setRequestAttributesEnabled(boolean)
     * @return <code>true</code> if the attributes will be logged, otherwise
     *         <code>false</code>
     */
    public boolean getRequestAttributesEnabled();
}
