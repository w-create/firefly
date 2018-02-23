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
package com.firefly.wcreate.turnip.tribes.group;

import java.io.Serializable;

import com.firefly.wcreate.turnip.tribes.Member;

/**
 * A response object holds a message from a responding partner.
 * @author Filip Hanik
 * @version 1.0
 */
public class Response {
    private Member source;
    private Serializable message;
    public Response() {
    }
    
    public Response(Member source, Serializable message) {
        this.source = source;
        this.message = message;
    }

    public void setSource(Member source) {
        this.source = source;
    }

    public void setMessage(Serializable message) {
        this.message = message;
    }

    public Member getSource() {
        return source;
    }

    public Serializable getMessage() {
        return message;
    }
}