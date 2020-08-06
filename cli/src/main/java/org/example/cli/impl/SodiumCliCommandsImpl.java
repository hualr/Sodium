/*
 * Copyright © 2018 a1 and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.example.cli.impl;

import org.opendaylight.controller.md.sal.binding.api.DataBroker;
import org.example.cli.api.SodiumCliCommands;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SodiumCliCommandsImpl implements SodiumCliCommands {

    private static final Logger LOG = LoggerFactory.getLogger(SodiumCliCommandsImpl.class);
    private final DataBroker dataBroker;

    public SodiumCliCommandsImpl(final DataBroker db) {
        this.dataBroker = db;
        LOG.info("SodiumCliCommandImpl initialized");
    }

    @Override
    public Object testCommand(Object testArgument) {
        return "This is a test implementation of test-command";
    }
}
