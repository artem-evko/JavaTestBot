package com.evko.JavaTestBot.demo.JavaTestBot.command.basicCommands;

import com.evko.JavaTestBot.demo.JavaTestBot.command.Command;
import com.evko.JavaTestBot.demo.JavaTestBot.command.StartCommand;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Unit testing for StartCommand")
public class StartCommandTest extends AbstractCommandTest {
    @Override
    String getCommandMessage() {
        return StartCommand.START_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StartCommand();
    }
}
