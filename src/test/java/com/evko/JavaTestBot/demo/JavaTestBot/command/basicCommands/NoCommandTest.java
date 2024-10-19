package com.evko.JavaTestBot.demo.JavaTestBot.command.basicCommands;

import com.evko.JavaTestBot.demo.JavaTestBot.command.Command;
import com.evko.JavaTestBot.demo.JavaTestBot.command.NoCommand;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Unit testing for NoCommand")
public class NoCommandTest extends AbstractCommandTest{
    @Override
    String getCommandMessage() {
        return NoCommand.NO_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new NoCommand();
    }
}
