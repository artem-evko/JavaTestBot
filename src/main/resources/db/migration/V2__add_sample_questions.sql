INSERT INTO question (text, difficulty, question_type) VALUES
    ('Какой метод позволяет переделать int в String?', 1, 'MULTIPLE_CHOICE'),
    ('Какой оператор используется для сравнения двух значений?', 1, 'MULTIPLE_CHOICE'),
    ('Какой метод используется для получения длины массива в Java?', 2, 'MULTIPLE_CHOICE'),
    ('Назовите базовый класс для всех классов в Java.', 2, 'OPEN_ENDED'),
    ('Какой метод используется для добавления элемента в список?', 2, 'MULTIPLE_CHOICE');

-- Вставка ответов
INSERT INTO answer (question_id, text, is_correct) VALUES
    (1, 'String.valueOf(int)', TRUE),
    (1, 'Integer.toString(int)', TRUE),
    (1, 'StringBuilder.append(int)', FALSE),
    (2, '==', TRUE),
    (2, '!=', FALSE),
    (3, '.length()', TRUE),
    (3, '.length', FALSE),
    (4, 'Object', TRUE),  -- Ответ для открытого вопроса
    (4, 'Base', FALSE),
    (5, '.add()', TRUE),
    (5, '.put()', FALSE);
-- Вставка теста
INSERT INTO test (name) VALUES ('Тест 1');

-- Получение id теста для добавления вопросов (предполагаем, что это id = 1)
-- Привязка вопросов к тесту (предполагаем, что id теста = 1)
INSERT INTO test_question (test_id, question_id) VALUES
    (1, 1),  -- Связываем Тест 1 с вопросом 1
    (1, 2),  -- Связываем Тест 1 с вопросом 2
    (1, 3),  -- Связываем Тест 1 с вопросом 3
    (1, 4),  -- Связываем Тест 1 с вопросом 4
    (1, 5)
     ON DUPLICATE KEY UPDATE question_id = question_id;
