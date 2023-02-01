# HTML
## Vulnerabilidades

"HTML injection" consiste en introducir código HTML malicioso en un formulario o parámetro de la URL que luego será utilizado como contenido en la propia web[^1]. El código malicioso puede consistir en añadir código JavaScript (usando los eventos de un elemento HTML o insertando una sección `<script>`) para robar las cookies de sesión. Otro uso malicioso, que no usa JavaScript, es inyectar un `iframe`, que simula la página de sesión caducada de una web legítima, para que la víctima introduzca nuevamente sus credenciales (que llegarán al servidor del atacante en el que está alojada).

A continuación vamos a demostrar la vulnerabilidad en una página que procesa el envío de un formulario[^2]:

<iframe src="./files/form-xss.html" width="100%" height="235" style="background:white;"></iframe>

1. Envía un comentario normal.
2. Envía este otro comentario `<img src='noexiste' onerror="alert('Enviando cookies...')">`.
3. Envía este otro `<iframe src="form-clickjacking.html" width="100%" height="175" style="background:white;" onload="this.scrollIntoView()"></iframe>`

> ⁉️ **Pregunta:** _¿Cómo piensas que se puede arreglar la vulnerabilidad?_

[^1]: Para que eso ocurra la aplicación web debe almacenar el contenido malicioso del atacante y/o servirlo a otros usuarios víctimas.

[^2]: El ejemplo usa una web estática que no es capaz de almacenar datos ni utiliza credenciales para su acceso, por lo que no se produce ningún riesgo. Un uso práctico de la vulnerabilidad requiere de una aplicación web real (bancos, foros, redes sociales, etc.).