#  Polling App

Система для создания опросов и сбора голосов. Пользователи могут регистрироваться, создавать опросы с вариантами ответов, голосовать (один раз на опрос) и просматривать результаты в реальном времени. Проект написан на **Spring Boot** с использованием **JPA/Hibernate**, **PostgreSQL**, **Spring Security**, **JWT** и **Swagger**.

---

##  Бизнес-логика

- **Пользователь** регистрируется, авторизуется (JWT токен).
- Создаёт **опрос**: вопрос, список вариантов ответов, срок действия (в днях).
- Пользователи могут **голосовать** за один из вариантов.
- **Ограничение**: один пользователь может проголосовать только один раз в конкретном опросе.
- **Просмотр результатов**: для каждого опроса отображается количество голосов за каждый вариант и проценты.
- **Закрытие опроса**: автоматически по истечении срока или вручную владельцем опроса.

---

##  Технологический стек

| Компонент | Технология |
|-----------|-------------|
| **Язык** | Java 17 |
| **Фреймворк** | Spring Boot 4.0.5 |
| **Безопасность** | Spring Security + JWT |
| **ORM** | Hibernate (JPA) |
| **База данных** | PostgreSQL |
| **Маппинг DTO** | MapStruct |
| **Документация API** | SpringDoc OpenAPI (Swagger) |
| **Сборка** | Maven |

---

##  Структура проекта (основные пакеты)

---

##  Основные API эндпоинты

### Пользователи
| Метод | Эндпоинт | Описание |
|-------|----------|-----------|
| POST | `/api/users/register` | Регистрация |
| POST | `/api/users/login` | Логин (JWT) |
| POST | `/api/users/updateInfo` | Обновить профиль |
| GET | `/api/users/{id}/polls` | Список опросов пользователя |

### Опросы
| Метод | Эндпоинт | Описание |
|-------|----------|-----------|
| POST | `/api/polls/create` | Создать опрос |
| GET | `/api/polls/all` | Все опросы (с вариантами и голосами) |
| PUT | `/api/polls/close/poll/{pollId}/owner/{ownerId}` | Закрыть опрос (владелец) |

### Голосование
| Метод | Эндпоинт | Описание |
|-------|----------|-----------|
| POST | `/api/votes/create?userId={userId}&optionId={optionId}` | Проголосовать |
| DELETE | `/api/votes/user/{userId}/option/{optionId}/cancelVote` | Отменить голос |
| GET | `/api/votes/user/{userId}/list` | Список голосов пользователя |
| GET | `/api/votes/poll/{pollId}/count` | Общее количество голосов в опросе |
| GET | `/api/votes/poll/{pollId}/options/values` | Голоса по каждому варианту |

### Варианты ответов
| Метод | Эндпоинт | Описание |
|-------|----------|-----------|
| POST | `/api/options/add` | Добавить вариант к опросу |
| GET | `/api/options/poll/{pollId}` | Список вариантов опроса |

---

##  Логика голосования

- **Уникальность голоса**: проверяется через таблицу `Vote` (связка `user_id` + `option_id`). Один пользователь не может голосовать дважды за один опрос.
- **Активность опроса**: если опрос закрыт (по дате или вручную), голосование запрещено.
- **Результаты**: агрегируются через JPQL запрос с `GROUP BY`.

---

##  Запуск и тестирование

### Локальный запуск
1. Установить PostgreSQL, создать БД `polling_db`.
2. Настроить `application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/polling_db
   spring.datasource.username=postgres
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   jwt.secret=mySuperSecretKeyForJWT12345!@#$%^&*()
   jwt.expiration=86400000POST /api/users/register
{
    "username": "alex",
    "email": "alex@example.com",
    "password": "pass123"
}POST /api/users/login
{
    "username": "alex",
    "password": "pass123"
}POST /api/polls/create
{
    "question": "Любимый язык программирования?",
    "usernameCreator": "alex",
    "validityPeriodDay": 7
}POST /api/votes/create?userId=1&optionId=1
