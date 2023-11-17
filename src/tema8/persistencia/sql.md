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
CREATE TABLE CONTADOR (
  ID     INTEGER PRIMARY KEY,
  NOMBRE VARCHAR(200) NOT NULL UNIQUE,
  VALOR  INTEGER NOT NULL
);

CREATE TABLE USUARIO (
  ID    INTEGER PRIMARY KEY,
  EMAIL VARCHAR(256) NOT NULL UNIQUE,
  CREDENCIALES VARCHAR(20) NOT NULL
);

CREATE TABLE OPERACION (
  ID          INTEGER PRIMARY KEY,
  USUARIO_ID  INTEGER NOT NULL,
  CONTADOR_ID INTEGER NOT NULL,
  TIPO        VARCHAR(20) NOT NULL,
  FECHA       DATETIME NOT NULL,
  FOREIGN KEY (USUARIO_ID) 
          REFERENCES USUARIO(ID),
  FOREIGN KEY (CONTADOR_ID) 
          REFERENCES CONTADOR(ID)
);

-- Para añadir datos:
INSERT INTO USUARIO (ID, EMAIL, CREDENCIALES)
  VALUES (1, 'admin@e.m', 'YWRtaW5AZS5tOmFkbWlu');
INSERT INTO USUARIO (ID, EMAIL, CREDENCIALES)
  VALUES (2, 'boss@e.m', 'Ym9zc0BlLm06Ym9z');
INSERT INTO USUARIO (ID, EMAIL, CREDENCIALES)
  VALUES (3, 'user@e.m', 'dXNlckBlLm06dXNlcg==');
INSERT INTO USUARIO (ID, EMAIL, CREDENCIALES)
  VALUES (4, 'guest@e.m', 'dXNlckBlLm06dXNlcg==');
INSERT INTO USUARIO (ID, EMAIL, CREDENCIALES)
  VALUES (5, 'test@e.m', 'dXNlckBlLm06dXNlcg==');

INSERT INTO CONTADOR (ID, NOMBRE, VALOR)
  VALUES (1, 'visitas', 0);
INSERT INTO CONTADOR (ID, NOMBRE, VALOR)
  VALUES (2, 'clicks', 0);

INSERT INTO OPERACION (ID, USUARIO_ID, CONTADOR_ID, TIPO, FECHA)
  VALUES (1, 1, 1, 'creación', '2023-01-01 00:00:00');
INSERT INTO OPERACION (ID, USUARIO_ID, CONTADOR_ID, TIPO, FECHA)
  VALUES (2, 1, 2, 'creación', '2023-02-14 00:00:00');
INSERT INTO OPERACION (ID, USUARIO_ID, CONTADOR_ID, TIPO, FECHA)
  VALUES (3, 2, 2, 'incremento', '2023-03-11 00:00:00');

-- Para actualizar:
UPDATE CONTADOR 
  SET VALOR = VALOR + 1 
  WHERE NOMBRE = 'clicks';

-- Para consultar:
SELECT NOMBRE, VALOR FROM CONTADOR 
  WHERE NOMBRE = 'clicks';

-- Para borrar:
DELETE FROM USUARIO
  WHERE EMAIL = 'user@e.m';

</pre>

> **❓ Ejercicio 1:** _Explica qué devolvería la siguiente consulta SQL[^1]:_
> ```sql
> SELECT USUARIO.EMAIL, OPERACION.TIPO, CONTADOR.NOMBRE
> FROM USUARIO, OPERACION, CONTADOR
> WHERE USUARIO.ID = OPERACION.USUARIO_ID
> AND OPERACION.CONTADOR_ID = CONTADOR.ID
> ORDER BY USUARIO.ID;
> ```
> <details><summary><em>Diagrama...</em></summary><br>
> <object type="image/svg+xml" data="./files/img/select.excalidraw.svg" width="100%"></object>
> <em>Un <code>SELECT</code> con varias tablas se puede ver como una lista de correspondencias de la <a href="https://es.wikipedia.org/wiki/Correspondencia_matem%C3%A1tica">Teoría de Conjuntos</a>.</em>
> </details>
> <br>

> **❓ Ejercicio 2:** _Crea una consulta que devuelva la fecha de creación del contador 'visitas'._

> **❓ Ejercicio 3:** _Una aplicación que deje constancia de quien realiza cada operación ¿qué dos operaciones de BD tendría que realizar cuando alguien cree un contador? ¿En qué orden? En caso de que falle la última operación ¿qué habría que hacer para dejar los datos consistentes?_

> **❓ Ejercicio 4:** _Intenta borrar el contador 'visitas' y explica el resultado._


[^1]: Otro tipo de `SELECT` involucrando varias tablas, utiliza `JOIN` para añadir datos de otras tablas a los elementos de la tabla indicada en el `FROM`. Por ejemplo, la siguiente SQL lista todos los usuarios, hayan o no hecho operaciones (al contrario que la `SELECT` del ejercicio 1, que sólo puede mostrar los que tienen operaciones/correspondencias): <details><summary><i class="fa fa-picture-o" aria-hidden="true"></i></summary><br>
```sql
SELECT USUARIO.EMAIL, OPERACION.TIPO, CONTADOR.NOMBRE 
FROM USUARIO 
LEFT JOIN OPERACION ON USUARIO.ID = OPERACION.USUARIO_ID 
LEFT JOIN CONTADOR ON OPERACION.CONTADOR_ID = CONTADOR.ID
ORDER BY USUARIO.ID;
```
<object type="image/svg+xml" data="./files/img/join.excalidraw.svg" width="100%"></object>
</details>