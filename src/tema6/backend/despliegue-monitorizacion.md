# Backend

## Despliegue

### Monitorización

Los microservicios, al tener su lógica distribuida/desplegada en varios servidores, requieren de servicios extra de monitorización para:

- Conocer el estado de cada servidor, y poder balancear la carga uniformemente o escalar horizontalmente.
- Agregar las trazas de todas las instancias de un mismo microservicio[^1].
- Obtener métricas de uso y alertar de posibles problemas[^2].
- Hacer seguimento de las peticiones y los errores extremo a extremo[^3].

<object type="image/svg+xml" data="./files/img/monitoring.excalidraw.svg" width="100%"></object>

[^1]: Por ejemplo, mediante el uso de [ELK](https://www.elastic.co/es/what-is/elk-stack).

[^2]: Por ejemplo, mediante el uso de [Prometheus](https://prometheus.io/).

[^3]: Por ejemplo, mediante el uso de [Jaeger](https://www.jaegertracing.io/).