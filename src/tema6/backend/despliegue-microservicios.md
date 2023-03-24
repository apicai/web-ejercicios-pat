# Backend

## Despliegue

### Microservicios

Actualmente, cada funcionalidad se despliega en un servidor separado (microservicio), lo cual facilita:

- Escalar horizontalmente cada funcionalidad en función de su demanda[^1].
- Construir cada funcionalidad con la tecnología más adecuada, y evolucionarlas independientemente del resto[^2].
- Evitar que los problemas en un microservicio afecten al resto del sistema, el cual puede seguir dando el servicio básico.

<object type="image/svg+xml" data="./files/img/microservices.excalidraw.svg" width="100%"></object>

[^1]: Para ello se utilizan [contenedores](../../intro/docker/docker.html) y [plataformas de gestión del hardware](../../intro/docker/orquestacion.html).

[^2]: Pero manteniendo la definición de sus APIs ("contratos" con el resto de servicios y clientes).