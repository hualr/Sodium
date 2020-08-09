/*
 * Copyright © 2018 a1 and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.example.impl;

import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.opendaylight.mdsal.binding.api.RpcProviderService;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.sodium.rev180517.SodiumService;
import org.opendaylight.yangtools.concepts.ObjectRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SodiumProvider {

    private static final Logger LOG = LoggerFactory.getLogger(SodiumProvider.class);
    private final DataBroker dataBroker;
    //private ObjectRegistration<SodiumService> sodiumServiceObjectRegistration;
    //private RpcProviderService rpcProviderService;
    private ObjectRegistration<SodiumService> sodiumService;
    private RpcProviderService rpcProviderService;

    public SodiumProvider(final DataBroker dataBroker, final RpcProviderService rpcProviderService) {
        this.dataBroker = dataBroker;
        this.rpcProviderService = rpcProviderService;
    }

    /**
     * Method called when the blueprint container is created.
     */
    public void init() {
        LOG.info("HelloProvider Session Initiated");
        sodiumService = rpcProviderService.
                registerRpcImplementation(SodiumService.class, new SodiumProviderImpl());
    }

    /**
     * Method called when the blueprint container is destroyed.
     */
    public void close() {
        LOG.info("SodiumProvider Closed");
    }


}