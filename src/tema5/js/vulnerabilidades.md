# JavaScript
## Vulnerabilidades

Por seguridad, el código JavaScript de una página siempre se ejecuta aisladamente[^1] del resto de páginas que pueda tener abiertas el navegador del usuario[^2]. Sin embargo, si el código no está bien diseñado, otros usuarios o páginas maliciosas podrían saltarse la seguridad. A continuación, vemos algunas de las vulnerabilidades típicas de las aplicaciones web:

- Validar formularios sólo en el navegador.
- Cross-site scripting ([XSS](https://developer.mozilla.org/en-US/docs/Web/Security/Types_of_attacks#cross-site_scripting_xss)).
- Cross-site request forgery ([CSRF](https://developer.mozilla.org/en-US/docs/Web/Security/Types_of_attacks#cross-site_request_forgery_csrf)).

[^1]: Al entorno de ejecucion aislado se le suele llamar "sandbox".

[^2]: En el caso de una página embebida con un [`iframe`](../../tema3/html/multimedia-iframe.html), puede interaccionar con la página padre si ambas están en el mismo dominio.