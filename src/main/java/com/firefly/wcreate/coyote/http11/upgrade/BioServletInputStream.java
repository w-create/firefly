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
package com.firefly.wcreate.coyote.http11.upgrade;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import com.firefly.wcreate.rabbit.util.net.SocketWrapper;

public class BioServletInputStream extends AbstractServletInputStream {

    private final InputStream inputStream;

    public BioServletInputStream(SocketWrapper<Socket> wrapper)
            throws IOException {
        inputStream = wrapper.getSocket().getInputStream();
    }

    @Override
    protected int doRead(boolean block, byte[] b, int off, int len)
            throws IOException {
        return inputStream.read(b, off, len);
    }

    @Override
    protected boolean doIsReady() {
        // Always returns true for BIO
        return true;
    }

    @Override
    protected void doClose() throws IOException {
        inputStream.close();
    }
}
