# CoffeeOrder
### Проект созданный в рамках тех.задания от компании Уфанет

Проект написан на Java в связке со Spring Boot. При проектировании нужно было придерживаться подхода Event Sourcing.

## Запуск

Для проверки работоспособности был создан CreateEventController в котором есть два endpoint-а

``` Java
@RequestMapping("/api/v1")

@PostMapping("/create-event")
@GetMapping("/get-event/{id}")
```
