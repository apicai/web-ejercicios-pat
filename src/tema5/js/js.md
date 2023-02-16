# JavaScript

Es el lenguaje de programación nativo de los navegadores web[^1]. Es [multi-paradigma](../../tema1/paradigmas/paradigmas.html), interpretado, ejecutado en un solo hilo y basado en eventos[^2]. ECMAScript es su especificación que está en permanente evolución[^3].

## Objetivos

- Aprender la sintaxis del lenguaje mediante ejemplos.

- Ser capaz de dar comportamiento al HTML para interactuar con el usuario.

- Realizar peticiones al servidor en segundo plano sin necesidad de recargar la página.

- Conocer las vulnerabilidades típicas de las aplicaciones web.

[^1]: También se usa como lenguaje de lado servidor con [NodeJS](https://nodejs.org/en/).

[^2]: Este modelo de ejecución está implementado con un [bucle de eventos](https://developer.mozilla.org/en-US/docs/Web/JavaScript/EventLoop). En el siguiente diagrama se muestra un ejemplo de ejecución del evento "click" y su "operación" asociada: <details><summary><i class="fa fa-picture-o" aria-hidden="true"></i></summary><br><object type="image/svg+xml" data="./files/event-loop.excalidraw.svg" width="50%"></object></details>

[^3]: Como consecuencia no todos los navegadores soportan las nuevas características. De ahí que existan herramientas como [Babel](https://babeljs.io/docs/en/index.html) que convierten el código para que sea compatible con los navegadores más usados.