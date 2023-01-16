# HTTP
## Respuestas

Las respuestas HTTP tienen un formato similar al de las peticiones, y están compuestas por: línea de estado (`HTTP/{version} {código} {descripción}`), cabeceras y cuerpo. Los códigos de estado se agrupan en 5 categorías: `1xx` informativo, `2xx` éxito, `3xx` redirección, `4xx` error del cliente y `5xx` error del servidor.

1. Un ejemplo de respuesta `1xx` se produce cuando se negocia el protocolo de comunicación con el servidor (como vimos en HTTP/2 o en el caso de WebSockets[^1]). Usa este `telnet` para hacer la siguiente petición:
   ```bash
   telnet demo.piesocket.com 80
   ```
   ```http
   GET /v3/channel_123 HTTP/1.1
   Host: demo.piesocket.com
   Upgrade: websocket
   Connection: Upgrade
   Sec-WebSocket-Key: dGhlIHNhbXBsZSBub25jZQ==
   Sec-WebSocket-Version: 13

   ```

1. La respuesta `2xx` más común es `200 OK` que suele venir acompañada de un cuerpo. Éste se envía de manera similar al visto en un `POST` y va acompañado de las mismas cabeceras. Usa este `telnet` para hacer las siguientes peticiones:
   ```bash
   telnet httpbin.org 80
   ```
   ```http
   GET /image/png HTTP/1.0

   ```
   ```http
   GET /gzip HTTP/1.0

   ```
   > ⁉️ **Pregunta:** _Si tuvieras que implementar un navegador web ¿cómo sabrías interpretar cada uno de los cuerpos de las respuestas anteriores?_

1. Un caso de típico de redirección `3xx` sucede cuando se navega a una web usando `http` para redirigir a `https`. Usa este `telnet` para hacer la siguiente petición:
   ```bash
   telnet github.com 80
   ```
   ```http
   HEAD / HTTP/1.1
   Host: github.com

   ```
   > ⁉️ **Pregunta:** _¿Para qué otros casos usarías redirecciones?_

1. Los errores `4xx` corresponden a peticiones incorrectas, y normalmente repetirlas no va a hacer que funcione. El ejemplo típico es cuando se solicita un recurso inexistente: `404 Not Found`. Otro ejemplo ocurre cuando una web solicita credenciales para acceder. Usa este `telnet` para hacer las siguientes peticiones:
   ```bash
   telnet httpbin.org 80
   ```
   ```http
   GET /basic-auth/user/pass HTTP/1.0

   ```
   ```http
   GET /basic-auth/user/pass HTTP/1.0
   Authorization: Basic dXNlcjpwYXNz

   ```
   > ⁉️ **Pregunta:** _La autenticacion básica no cifra el usuario y password de manera segura[^2]. Para asegurar que no se filtren ¿qué otra cosa deberíamos usar con este tipo de autenticación?_

1. Los errores `5xx` corresponden a problemas en el servidor, como servidor sobrecargado o errores de implementación del servicio. Usa este `telnet` para hacer las siguientes peticiones:
   ```bash
   telnet httpbin.org 80
   ```
   ```http
   GET /delay/invalid HTTP/1.0

   ```

[^1]: [WebSocket](https://en.wikipedia.org/wiki/WebSocket) es otro protocolo de comunicación al nivel de HTTP pero que no sigue el modelo petición-respuesta y usa tramas binarias para intercambiar la información.

[^2]: En el esquema de autenticación básica el `usuario:password` se codifica en [Base64](https://en.wikipedia.org/wiki/Base64).