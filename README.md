## Backend приложения заметок

### Используемые технологии
- Spring
- Flyway
- Lombok
- MapStruct
- Docker
- PostgreSQL

### Особенности
- Приложение должно запускаться в Docker контейнере
- Basic Auth
- К сожалению без тестов и документации api :(

---

### Endpoints
- Notes
  - POST /api/notes
  - GET /api/notes/{id}
  - GET /api/notes
  - PATCH /api/notes/{id}
  - DELETE /api/notes/{id}

- Users
  - POST /api/users/register
  - POST /api/users/login