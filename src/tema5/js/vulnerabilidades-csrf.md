# JavaScript
## Vulnerabilidades

### <abbr title="Cross Side Request Forgery">CSRF</abbr>

Esta vulnerabilidad explota las posibles [cookies](../../tema2/http/cookies.html) de sesión que tiene abiertas la víctima. El atacante crea cuidadosamente un enlace o formulario para que apunte a una URL que realiza una operación en la web vulnerable. Esa operación será automáticamente autorizada gracias a la presencia de la cookie de sesión de dicha web.

Un ejemplo básico sería incluir esto en un correo electrónico o en una web maliciosa:
```html
<a href='https://banco.com/retirar?cantidad=1000&destino=cuenta-del-atacante'>
  Pulsa aquí para ver tu regalo
</a>
```
<details><summary>Diagrama CSRF</summary><br>
<object type="image/svg+xml" data="./files/csrf.excalidraw.svg" width="100%"></object>
</details>

Para prevenir el CSRF:
1. Añadir un paso de confirmación del usuario para evitar la autorización automática.
1. Utilizar cookies con [`SameSite`](https://developer.mozilla.org/en-US/docs/Web/HTTP/Cookies#samesite_attribute) igual a `Strict` para que no se envíen cuando se hacen peticiones desde un dominio diferente al que pertenecen.
1. Programáticamente incluir un token y/o cabecera HTTP especial en las peticiones legítimas, que el servidor validará para autorizar la operación<a name="token"></a>. Al contrario que las cookies, éstos tokens/cabeceras no se envían automáticamente, y el atacante no dispone de sus valores para incluirlos en su petición.