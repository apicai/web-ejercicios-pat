# HTTP
## Servidor

En una comunicación HTTP, los servidores permanecen a la escucha de peticiones en un puerto concreto. A continuación, vamos a usar [netcat](https://en.wikipedia.org/wiki/Netcat) para abrir un puerto TCP y simular respuestas HTTP.

1. Desde el terminal ejecuta:
   ```bash
   nc -l -s 0.0.0.0 -p 8080
   ```

1. En un navegador web abre o refresca [`http://localhost:8080`](http://localhost:8080) si estás usando **Docker**. En caso de usar **Codespaces** utiliza la URL que se indica al ejecutar el comando anterior en el terminal.

1. Vuelve al terminal y comprueba que ha llegado la petición.

1. En el terminal pega esta respuesta:
   ```http
   HTTP/1.0 200 OK
   Content-Type: text/plain
   Content-Length: 9

   Respuesta
   ```
   > ⁉️ **Pregunta:** _Para que netcat se dé cuenta de que la conexión la cerró el navegador, pulsa <kbd>↲</kbd> varias veces. ¿Por qué se cerró la conexión?_

1. Vamos a simular una descarga. Repite los **pasos anteriores** pero en el último usa esta otra respuesta:
   ```http
   HTTP/1.0 200 OK
   Content-Type: text/plain
   Content-Length: 9
   Content-Disposition: attachment; filename="respuesta.txt"

   Respuesta
   ```

1. Vamos a simular una redirección. Vuelve a repetir los **pasos 1, 2 y 3**, y usa esta otra respuesta:
   ```http
   HTTP/1.0 302 Found
   Content-Length: 0
   Location: https://www.google.com/search?q=browser+cache+301+redirect

   ```
   > ⁉️ **Pregunta:** _¿Qué pasaría si hubiéramos devuelto una redirección `301` permanente? Consejo: ¡no lo pruebes!_

1. Vamos a simular una autenticación básica. Repite los **pasos 1, 2 y 3**, y usa esta otra respuesta:
   ```http
   HTTP/1.1 401 UNAUTHORIZED
   Content-Length: 0
   WWW-Authenticate: Basic realm="Mi servidor netcat"

   ```
   Completa en el navegador los campos para introducir el usuario y password, y dale a enviar. Vuelve al terminal y observa como te llega el usuario y password. Para terminar, pega la respuesta del **paso 4**.

   > ⁉️ **Pregunta:** _¿Podrías conocer el password de un usuario de tu servidor con este tipo de autenticación?_

1. Vamos a ver cómo el navegador manda los datos de un formulario web. Repite el **paso 1**, rellena el formulario siguiente y envíalo. Si usas Codespaces, sustituye `http://localhost:8080` en el HTML por la URL proporcionada en el entorno.
    <details onclick='setTimeout(function(){__CPEmbed(".cp-later")},1)'><summary>Formulario...</summary><br>
    <div class="cp-later" data-height="370" data-theme-id="light" data-default-tab="html,result" data-editable="true" data-prefill style="opacity:0">
    <pre data-lang="html">&lt;form id="myForm" action="http://localhost:8080" method="post">
    &lt;fieldset>
        &lt;label for="name">Text Input:&lt;/label>
        &lt;input type="text" name="name" id="name" value="" tabindex="1" placeholder="Placeholder">
    &lt;/fieldset>
    &lt;fieldset>
        &lt;label for="radio-choice-1">Choice 1&lt;/label>
        &lt;input type="radio" name="radio-choice-1" id="radio-choice-1" tabindex="2" value="choice-1">
        &lt;label for="radio-choice-2">Choice 2&lt;/label>
        &lt;input type="radio" name="radio-choice-2" id="radio-choice-2" tabindex="3" value="choice-2">
    &lt;/fieldset>
    &lt;fieldset>
        &lt;label for="select-choice">Select Dropdown Choice:&lt;/label>
        &lt;select name="select-choice" id="select-choice">
        &lt;option value="Choice 1">Choice 1&lt;/option>
        &lt;option value="Choice 2">Choice 2&lt;/option>
        &lt;option value="Choice 3">Choice 3&lt;/option>
        &lt;/select>
    &lt;/fieldset>
    &lt;fieldset>
        &lt;label for="textarea">Textarea:&lt;/label>
        &lt;textarea rows="2" cols="25" name="textarea" id="textarea" placeholder="Placeholder">&lt;/textarea>
    &lt;/fieldset>
    &lt;fieldset>
        &lt;label for="checkbox">Checkbox:&lt;/label>
        &lt;input type="checkbox" name="checkbox">
    &lt;/fieldset>
    &lt;fieldset>
        &lt;input type="submit" value="Submit">
    &lt;/fieldset>
    &lt;/form>
    </pre>
    </div>
    </details>

   Edita el HTML y quita el `method="post"`. Repite el **paso 1** y envía el formulario con ese cambio.

   > ⁉️ **Pregunta:** _¿Cuál es el método por defecto de un formulario web? Si envias "Ñ" en algún campo ¿en qué codificación llega al servidor?_