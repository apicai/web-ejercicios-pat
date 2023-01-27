# HTTP
## Peticiones

La petición HTTP más sencilla se compone de `{MÉTODO} /{recurso} HTTP/{version}\r\n\r\n`. El método[^1] indica la acción a realizar y el recurso[^2] indica la entidad sobre la que realizar la acción. Adicionalmente, se pueden incluir cabeceras y un cuerpo para enviar datos.

1. `GET` permite recuperar el recurso de la ruta indicada. Usa este `telnet` para enviar la siguente petición:
   ```bash
   telnet httpbin.org 80
   ```
   ```http
   GET /anything?param1=?&#=&param2=value2 HTTP/1.0

   ```
   > ⁉️ **Pregunta:** _¿Qué problema puede causar el valor del primer parámetro? ¿qué ocurre cuando mandas `GET /anything?param1=%3F%26%23%3D&param2=value2 HTTP/1.0`?_

   > 🔍 **Nota:** _[httpbin.org](https://httpbin.org) es un servicio para jugar con diversas funcionalidades de HTTP. La petición a `/anything`, por ejemplo, nos responde con lo que le ha llegado en la petición._

1.  `POST` permite enviar datos al servidor. Vuelve a hacer el **paso 1** con este otro contenido:
    ```http
    POST /anything HTTP/1.0
    Content-Length: 5

    12345

    ```
    > ⁉️ **Pregunta:** _¿Qué ocurre si indicamos un tamaño del contenido inferior a lo que realmente mandamos?_

1. Si no sabemos el tamaño de los datos que queremos mandar, se puede enviar la información por partes de tamaño conocido[^3]. Prueba esta otra petición:
   ```http
   POST /anything HTTP/1.0
   Transfer-Encoding: chunked

   9
   una parte
   A
   otra parte
   0

   ```

1. Cuando mandamos datos, normalmente también se indica qué tipo de datos son (texto, imagen, binario,etc.)[^4]. Existe la posibilidad de mandar en la misma petición varios datos de diferente tipo. Para ello se usan envíos "multipart". 
   1. Entra en [Httpie](https://httpie.io/app).
   2. Envía un `POST` multipart a `https://httpbin.org/anything`.
   3. Previsualiza la petición enviada.
   > ⁉️ **Pregunta:** _¿En qué caso de uso real puede ser útil "multipart"? ¿y "chunked"?_
   
   > 🔍 **Nota:** _Aparte de los navegadores web y sus herramientas para desarrolladores, existen muchas aplicaciones para hacer peticiones HTTP. La más popular es [Postman](https://www.postman.com/), aunque hay muchas más con interfaz gráfica. También hay clientes por línea de comandos como [Curl](https://curl.se/) y [Wget](https://en.wikipedia.org/wiki/Wget). [Httpie](https://httpie.io/) tiene versión gráfica y por línea de comandos._

1. Hasta ahora, hemos usado HTTP 1.0 y 1.1. HTTP 2 y 3 son protocolos binarios y HTTP/3 no usa TCP por lo que no podemos probarlo con `telnet`. Además, no todos los clientes y servidores los implementan por lo que para usarlos se necesita negociar el protocolo previamente mediante HTTP o TLS. Ejecuta los siguientes comandos:
   ```bash
   # Negociación vía HTTP/1.1:
   curl http://httpbin.org/anything -d "12345" -v --http2
   # Negociación vía TLS/ALPN:
   curl https://httpbin.org/anything -d "12345" -v --http2
   ```

[^1]: Los métodos o verbos están definidos en la [especificación](https://httpwg.org/specs/rfc9110.html#methods). Los más comunes son `GET` y `POST`.

[^2]: La ruta al recurso se puede componer de `/path?query#fragment`, y la `query` a su vez se compone de `param1=value1&param2=value2&...`. Los parámetros de la "query" deben codificarse usando [URL encoding](https://en.wikipedia.org/wiki/URL_encoding).

[^3]: Cada "chunk" se envía indicando primero su longitud en hexadecimal y después su contenido en una nueva línea. Para finalizar se envía un "chunk" vacío: `0\r\n\r\n`.

[^4]: `Content-Type` es la cabecera que indica el tipo de datos que se envían. Se utilizan [MIME types](https://developer.mozilla.org/en-US/docs/Web/HTTP/Basics_of_HTTP/MIME_types#important_mime_types_for_web_developers) para identificarlos. Además, puede venir acompañada de la codificación de caracteres utilizada en los datos. Por ejemplo, para las peticiones que hemos hecho usaríamos `Content-Type: text/plain; charset=utf-8`.