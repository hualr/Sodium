/*
 * Copyright © 2018 a1 and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.example.cli.commands;

import org.apache.karaf.shell.commands.Command;
import org.apache.karaf.shell.commands.Option;
import org.apache.karaf.shell.console.AbstractAction;
import org.example.cli.api.SodiumCliCommands;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is an example class. The class name can be renamed to match the command implementation that it will invoke.
 * Specify command details by updating the fields in the Command annotation below.
 */
@Command(name = "test-command", scope = "add the scope of the command, usually project name",
        description = "add a description for the command")
public class SodiumCliTestCommand extends AbstractAction {

    private static final Logger LOG = LoggerFactory.getLogger(SodiumCliTestCommand.class);
    protected final SodiumCliCommands service;

    public SodiumCliTestCommand(final SodiumCliCommands service) {
        this.service = service;
    }

    /**
     * Add the arguments required by the command.
     * Any number of arguments can be added using the Option annotation
     * The below argument is just an example and should be changed as per your requirements
     */
    @Option(name = "-tA",
            aliases = { "--testArgument" },
            description = "test command argument",
            required = true,
            multiValued = false)
    private Object testArgument;

    @Override
    protected Object doExecute() throws Exception {
        /**
         * Invoke commannd implementation here using the service instance.
         * Implement how you want the output of the command to be displayed.
         * Below is just an example.
         */
        final String testMessage = (String) service.testCommand(testArgument);
        LOG.info("zq-hello karaf cmd");
        return testMessage;
    }
}
