# Backend

## Spring

### Trazas

Permiten monitorizar la ejecución de la aplicación para detectar problemas. Para añadir trazas al código:

```java
private Logger logger = LoggerFactory.getLogger(getClass());
logger.error("Cuando se produce un error inesperado en la lógica que hay que revisar", exception);
logger.warn("Cuando la lógica detecta algo que hay que mantener");
logger.info("Información importante para hacer seguimiento de la ejecución");
logger.debug("Información que ayuda a identificar problemas");
logger.trace("Trazas de ayuda durante el {}", "desarrollo");
```

> 🔍 **Nota:** _La configuración por defecto del `logger` sólo pinta las trazas de nivel `info` o superior (`warn` y `error`) por la salida estándar. En caso de necesidad, se puede cambiar dicho nivel con la siguiente configuración de la aplicación Spring:_
> ```properties
> logging.level.root=debug
> ```

Ejemplos de trazas:

```log
Fecha traza         NIVEL PID  --- [  hilo] Clase/nombre logger : Texto de la traza
2023-03-17T13:15:05 ERROR 7934 --- [  main] SpringApplication : Application run failed
2023-03-17T13:27:02  WARN 8034 --- [  main] User : User.withDefaultPasswordEncoder() is considered unsafe for production and is only intended for sample applications.
2023-03-17T13:27:06  INFO 8034 --- [  main] MvcApplication : Starting MvcApplication using Java 18.0.2.1 with PID 8034
2023-03-17T13:33:28 DEBUG 8034 --- [exec-2] DispatcherServlet : POST "/api/contadores", parameters={}
```
