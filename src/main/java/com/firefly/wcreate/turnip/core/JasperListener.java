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

package com.firefly.wcreate.turnip.core;


import com.firefly.wcreate.turnip.Lifecycle;
import com.firefly.wcreate.turnip.LifecycleEvent;
import com.firefly.wcreate.turnip.LifecycleListener;
import com.firefly.wcreate.juli.logging.Log;
import com.firefly.wcreate.juli.logging.LogFactory;
import com.firefly.wcreate.rabbit.util.ExceptionUtils;
import com.firefly.wcreate.rabbit.util.res.StringManager;


/**
 * This listener is designed to initialize Jasper before any web applications are
 * started.
 *
 * @author Remy Maucherat
 * @since 4.1
 */
public class JasperListener
    implements LifecycleListener {

    private static final Log log = LogFactory.getLog(JasperListener.class);

    /**
     * The string manager for this package.
     */
    protected static final StringManager sm =
        StringManager.getManager(Constants.Package);


    // ---------------------------------------------- LifecycleListener Methods


    /**
     * Primary entry point for startup and shutdown events.
     *
     * @param event The event that has occurred
     */
    @Override
    public void lifecycleEvent(LifecycleEvent event) {

        if (Lifecycle.BEFORE_INIT_EVENT.equals(event.getType())) {
            try {
                // Set JSP factory
                Class.forName("com.firefly.wcreate.jasper.compiler.JspRuntimeContext",
                              true,
                              this.getClass().getClassLoader());
            } catch (Throwable t) {
                ExceptionUtils.handleThrowable(t);
                // Should not occur, obviously
                log.warn("Couldn't initialize Jasper", t);
            }
            // Another possibility is to do directly:
            // JspFactory.setDefaultFactory(new JspFactoryImpl());
        }

    }


}
