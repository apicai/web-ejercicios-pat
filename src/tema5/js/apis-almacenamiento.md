# JavaScript
## Web APIs

### Almacenamiento

Para guardar datos localmente (en el navegador del usuario) relacionados con una página web (dominio), se pueden usar las siguientes [APIs JavaScript](https://developer.mozilla.org/en-US/docs/Learn/JavaScript/Client-side_web_APIs/Client-side_storage):

- Cookies: cuyos datos también se envían al servidor[^1].
- Web Storage: datos clave-valor.
- IndexedDB: datos estructurados[^2].
- Cache: especializado para trabajar sin conexión[^3].

[^1]: Este era el procedimiento tradicional para guardar configuraciones o preferencias localmente, tuviera o no sentido que se enviaran al servidor.

[^2]: Similar a una base de datos real, con un API asíncrona, y mucho más compleja de usar que Web Storage.

[^3]: Para almacenar las peticiones y respuestas hechas con Fetch. Su [uso](https://developer.mozilla.org/en-US/docs/Web/API/Cache) también es complicado pues suele usar Service Workers.