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


package com.firefly.wcreate.turnip.tribes.transport;

import com.firefly.wcreate.turnip.tribes.io.XByteBuffer;

/**
 * Manifest constants for the <code>com.firefly.wcreate.turnip.tribes.transport</code>
 * package.
 * @author Filip Hanik
 * @author Peter Rossbach
 */
public class Constants {

    public static final String Package = "com.firefly.wcreate.turnip.tribes.transport";
    
    /*
     * Do not change any of these values!
     */
    public static final byte[] ACK_DATA = new byte[] {6, 2, 3};
    public static final byte[] FAIL_ACK_DATA = new byte[] {11, 0, 5};
    public static final byte[] ACK_COMMAND = XByteBuffer.createDataPackage(ACK_DATA);
    public static final byte[] FAIL_ACK_COMMAND = XByteBuffer.createDataPackage(FAIL_ACK_DATA);

}
