package com.evko.JavaTestBot.demo.JavaTestBot.command.basicCommands;

import com.evko.JavaTestBot.demo.JavaTestBot.bot.JavaTestBot;
import com.evko.JavaTestBot.demo.JavaTestBot.command.Command;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public abstract class AbstractCommandTest {
    abstract String getCommandMessage();

    abstract Command getCommand();

    protected JavaTestBot javaTestBot= Mockito.mock(JavaTestBot.class);

    @Test
    public void CommandShouldExecuteProperly() throws TelegramApiException {
        long chatID=1231232342313L;

        Update update=Mockito.mock(Update.class);
        Message message = Mockito.mock(Message.class);

        when(update.getMessage()).thenReturn(message);
        when(message.getChatId()).thenReturn(chatID);

        SendMessage sendMessage=new SendMessage();
        sendMessage.setChatId(String.valueOf(chatID));
        sendMessage.setText(getCommandMessage());
        sendMessage.enableHtml(true);

        javaTestBot.execute(getCommand().buildResponse(update));

        verify(javaTestBot).execute(sendMessage);
    }
    public static Update preparedUpdate(Long chatID, String messageText)

    {
        Message message = Mockito.mock(Message.class);
        when(message.getChatId()).thenReturn(chatID);
        when(message.getText()).thenReturn(messageText);

        Update update = new Update();
        update.setMessage(message);

        return update;

    }
}
