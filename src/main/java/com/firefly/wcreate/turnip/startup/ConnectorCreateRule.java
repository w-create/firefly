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


package com.firefly.wcreate.turnip.startup;


import java.lang.reflect.Method;

import com.firefly.wcreate.turnip.Executor;
import com.firefly.wcreate.turnip.Service;
import com.firefly.wcreate.turnip.connector.Connector;
import com.firefly.wcreate.juli.logging.Log;
import com.firefly.wcreate.juli.logging.LogFactory;
import com.firefly.wcreate.rabbit.util.IntrospectionUtils;
import com.firefly.wcreate.rabbit.util.digester.Rule;
import org.xml.sax.Attributes;


/**
 * Rule implementation that creates a connector.
 */

public class ConnectorCreateRule extends Rule {

    private static final Log log = LogFactory.getLog(ConnectorCreateRule.class);
    // --------------------------------------------------------- Public Methods


    /**
     * Process the beginning of this element.
     *
     * @param namespace the namespace URI of the matching element, or an 
     *   empty string if the parser is not namespace aware or the element has
     *   no namespace
     * @param name the local name if the parser is namespace aware, or just 
     *   the element name otherwise
     * @param attributes The attribute list for this element
     */
    @Override
    public void begin(String namespace, String name, Attributes attributes)
            throws Exception {
        Service svc = (Service)digester.peek();
        Executor ex = null;
        if ( attributes.getValue("executor")!=null ) {
            ex = svc.getExecutor(attributes.getValue("executor"));
        }
        Connector con = new Connector(attributes.getValue("protocol"));
        if ( ex != null )  _setExecutor(con,ex);
        
        digester.push(con);
    }
    
    public void _setExecutor(Connector con, Executor ex) throws Exception {
        Method m = IntrospectionUtils.findMethod(con.getProtocolHandler().getClass(),"setExecutor",new Class[] {java.util.concurrent.Executor.class});
        if (m!=null) {
            m.invoke(con.getProtocolHandler(), new Object[] {ex});
        }else {
            log.warn("Connector ["+con+"] does not support external executors. Method setExecutor(java.util.concurrent.Executor) not found.");
        }
    }


    /**
     * Process the end of this element.
     * 
     * @param namespace the namespace URI of the matching element, or an 
     *   empty string if the parser is not namespace aware or the element has
     *   no namespace
     * @param name the local name if the parser is namespace aware, or just 
     *   the element name otherwise
     */
    @Override
    public void end(String namespace, String name) throws Exception {
        digester.pop();
    }


}
