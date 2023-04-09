# JavaScript
## Web APIs

### HTTP

Hasta ahora, las peticiones al servidor las hacía el navegador cuando el usuario pulsaba un enlace o enviaba un formulario, y como resultado se cargaba una nueva página.

Con las APIs de HTTP podemos hacer peticiones en segundo plano, iniciadas o no por el usuario, y sin que provoquen cargar otra página completa en el navegador. Esto permite actualizar partes concretas de la página actual modificando su DOM.

A esta forma de implementar webs[^1] se le llama [Ajax](https://developer.mozilla.org/en-US/docs/Web/Guide/AJAX), y utiliza las APIs `XMLHttpRequest` o `Fetch` para hacer las peticiones HTTP desde JavaScript[^2].

> 🔍 **Nota:** _Para ver este tipo de peticiones en el navegador: botón derecho `➜` "Inspeccionar" `➜` "Red" `➜` filtrar por XHR._

[^1]: Frameworks como [React](https://es.reactjs.org/) y [Angular](https://angular.io/), permiten crear aplicaciones web de una sola página (<abbr title="Single Page Application">SPA</abbr>), que están basadas en esta filosofía.

[^2]: Por defecto y por seguridad, los navegadores solo permiten hacer estas peticiones iniciadas por JS a URLs (dominio) de la página actual. [CORS](https://developer.mozilla.org/en-US/docs/Web/HTTP/CORS) permite hacer excepciones en determinados dominios a esta restricción.