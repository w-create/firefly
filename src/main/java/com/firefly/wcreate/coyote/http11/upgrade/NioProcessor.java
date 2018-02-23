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

import com.firefly.wcreate.coyote.http11.upgrade.servlet31.HttpUpgradeHandler;
import com.firefly.wcreate.juli.logging.Log;
import com.firefly.wcreate.juli.logging.LogFactory;
import com.firefly.wcreate.rabbit.util.net.NioChannel;
import com.firefly.wcreate.rabbit.util.net.NioSelectorPool;
import com.firefly.wcreate.rabbit.util.net.SocketWrapper;

public class NioProcessor extends AbstractProcessor<NioChannel> {

    private static final Log log = LogFactory.getLog(NioProcessor.class);
    @Override
    protected Log getLog() {return log;}

    private static final int INFINITE_TIMEOUT = -1;

    public NioProcessor(SocketWrapper<NioChannel> wrapper,
            HttpUpgradeHandler httpUpgradeProcessor, NioSelectorPool pool,
            int asyncWriteBufferSize) {
        super(httpUpgradeProcessor,
                new NioServletInputStream(wrapper, pool),
                new NioServletOutputStream(wrapper, asyncWriteBufferSize, pool));

        wrapper.setTimeout(INFINITE_TIMEOUT);
    }
}
