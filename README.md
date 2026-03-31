# Test-for-Mock

Демо-проект для библиотеки **Mock** из `PPO/Mock-Framework`.

## Структура

- **Библиотека**: импортируется из `../Mock-Framework` через Gradle composite build
- **Приложение**: `demo.app` — UserRegistrationService, DemoApplication
- **Тесты**: `demo.tests` — демонстрация возможностей Joke Mock

## Запуск

```bash
./gradlew build    # сборка
./gradlew test     # тесты
./gradlew run      # запуск приложения
```

## Демо API

### @Mock, when, thenReturn, thenThrow
- `MockInterfaceTest` — мокирование интерфейсов
- `WhenThenThrowTest` — выброс исключений
- `AnnotationMockTest` — аннотация @Mock с JokeMockExtension

### spy, doReturn, doThrow
- `SpyDoReturnDoThrowTest` — spy на List, doReturn().when(), doThrow().when()

### Интеграционный пример
- `UserRegistrationServiceTest` — сервис с замоканными NotificationGateway и AuditGateway
