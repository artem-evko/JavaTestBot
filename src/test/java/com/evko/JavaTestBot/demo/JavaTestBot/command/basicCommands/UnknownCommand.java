package com.evko.JavaTestBot.demo.JavaTestBot.command.basicCommands;

import com.evko.JavaTestBot.demo.JavaTestBot.command.Command;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Unit testing for UnknownCommand")
public class UnknownCommand extends AbstractCommandTest {
    @Override
    String getCommandMessage() {
        return com.evko.JavaTestBot.demo.JavaTestBot.command.UnknownCommand.UNKNOWN_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new com.evko.JavaTestBot.demo.JavaTestBot.command.UnknownCommand();
    }
}
