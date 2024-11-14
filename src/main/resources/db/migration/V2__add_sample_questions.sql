-- Вставка тестов
INSERT INTO test (name) VALUES
    ('Основы Java'),
    ('Массивы'),
    ('ООП'),
    ('Коллекции');

-- Вставка вопросов для теста "Основы Java"
INSERT INTO question (text, difficulty, question_type) VALUES
    ('Что такое JVM?', 1, 'MULTIPLE_CHOICE'),
    ('Какой тип данных используется для хранения целых чисел?', 1, 'MULTIPLE_CHOICE'),
    ('Какое ключевое слово используется для создания объекта?', 1, 'MULTIPLE_CHOICE'),
    ('Что такое JDK?', 1, 'MULTIPLE_CHOICE'),
    ('Что такое переменная?', 1, 'MULTIPLE_CHOICE'),
    ('Какой оператор используется для деления?', 1, 'MULTIPLE_CHOICE'),
    ('Что означает ключевое слово "final"?', 2, 'MULTIPLE_CHOICE');

-- Вставка вопросов для теста "Массивы"
INSERT INTO question (text, difficulty, question_type) VALUES
    ('Как получить длину массива в Java?', 1, 'MULTIPLE_CHOICE'),
    ('Можно ли изменить размер массива после его создания?', 2, 'MULTIPLE_CHOICE'),
    ('Как инициализировать массив?', 1, 'MULTIPLE_CHOICE'),
    ('Что произойдет, если обратиться к элементу массива вне его границ?', 2, 'MULTIPLE_CHOICE'),
    ('Как скопировать массив?', 2, 'MULTIPLE_CHOICE'),
    ('Как отсортировать массив?', 2, 'MULTIPLE_CHOICE'),
    ('Что возвращает метод Arrays.binarySearch() при неудачном поиске?', 2, 'MULTIPLE_CHOICE');

-- Вставка вопросов для теста "ООП"
INSERT INTO question (text, difficulty, question_type) VALUES
    ('Что такое наследование?', 1, 'MULTIPLE_CHOICE'),
    ('Что такое инкапсуляция?', 1, 'MULTIPLE_CHOICE'),
    ('Что такое полиморфизм?', 2, 'MULTIPLE_CHOICE'),
    ('Какое ключевое слово используется для создания абстрактного класса?', 2, 'MULTIPLE_CHOICE'),
    ('Какой метод используется для создания объекта?', 1, 'MULTIPLE_CHOICE'),
    ('Что такое интерфейс?', 2, 'MULTIPLE_CHOICE'),
    ('Может ли класс реализовывать несколько интерфейсов?', 2, 'MULTIPLE_CHOICE');

-- Вставка вопросов для теста "Коллекции"
INSERT INTO question (text, difficulty, question_type) VALUES
    ('Что такое ArrayList?', 1, 'MULTIPLE_CHOICE'),
    ('Как добавить элемент в HashMap?', 2, 'MULTIPLE_CHOICE'),
    ('Чем отличается HashSet от TreeSet?', 2, 'MULTIPLE_CHOICE'),
    ('Что такое Iterator?', 2, 'MULTIPLE_CHOICE'),
    ('Как удалить элемент из LinkedList?', 1, 'MULTIPLE_CHOICE'),
    ('Как отсортировать List?', 2, 'MULTIPLE_CHOICE'),
    ('Какой интерфейс реализует HashMap?', 2, 'MULTIPLE_CHOICE');

-- Привязка вопросов к тестам
INSERT INTO test_question (test_id, question_id) VALUES
    (1, 1), (1, 2), (1, 3), (1, 4), (1, 5), (1, 6), (1, 7),
    (2, 8), (2, 9), (2, 10), (2, 11), (2, 12), (2, 13), (2, 14),
    (3, 15), (3, 16), (3, 17), (3, 18), (3, 19), (3, 20), (3, 21),
    (4, 22), (4, 23), (4, 24), (4, 25), (4, 26), (4, 27), (4, 28);

-- Вставка ответов для теста "Основы Java"
INSERT INTO answer (question_id, text, is_correct) VALUES
    (1, 'Java Virtual Machine', TRUE), (1, 'Java Variable Manager', FALSE),
    (2, 'int', TRUE), (2, 'String', FALSE),
    (3, 'new', TRUE), (3, 'create', FALSE),
    (4, 'Java Development Kit', TRUE), (4, 'Java Debug Kit', FALSE),
    (5, 'Это именованная область памяти', TRUE), (5, 'Это тип данных', FALSE),
    (6, '/', TRUE), (6, '%', FALSE),
    (7, 'Запрещает изменение значения', TRUE), (7, 'Означает приватный доступ', FALSE);

-- Вставка ответов для теста "Массивы"
INSERT INTO answer (question_id, text, is_correct) VALUES
    (8, 'array.length', TRUE), (8, 'array.size()', FALSE),
    (9, 'Нет, размер фиксирован', TRUE), (9, 'Да, можно изменить', FALSE),
    (10, 'int[] array = new int[10];', TRUE), (10, 'array = int[10];', FALSE),
    (11, 'ArrayIndexOutOfBoundsException', TRUE), (11, 'NullPointerException', FALSE),
    (12, 'System.arraycopy()', TRUE), (12, 'Arrays.copy()', FALSE),
    (13, 'Arrays.sort()', TRUE), (13, 'Collections.sort()', FALSE),
    (14, 'Отрицательное значение', TRUE), (14, 'Ноль', FALSE);

-- Вставка ответов для теста "ООП"
INSERT INTO answer (question_id, text, is_correct) VALUES
    (15, 'Наследование позволяет классу использовать методы родительского класса', TRUE),
    (15, 'Наследование позволяет классу создавать объект другого класса', FALSE),
    (16, 'Инкапсуляция — это скрытие данных и методов', TRUE),
    (16, 'Инкапсуляция — это создание экземпляров классов', FALSE),
    (17, 'Полиморфизм позволяет методам изменять свое поведение', TRUE),
    (17, 'Полиморфизм означает создание новых объектов', FALSE),
    (18, 'abstract', TRUE), (18, 'static', FALSE),
    (19, 'new', TRUE), (19, 'create', FALSE),
    (20, 'Интерфейс — это контракт, который должен реализовываться классом', TRUE),
    (20, 'Интерфейс — это класс с пустыми методами', FALSE),
    (21, 'Да, может', TRUE), (21, 'Нет, не может', FALSE);

-- Вставка ответов для теста "Коллекции"
INSERT INTO answer (question_id, text, is_correct) VALUES
    (22, 'ArrayList — это динамический массив', TRUE),
    (22, 'ArrayList — это связанный список', FALSE),
    (23, 'hashMap.put(key, value);', TRUE), (23, 'hashMap.add(key, value);', FALSE),
    (24, 'HashSet неупорядочен, TreeSet упорядочен', TRUE),
    (24, 'HashSet упорядочен, TreeSet неупорядочен', FALSE),
    (25, 'Iterator используется для перебора элементов коллекции', TRUE),
    (25, 'Iterator используется для создания коллекций', FALSE),
    (26, 'linkedList.remove(index);', TRUE), (26, 'linkedList.delete(index);', FALSE),
    (27, 'Collections.sort(list);', TRUE), (27, 'Arrays.sort(list);', FALSE),
    (28, 'HashMap реализует интерфейс Map', TRUE),
    (28, 'HashMap реализует интерфейс List', FALSE);
