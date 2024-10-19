package com.evko.JavaTestBot.demo.JavaTestBot.command;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@DisplayName("CommandContainer unit-testing")
@ExtendWith(MockitoExtension.class)
@RequiredArgsConstructor
public class CommandContainerTest {
    private CommandContainer commandContainer;

    @Test
    public void allCommandsExists() {
        //when-then
        Arrays.stream(CommandName.values())
                .forEach(
                        value ->
                        {
                            String commandName = value.getCommandName();
                            Command command = commandContainer.retrieveCommand(commandName);
                            assertNotEquals(UnknownCommand.class, command.getClass());
                        }
                );
    }

    @Test
    public void ShouldBeUnknownCommand() {
        //given
        String commandName = "dfgdfg";

        //when
        Command command = commandContainer.retrieveCommand(commandName);

        //then

        assertEquals(UnknownCommand.class, command.getClass());
    }

}
