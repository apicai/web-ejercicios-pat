# Backend

## Jakarta EE

### Patrón DI

Jakarta EE también define un sistema para crear y proporcionar automáticamente los objetos comunes del servicio a las aplicaciones que se ejecutan en el servidor.

<object type="image/svg+xml" data="./files/img/di.excalidraw.svg" width="100%"></object>

La inyección de dependencias es un patrón que ayuda a generar código más configurable, reusable y testeable. Todos los objetos son instanciados por el sistema de DI e inyectados en tiempo de ejecución. En el caso de Jakarta EE, esto se realiza utilizando [anotaciones](https://en.wikipedia.org/wiki/Java_annotation) e [interfaces](https://en.wikipedia.org/wiki/Interface_(Java)) Java.