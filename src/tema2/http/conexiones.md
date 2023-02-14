# HTTP
## Conexiones

En una comunicación HTTP, los clientes siempre crean la conexión. A continuación, vamos a usar [telnet](https://en.wikipedia.org/wiki/Telnet) para crear una conexión TCP y simular una comunicación HTTP.

1. Desde el terminal teclea:
   ```bash
   telnet httpbin.org 80
   ```
   y cuando se conecte pega este contenido (las **2** líneas)[^1]:
   ```http
   HEAD /html HTTP/1.0

   ```
   > ⁉️ **Pregunta:** _Para establecer la conexión y teniendo en cuenta los parámetros que le hemos pasado a `telnet`, ¿qué ha tenido éste que hacer por nosotros?_

1. El servidor contesta con un `OK` y unas cabeceras de respuesta sin cuerpo. Vuelve a hacer el **paso 1** pero esta vez pon `HTTP/1.1`.

1. La respuesta esta vez es `Bad Request` porque esta versión obliga a enviar la cabecera `Host`[^2]. Repite el **paso 1** con esta petición:
   ```http
   HEAD /html HTTP/1.1
   Host: httpbin.org

   ```
   El servidor responde `OK` pero ahora el comando `telnet` no termina, continúa conectado. En HTTP 1.0 la conexión la cierra el servidor inmediatamente tras enviar la respuesta (ver `Connection: close` de esa respuesta), mientras que en HTTP 1.1 se mantiene abierta (ver `Connection: keep-alive` de esa respuesta) a la espera de nuevas peticiones. 
   
   > 🔍 **Nota:** _Si esperamos unos segundos más, el comando `telnet` termina porque la conexión la cierra el servidor. Por un lado, las conexiones TCP son costosas de establecer por lo que interesa mantenerlas abiertas si seguidamente se va a hacer otra petición. Pero por otro lado, mantener una conexión consume recursos del servidor que no puede malgastar con un cliente que no envía datos._

1. Para saber cuál es el timeout por defecto del servidor, espera a que acabe este comando:
   ```bash
   time telnet httpbin.org 80
   ```
   > ⁉️ **Pregunta:** _Aparte del timeout de lectura y del lado servidor, ¿qué otros tipos de timeout se te ocurren y cuál sería su utilidad?_

1. Hasta ahora hemos usado el puerto TCP 80 que es el de por defecto para conexiones HTTP. El puerto por defecto para conexiones seguras es 443. Repite el **paso 1** usando ese puerto.

1. El servidor nos responde con error porque espera que enviemos los mensajes de negociación de TLS para cifrar la comunicación antes de enviar nada. Repite el **paso 1** usando `openssl` en lugar de `telnet`[^3]:
   ```bash
   openssl s_client -state -connect httpbin.org:443
   ```
   > ⁉️ **Pregunta:** `openssl` _se encarga de cifrar y descifrar los mensajes que enviamos y recibimos con la clave de cifrado intercambiada[^4]. Esta forma de funcionar, ¿a qué arquitectura se asemeja?_

[^1]: La línea en blanco (en realidad **dos** retorno de carro + nueva línea o `CRLF` o `\r\n`) indica el fin del mensaje de la petición, y en ese momento el servidor envía el mensaje de respuesta.

[^2]: Es necesaria para que una misma IP pueda servir diferentes dominios web.

[^3]: TLS es bastante más complicado que HTTP y no podemos escribir sus mensajes con `telnet`.

[^4]: Al comienzo de la salida del comando `openssl` se pueden ver los mensajes TLS intercambiados entre cliente y servidor negociando el cifrado.