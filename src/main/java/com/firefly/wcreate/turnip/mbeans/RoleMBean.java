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

package com.firefly.wcreate.turnip.mbeans;


import javax.management.MBeanException;
import javax.management.RuntimeOperationsException;

import com.firefly.wcreate.rabbit.util.modeler.BaseModelMBean;
import com.firefly.wcreate.rabbit.util.modeler.ManagedBean;
import com.firefly.wcreate.rabbit.util.modeler.Registry;


/**
 * <p>A <strong>ModelMBean</strong> implementation for the
 * <code>com.firefly.wcreate.turnip.Role</code> component.</p>
 *
 * @author Craig R. McClanahan
 */
public class RoleMBean extends BaseModelMBean {


    // ----------------------------------------------------------- Constructors


    /**
     * Construct a <code>ModelMBean</code> with default
     * <code>ModelMBeanInfo</code> information.
     *
     * @exception MBeanException if the initializer of an object
     *  throws an exception
     * @exception RuntimeOperationsException if an IllegalArgumentException
     *  occurs
     */
    public RoleMBean()
        throws MBeanException, RuntimeOperationsException {

        super();

    }


    // ----------------------------------------------------- Instance Variables


    /**
     * The configuration information registry for our managed beans.
     */
    protected Registry registry = MBeanUtils.createRegistry();


    /**
     * The <code>ManagedBean</code> information describing this MBean.
     */
    protected ManagedBean managed = registry.findManagedBean("Role");


    // ------------------------------------------------------------- Attributes


    // ------------------------------------------------------------- Operations


}
