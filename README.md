# CoffeeOrder
### Проект созданный в рамках тех.задания от компании Уфанет

Проект написан на Java в связке со Spring Boot. При проектировании нужно было придерживаться подхода Event Sourcing.

## Запуск

Для проверки работоспособности был создан CreateEventController в котором есть два endpoint-а
```JAVA
@RequestMapping("/api/v1");
```
```JAVA
@GetMapping("/get-event/{id}");
```
``` Java
@PostMapping("/create-event")
```
POST BODY example for /create-event
```JSON
{
    "orderId": 1,
    "data": {
        "clientId": 1,
        "stuffId": 1,
        "expectedTime": "2024-03-20-20:25:25",
        "goodId": 1,
        "price": 200
    },
    "eventType": 1
}
```

