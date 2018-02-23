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
package com.firefly.wcreate.jasper.compiler;

import com.firefly.wcreate.jasper.JspCompilationContext;

/**
 * Defines the interface for the expression language interpreter. This allows
 * users to provide custom EL interpreter implementations that can optimise
 * EL processing for an application by , for example, performing code generation
 * for simple expressions.
 */
public interface ELInterpreter {

    /**
     * Returns the string representing the code that will be inserted into the
     * servlet generated for JSP. The default implementation creates a call to
     * {@link com.firefly.wcreate.jasper.runtime.PageContextImpl#proprietaryEvaluate(
     * String, Class, javax.servlet.jsp.PageContext,
     * com.firefly.wcreate.jasper.runtime.ProtectedFunctionMapper, boolean)} but other
     * implementations may produce more optimised code.
     *
     * @param expression a String containing zero or more "${}" expressions
     * @param expectedType the expected type of the interpreted result
     * @param fnmapvar Variable pointing to a function map.
     * @param xmlEscape True if the result should do XML escaping
     * @return a String representing a call to the EL interpreter.
     */
    public String interpreterCall(JspCompilationContext context,
            boolean isTagFile, String expression,
            Class<?> expectedType, String fnmapvar, boolean xmlEscape);
}
