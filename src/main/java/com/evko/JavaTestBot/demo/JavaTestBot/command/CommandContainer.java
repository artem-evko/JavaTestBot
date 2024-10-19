package com.evko.JavaTestBot.demo.JavaTestBot.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CommandContainer {
    private final List<Command> commands;
    private final UnknownCommand unknownCommand;

    public Command retrieveCommand(String commandIdentifier){
        return commands.stream()
                .filter(command -> commandIdentifier.equalsIgnoreCase(command.getCommandIdentifier()))
                .findFirst()
                .orElse(unknownCommand);
    }

}
