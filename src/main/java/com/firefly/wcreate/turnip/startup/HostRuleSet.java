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


import com.firefly.wcreate.rabbit.util.digester.Digester;
import com.firefly.wcreate.rabbit.util.digester.RuleSetBase;


/**
 * <p><strong>RuleSet</strong> for processing the contents of a
 * Host definition element.  This <code>RuleSet</code> does NOT include
 * any rules for nested Context which should be added via instances of
 * <code>ContextRuleSet</code>.</p>
 *
 * @author Craig R. McClanahan
 */
public class HostRuleSet extends RuleSetBase {


    // ----------------------------------------------------- Instance Variables


    /**
     * The matching pattern prefix to use for recognizing our elements.
     */
    protected String prefix = null;


    // ------------------------------------------------------------ Constructor


    /**
     * Construct an instance of this <code>RuleSet</code> with the default
     * matching pattern prefix.
     */
    public HostRuleSet() {

        this("");

    }


    /**
     * Construct an instance of this <code>RuleSet</code> with the specified
     * matching pattern prefix.
     *
     * @param prefix Prefix for matching pattern rules (including the
     *  trailing slash character)
     */
    public HostRuleSet(String prefix) {

        super();
        this.namespaceURI = null;
        this.prefix = prefix;

    }


    // --------------------------------------------------------- Public Methods


    /**
     * <p>Add the set of Rule instances defined in this RuleSet to the
     * specified <code>Digester</code> instance, associating them with
     * our namespace URI (if any).  This method should only be called
     * by a Digester instance.</p>
     *
     * @param digester Digester instance to which the new Rule instances
     *  should be added.
     */
    @Override
    public void addRuleInstances(Digester digester) {

        digester.addObjectCreate(prefix + "Host",
                                 "com.firefly.wcreate.turnip.core.StandardHost",
                                 "className");
        digester.addSetProperties(prefix + "Host");
        digester.addRule(prefix + "Host",
                         new CopyParentClassLoaderRule());
        digester.addRule(prefix + "Host",
                         new LifecycleListenerRule
                         ("com.firefly.wcreate.turnip.startup.HostConfig",
                          "hostConfigClass"));
        digester.addSetNext(prefix + "Host",
                            "addChild",
                            "com.firefly.wcreate.turnip.Container");

        digester.addCallMethod(prefix + "Host/Alias",
                               "addAlias", 0);

        //Cluster configuration start
        digester.addObjectCreate(prefix + "Host/Cluster",
                                 null, // MUST be specified in the element
                                 "className");
        digester.addSetProperties(prefix + "Host/Cluster");
        digester.addSetNext(prefix + "Host/Cluster",
                            "setCluster",
                            "com.firefly.wcreate.turnip.Cluster");
        //Cluster configuration end

        digester.addObjectCreate(prefix + "Host/Listener",
                                 null, // MUST be specified in the element
                                 "className");
        digester.addSetProperties(prefix + "Host/Listener");
        digester.addSetNext(prefix + "Host/Listener",
                            "addLifecycleListener",
                            "com.firefly.wcreate.turnip.LifecycleListener");

        digester.addRuleSet(new RealmRuleSet(prefix + "Host/"));

        digester.addObjectCreate(prefix + "Host/Valve",
                                 null, // MUST be specified in the element
                                 "className");
        digester.addSetProperties(prefix + "Host/Valve");
        digester.addSetNext(prefix + "Host/Valve",
                            "addValve",
                            "com.firefly.wcreate.turnip.Valve");

    }


}
