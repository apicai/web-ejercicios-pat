# Persistencia
## SQL

Es el [lenguaje](https://es.wikipedia.org/wiki/SQL) con el que se interactúa con la BD para: especificar el esquema del modelo de datos, manipular y consultar los datos, y controlar el acceso.

<script>
function populate() {
  const files = [{name: "db.sql"}];
  files.forEach(file => file.content = document.getElementById(file.name).textContent);
  document.getElementById('oc-editor').contentWindow.postMessage({
    eventType: 'populateCode', language: 'mysql', files: files
  }, "*");
}
</script>

<iframe id="oc-editor" frameBorder="0" height="450px" width="100%" onload="populate()" src="https://onecompiler.com/embed/mysql?hideLanguageSelection=true&hideNew=true&hideNewFileOption=true&hideTitle=true&hideStdin=true&listenToEvents=true"></iframe>

<pre id="db.sql" hidden>-- Esquema de base de datos:
CREATE TABLE contador (
  id     INTEGER PRIMARY KEY,
  nombre VARCHAR(200) NOT NULL UNIQUE,
  valor  INTEGER NOT NULL
);

CREATE TABLE usuario (
  id    INTEGER PRIMARY KEY,
  email VARCHAR(256) NOT NULL UNIQUE,
  credenciales VARCHAR(20) NOT NULL
);

CREATE TABLE operacion (
  id         INTEGER PRIMARY KEY,
  usuarioId  INTEGER NOT NULL,
  contadorId INTEGER NOT NULL,
  tipo       VARCHAR(20) NOT NULL,
  fecha      DATETIME NOT NULL,
  FOREIGN KEY (usuarioId) 
          REFERENCES usuario(id),
  FOREIGN KEY (contadorId) 
          REFERENCES contador(id)
);

-- Para añadir datos:
INSERT INTO contador 
  VALUES (1, 'visitas', 1);
INSERT INTO contador 
  VALUES (2, 'clicks', 0);

INSERT INTO usuario 
  VALUES (1, 'admin@e.m', 'YWRtaW5AZS5tOmFkbWlu');
INSERT INTO usuario 
  VALUES (2, 'boss@e.m', 'Ym9zc0BlLm06Ym9z');
INSERT INTO usuario 
  VALUES (3, 'user@e.m', 'dXNlckBlLm06dXNlcg==');

INSERT INTO operacion 
  VALUES (1, 1, 1, 'creación', '2023-01-01 00:00:00');
INSERT INTO operacion 
  VALUES (2, 2, 2, 'incremento', '2023-02-14 00:00:00');
INSERT INTO operacion 
  VALUES (3, 1, 1, 'incremento', '2023-03-11 00:00:00');

-- Para actualizar:
UPDATE contador 
  SET valor = valor + 1 
  WHERE nombre = 'visitas';

-- Para consultar:
SELECT nombre, valor FROM contador 
  WHERE nombre = 'visitas';

-- Para borrar:
DELETE FROM usuario
  WHERE email = 'user@e.m';

</pre>

> ⁉️ **Ejercicio 1:** _Explica qué devolvería la siguiente consulta SQL:_
> ```sql
> SELECT usuario.email 
>   FROM usuario, operacion, contador
>   WHERE usuario.id = operacion.usuarioId
>   AND operacion.tipo = 'creación'
>   AND operacion.contadorId = contador.id
>   AND contador.nombre = 'visitas';
> ```

> ⁉️ **Ejercicio 2:** _Crea una consulta que devuelva la fecha de creación del contador 'visitas'._

> ⁉️ **Ejercicio 3:** _Una aplicación que deje constancia de quien realiza cada operación ¿qué dos operaciones de BD tendría que realizar cuando alguien cree un contador? ¿En qué orden? En caso de que falle la última operación ¿qué habría que hacer para dejar los datos consistentes?_

> ⁉️ **Ejercicio 4:** _Intenta borrar el contador 'visitas' y explica el resultado._