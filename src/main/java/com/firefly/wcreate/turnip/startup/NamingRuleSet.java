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
 * <p><strong>RuleSet</strong> for processing the JNDI Enterprise Naming
 * Context resource declaration elements.</p>
 *
 * @author Craig R. McClanahan
 * @author Remy Maucherat
 */
public class NamingRuleSet extends RuleSetBase {


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
    public NamingRuleSet() {

        this("");

    }


    /**
     * Construct an instance of this <code>RuleSet</code> with the specified
     * matching pattern prefix.
     *
     * @param prefix Prefix for matching pattern rules (including the
     *  trailing slash character)
     */
    public NamingRuleSet(String prefix) {

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

        digester.addObjectCreate(prefix + "Ejb",
                                 "com.firefly.wcreate.turnip.deploy.ContextEjb");
        digester.addRule(prefix + "Ejb", new SetAllPropertiesRule());
        digester.addRule(prefix + "Ejb",
                new SetNextNamingRule("addEjb",
                            "com.firefly.wcreate.turnip.deploy.ContextEjb"));

        digester.addObjectCreate(prefix + "Environment",
                                 "com.firefly.wcreate.turnip.deploy.ContextEnvironment");
        digester.addSetProperties(prefix + "Environment");
        digester.addRule(prefix + "Environment",
                            new SetNextNamingRule("addEnvironment",
                            "com.firefly.wcreate.turnip.deploy.ContextEnvironment"));

        digester.addObjectCreate(prefix + "LocalEjb",
                                 "com.firefly.wcreate.turnip.deploy.ContextLocalEjb");
        digester.addRule(prefix + "LocalEjb", new SetAllPropertiesRule());
        digester.addRule(prefix + "LocalEjb",
                new SetNextNamingRule("addLocalEjb",
                            "com.firefly.wcreate.turnip.deploy.ContextLocalEjb"));

        digester.addObjectCreate(prefix + "Resource",
                                 "com.firefly.wcreate.turnip.deploy.ContextResource");
        digester.addRule(prefix + "Resource", new SetAllPropertiesRule());
        digester.addRule(prefix + "Resource",
                new SetNextNamingRule("addResource",
                            "com.firefly.wcreate.turnip.deploy.ContextResource"));

        digester.addObjectCreate(prefix + "ResourceEnvRef",
            "com.firefly.wcreate.turnip.deploy.ContextResourceEnvRef");
        digester.addRule(prefix + "ResourceEnvRef", new SetAllPropertiesRule());
        digester.addRule(prefix + "ResourceEnvRef",
                new SetNextNamingRule("addResourceEnvRef",
                            "com.firefly.wcreate.turnip.deploy.ContextResourceEnvRef"));

        digester.addObjectCreate(prefix + "ServiceRef",
            "com.firefly.wcreate.turnip.deploy.ContextService");
        digester.addRule(prefix + "ServiceRef", new SetAllPropertiesRule());
        digester.addRule(prefix + "ServiceRef",
                new SetNextNamingRule("addService",
                            "com.firefly.wcreate.turnip.deploy.ContextService"));

        digester.addObjectCreate(prefix + "Transaction",
            "com.firefly.wcreate.turnip.deploy.ContextTransaction");
        digester.addRule(prefix + "Transaction", new SetAllPropertiesRule());
        digester.addRule(prefix + "Transaction",
                new SetNextNamingRule("setTransaction",
                            "com.firefly.wcreate.turnip.deploy.ContextTransaction"));

    }


}
