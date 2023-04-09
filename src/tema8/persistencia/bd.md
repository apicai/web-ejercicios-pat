# Persistencia
## Bases de datos

Dependiendo de la naturaleza de los datos y su aplicación, se utilizan diferentes tipos de bases de datos. Los dos principales son las relacionales y NoSQL.

| | Relacionales | NoSQL |
|-|--------------|-------|
| **Datos** | Para guardar la información estructuradamente en tablas, filas y columnas predefinidas. | Permiten guardar datos heterogéneos sin una estructura fija predeterminada. |
| **Reglas** | Permiten establecer restricciones y relaciones entre sus datos. | No se definen relaciones o restricciones en sus datos. |
| [**Transacciones**](spring-data-transacciones.md) | Aseguran la integridad de sus datos durante las transacciones. | No aseguran totalmente la integridad. A cambio, son capaces de manejar grandes volúmenes de datos. |
| **Lenguaje** | Utilizan [SQL](sql.md) para gestionar sus datos. | Cada proveedor define su propio lenguaje para interactuar con sus datos. |
| **Ejemplos** | Oracle, PostgreSQL, MySQL, SQL Server. | MongoDB, Elasticsearch[^1], Redis[^2], Prometheus[^3], Neo4J[^4].

[^1]: Optimizada para búsquedas de texto en sus contenidos.

[^2]: Base de datos de clave-valor, suelen usarse como cachés distribuidas guardando datos que previamente fueron costosos de recuperar de otras fuentes.

[^3]: Especializadas en guardar datos conteniendo una marca de tiempo, permiten analizar y visualizar el comportamiento con el tiempo de servidores, sensores, precios, clima, etc.

[^4]: Basada en grafos que representan relaciones entre entidades, para generar recomendaciones, optimizar flujos, detectar patrones o anomalías, etc.