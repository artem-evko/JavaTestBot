package com.evko.JavaTestBot.demo.JavaTestBot.command;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

@DisplayName("CommandContainer unit-testing")
@ExtendWith(MockitoExtension.class)
public class CommandContainerTest {

    @Mock
    private List<Command> commands;

    @Mock
    private UnknownCommand unknownCommand;

    private CommandContainer commandContainer;

    @BeforeEach
    public void setUp() {
        commandContainer = new CommandContainer(commands, unknownCommand);
    }

    @Test
    public void shouldReturnUnknownCommandIfCommandNotFound() {
        // Given
        String unknownCommandIdentifier = "/unknown";
        when(commands.stream()).thenReturn(Stream.empty());

        // When
        Command command = commandContainer.retrieveCommand(unknownCommandIdentifier);

        // Then
        assertEquals(unknownCommand, command);
    }

    @Test
    public void shouldReturnCorrectCommandIfExists() {
        // Given
        String startCommandIdentifier = "/start";
        Command startCommand = new StartCommand();
        when(commands.stream()).thenReturn(Stream.of(startCommand));

        // When
        Command command = commandContainer.retrieveCommand(startCommandIdentifier);

        // Then
        assertEquals(startCommand, command);
    }
}
