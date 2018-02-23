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
package com.firefly.wcreate.turnip.tribes.group.interceptors;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

import com.firefly.wcreate.turnip.tribes.ChannelMessage;
import com.firefly.wcreate.turnip.tribes.Member;
import com.firefly.wcreate.turnip.tribes.group.ChannelInterceptorBase;
import com.firefly.wcreate.turnip.tribes.membership.MemberImpl;
import com.firefly.wcreate.turnip.tribes.membership.Membership;
import com.firefly.wcreate.juli.logging.Log;
import com.firefly.wcreate.juli.logging.LogFactory;

/**
 * <p>Title: Member domain filter interceptor </p>
 *
 * <p>Description: Filters membership based on domain.
 * </p>
 *
 * @author Filip Hanik
 * @version 1.0
 */
public class DomainFilterInterceptor extends ChannelInterceptorBase {
    private static final Log log = LogFactory.getLog(DomainFilterInterceptor.class);
    protected Membership membership = null;
    
    protected byte[] domain = new byte[0];
    protected int logInterval = 100;
    private final AtomicInteger logCounter = new AtomicInteger(logInterval);

    @Override
    public void messageReceived(ChannelMessage msg) {
        if (Arrays.equals(domain, msg.getAddress().getDomain())) {
            super.messageReceived(msg);
        } else {
            if (logCounter.incrementAndGet() >= logInterval) {
                logCounter.set(0);
                if (log.isWarnEnabled())
                    log.warn("Received message from cluster["+msg.getAddress()+"] was refused.");
            }
        }
    }//messageReceived


    @Override
    public void memberAdded(Member member) {
        if ( membership == null ) setupMembership();
        boolean notify = false;
        synchronized (membership) {
            notify = Arrays.equals(domain,member.getDomain());
            if ( notify ) notify = membership.memberAlive((MemberImpl)member);
        }
        if ( notify ) {
            super.memberAdded(member);
        } else {
            if(log.isInfoEnabled()) log.info("Member was refused to join cluster["+member+"]");
        }
    }

    @Override
    public void memberDisappeared(Member member) {
        if ( membership == null ) setupMembership();
        boolean notify = false;
        synchronized (membership) {
            notify = Arrays.equals(domain,member.getDomain());
            if ( notify ) membership.removeMember((MemberImpl)member);
        }
        if ( notify ) super.memberDisappeared(member);
    }

    @Override
    public boolean hasMembers() {
        if ( membership == null ) setupMembership();
        return membership.hasMembers();
    }

    @Override
    public Member[] getMembers() {
        if ( membership == null ) setupMembership();
        return membership.getMembers();
    }

    @Override
    public Member getMember(Member mbr) {
        if ( membership == null ) setupMembership();
        return membership.getMember(mbr);
    }

    @Override
    public Member getLocalMember(boolean incAlive) {
        return super.getLocalMember(incAlive);
    }


    protected synchronized void setupMembership() {
        if ( membership == null ) {
            membership = new Membership((MemberImpl)super.getLocalMember(true));
        }

    }

    public byte[] getDomain() {
        return domain;
    }

    public void setDomain(byte[] domain) {
        this.domain = domain;
    }

    public void setDomain(String domain) {
        if ( domain == null ) return;
        if (domain.startsWith("{"))
            setDomain(com.firefly.wcreate.turnip.tribes.util.Arrays.fromString(domain));
        else
            setDomain(com.firefly.wcreate.turnip.tribes.util.Arrays.convert(domain));
    }

    public int getLogInterval() {
        return logInterval;
    }

    public void setLogInterval(int logInterval) {
        this.logInterval = logInterval;
    }

}
