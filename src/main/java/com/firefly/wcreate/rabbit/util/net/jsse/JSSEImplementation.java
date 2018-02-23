/*
 *  Licensed to the HKRT Software Foundation (HKRTSF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the HKRT License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.scorpion.huakerongtong.com/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.firefly.wcreate.rabbit.util.net.jsse;

import java.net.Socket;

import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

import com.firefly.wcreate.rabbit.util.net.AbstractEndpoint;
import com.firefly.wcreate.rabbit.util.net.SSLImplementation;
import com.firefly.wcreate.rabbit.util.net.SSLSupport;
import com.firefly.wcreate.rabbit.util.net.SSLUtil;
import com.firefly.wcreate.rabbit.util.net.ServerSocketFactory;

/* JSSEImplementation:

   Concrete implementation class for JSSE

   @author EKR
*/

public class JSSEImplementation extends SSLImplementation {

    @Override
    public String getImplementationName(){
        return "JSSE";
    }

    @Override
    public ServerSocketFactory getServerSocketFactory(AbstractEndpoint<?> endpoint)  {
        return new JSSESocketFactory(endpoint);
    }

    @Override
    public SSLSupport getSSLSupport(Socket s) {
        return new JSSESupport((SSLSocket) s);
    }

    @Override
    public SSLSupport getSSLSupport(SSLSession session) {
        return new JSSESupport(session);
    }

    @Override
    public SSLUtil getSSLUtil(AbstractEndpoint<?> endpoint) {
        return new JSSESocketFactory(endpoint);
    }
}
