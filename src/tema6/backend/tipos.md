# Backend

## Tipos

Los backends son diferentes dependiendo del protocolo (HTTP, [WebSockets](https://en.wikipedia.org/wiki/WebSocket), [AMQP](https://en.wikipedia.org/wiki/Advanced_Message_Queuing_Protocol), etc.), de la funcionalidad (procesamiento, servicio web, etc.) o de sus usuarios (dispositivos IoT, otros servicios, personas, etc.). En el caso de aplicaciones web, existen dos aproximaciones:

1. **Server-side rendering:** la presentación final se genera en el servidor.

2. **API REST:** el servidor retorna los datos en un formato independiente que luego será procesado en el cliente para su presentación.

<object type="image/svg+xml" data="./files/img/ssr-api-rest.excalidraw.svg" width="100%"></object>

> 🔍 **Nota:** _La estrategia seguida en el backend influirá en su frontend web, que podrá ser de tipo multipágina o de página única._
> <details><summary><em>Multipágina...</em></summary><br>
> <object type="image/svg+xml" data="./files/img/web.multipagina.excalidraw.svg" width="100%"></object>
> </details>
> <details><summary><em>Página única...</em></summary><br>
> <object type="image/svg+xml" data="./files/img/web.spa.excalidraw.svg" width="100%"></object>
> </details><br>

