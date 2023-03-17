# Backend

## Spring

### Tareas programadas

El framework de Spring permite crear otros tipos de aplicaciones. Las tareas programadas, por ejemplo, permiten ejecutar periódicamente una tarea de limpieza de disco o de movimiento de datos de un sistema a otro.

Para configurar una tarea se usan las siguientes anotaciones:

- `@Scheduled` sobre el método a ejecutar de forma periódica de una clase anotada con `@Component`. Se puede configurar con un periodo fijo o con una [expresión Cron](https://spring.io/blog/2020/11/10/new-in-spring-5-3-improved-cron-expressions).

- `@EnableScheduling` sobre la clase de configuración de la aplicación para habilitar las anotaciones anteriores.

```java
@Component
public class TareasProgramadas {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Scheduled(fixedRate = 300000)
    public void ritmoFijo() {
        logger.info("Me ejecuto cada 5 minutos");
    }

    @Scheduled(cron = "0 * * * * *")
    public void expresionCron() {
        logger.info("Me ejecuto cuando empieza un nuevo minuto");
    }
}
```