# HTTP
## Cookies

Las cookies son datos creados en el servidor que se envían[^1] a los navegadores para que los almacenen y reenvíen[^1] en cada futura petición al mismo servidor (URL). Esos datos pueden contener información de acceso (autenticación), estado (carrito de la compra), configuración (tema L&F), rastreo (publicidad), etc.

1. Las cookies de sesión se borran cuando se cierra el navegador. Repite los **pasos 1, 2 y 3** de la página anterior, y usa esta respuesta:
   ```http
   HTTP/1.0 200 OK
   Set-Cookie: mi-cookie-de-sesion=valor
   Content-Length: 0

   ```
   Vuelve a repetir los **3 primeros pasos**, y comprueba que ahora el navegador envía la cookie en la petición. Comprueba si con cerrar la pestaña es suficiente o has de salir del navegador para que la cookie de sesión deje de enviarse.

   > ⁉️ **Pregunta:** _¿En qué casos utilizarías una cookie de sesión?_

1. Las cookies "permanentes" las deja de enviar el navegador en la fecha indicada por el servidor. Repite los pasos para enviar esta respuesta:
   ```http
   HTTP/1.0 200 OK
   Set-Cookie: mi-cookie-permanente=valor; Max-Age=60
   Content-Length: 0

   ```
   Comprueba que el navegador envía la cookie en su siguiente petición pero que, pasado 1 minuto, deja de enviarla.

   > ⁉️ **Pregunta:** _¿En qué casos utilizarías una cookie permanente?_

1. Además de la caducidad, una cookie puede tener otras características, muchas de ellas relacionadas con su seguridad[^2]<a name="httponly"></a>. Repite los **3 pasos iniciales** y envía esta respuesta:
   ```http
   HTTP/1.1 200 OK
   Set-Cookie: mi-cookie-en-otro-path=valor; Path=/ruta
   Set-Cookie: mi-cookie-segura=valor; Secure
   Set-Cookie: mi-cookie-solo-http=valor; HttpOnly
   Connection: keep-alive
   Content-Type: text/html
   Content-Length: 293

   <!DOCTYPE html><html><head></head><body><p>Cookies leídas por JS: <code></code></p><form action="/ruta"><input type="submit" value="Envía a /ruta"></form><script>document.getElementsByTagName("code")[0].textContent=document.cookie;document.cookie="mi-cookie-de-js=valor"</script></body></html>

   ```
   La página muestra las cookies que JavaScript (JS) es capaz de leer. Además, vía JS añadimos una cookie. El botón "Submit" enviará una nueva petición al servidor pero a otra ruta. Antes de enviar, vuelve a hacer el **paso 1** de la página anterior.

   > ⁉️ **Pregunta:** _¿Por qué JS no ve todas las cookies? ¿Cuándo se reenvía la cookie con `Path` al servidor? ¿Se reenvían al servidor las cookies creadas con JS?_

> ⚠️ **Importante**: _para o borra el [Codespace](https://github.com/codespaces) al terminar de usarlo._

[^1]: Como cabeceras HTTP de la respuesta o de la petición.

[^2]: El robo de las cookies de acceso es un problema típico en el mundo web.