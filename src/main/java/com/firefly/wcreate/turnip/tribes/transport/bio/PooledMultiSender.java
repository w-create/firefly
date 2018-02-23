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
package com.firefly.wcreate.turnip.tribes.transport.bio;

import com.firefly.wcreate.turnip.tribes.ChannelException;
import com.firefly.wcreate.turnip.tribes.ChannelMessage;
import com.firefly.wcreate.turnip.tribes.Member;
import com.firefly.wcreate.turnip.tribes.transport.AbstractSender;
import com.firefly.wcreate.turnip.tribes.transport.DataSender;
import com.firefly.wcreate.turnip.tribes.transport.MultiPointSender;
import com.firefly.wcreate.turnip.tribes.transport.PooledSender;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class PooledMultiSender extends PooledSender {
    

    public PooledMultiSender() {
        // NO-OP
    }
    
    @Override
    public void sendMessage(Member[] destination, ChannelMessage msg) throws ChannelException {
        MultiPointSender sender = null;
        try {
            sender = (MultiPointSender)getSender();
            if (sender == null) {
                ChannelException cx = new ChannelException("Unable to retrieve a data sender, time out("+getMaxWait()+" ms) error.");
                for (int i = 0; i < destination.length; i++) cx.addFaultyMember(destination[i], new NullPointerException("Unable to retrieve a sender from the sender pool"));
                throw cx;
            } else {
                sender.sendMessage(destination, msg);
            }
            sender.keepalive();
        }finally {
            if ( sender != null ) returnSender(sender);
        }
    }

    /**
     * getNewDataSender
     *
     * @return DataSender
     * TODO Implement this com.firefly.wcreate.turnip.tribes.transport.PooledSender
     *   method
     */
    @Override
    public DataSender getNewDataSender() {
        MultipointBioSender sender = new MultipointBioSender();
        AbstractSender.transferProperties(this,sender);
        return sender;
    }

}
