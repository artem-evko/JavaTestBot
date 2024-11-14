package com.evko.JavaTestBot.demo.JavaTestBot.service;

import com.evko.JavaTestBot.demo.JavaTestBot.repository.UserRepository;
import com.evko.JavaTestBot.demo.JavaTestBot.repository.entity.TgUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public TgUser getOrCreateUser(Long telegramId, String username) {
        return userRepository.findByTelegramId(telegramId)
                .orElseGet(() -> createUser(telegramId, username));
    }
    public TgUser createUser(Long telegramId, String username) {
        TgUser user = new TgUser();
        user.setTelegramId(telegramId);
        user.setUsername(username);
        return userRepository.save(user);
    }
    public Optional<TgUser> findByTelegramId(Long telegramId){
        return  userRepository.findByTelegramId(telegramId);
    }
}
