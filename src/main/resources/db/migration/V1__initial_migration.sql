CREATE TABLE IF NOT EXISTS question (
    id INT AUTO_INCREMENT PRIMARY KEY,
    text VARCHAR(255) NOT NULL,
    difficulty TINYINT NOT NULL,  -- Убрано CHECK для совместимости с MySQL 5.7
    question_type ENUM('MULTIPLE_CHOICE', 'OPEN_ENDED') NOT NULL
);

-- Создание таблицы ответов
CREATE TABLE IF NOT EXISTS answer (
    id INT AUTO_INCREMENT PRIMARY KEY,
    question_id INT,
    text VARCHAR(255) NOT NULL,
    is_correct BOOLEAN NOT NULL,  -- Используем BOOLEAN (псевдоним для TINYINT(1))
    FOREIGN KEY (question_id) REFERENCES question(id) ON DELETE CASCADE
);

-- Создание таблицы пользователей Telegram
CREATE TABLE IF NOT EXISTS tg_user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    telegram_id BIGINT UNIQUE NOT NULL,
    username VARCHAR(50)
);

-- Создание таблицы результатов тестов
CREATE TABLE IF NOT EXISTS test_result (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    score INT NOT NULL,
    completed_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES tg_user(id) ON DELETE CASCADE
);