# JavaScript
## Vulnerabilidades

### Validaciones

Las validaciones de campos introducidos por el usuario, implementadas con HTML y/o JavaScript, son sólo un mecanismo para mejorar la usabilidad. Para asegurar que los datos son correctos, también hay que validarlos en el lado servidor[^1] antes de usarlos.

> **❓ Ejercicio:** _El siguiente formulario simula una compra de entradas, que está limitada a 4 por persona. Encuentra la forma de saltarte esa validación usando el inspector del navegador._

<iframe src="./files/validaciones.html" width="100%" height="150" style="background:white;"></iframe>

[^1]: Y en caso de que sean incorrectos, el servidor suele devolver un [`400 Bad Request`](../../tema2/http/respuestas.html#4xx). Esto lo implementaremos cuando desarrollemos un API REST en el backend.