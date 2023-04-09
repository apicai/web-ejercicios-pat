# Persistencia
## JDBC y JPA

SQL se ha de ejecutar directamente en la BD. Para usarlo desde un programa es necesario enviarlo. 

[JDBC](https://es.wikipedia.org/wiki/Java_Database_Connectivity) permite a una **aplicación Java** comunicarse con una base de datos relacional mediante sentencias SQL. Cada proveedor de BD proporciona su implementación (o "driver") de JDBC[^1]. 

[JPA](https://en.wikipedia.org/wiki/Jakarta_Persistence) es una especificación para representar un modelo de datos relacional como objetos Java[^2]. Sus implementaciones[^3] evitan, en gran medida, la necesidad de escribir SQL directamente, que es generado internamente por ellas, y enviado a la BD utilizando JDBC.


[^1]: Dado que JDBC es un interfaz/contrato, una aplicación Java podría funcionar con diferentes BD relacionales (Oracle, PostgreSQL, etc.) con solo cambiar su "driver" JDBC. En la práctica, cada motor de BD usa un dialecto de SQL diferente que hace que sean necesarios cambios en el código de la aplicación.

[^2]: Esta técnica se llama [ORM](https://en.wikipedia.org/wiki/Object%E2%80%93relational_mapping), y es aplicable a todos los lenguajes de programación.

[^3]: [EclipseLink](https://en.wikipedia.org/wiki/EclipseLink) es la implementación de referencia, aunque la más popular es [Hibernate](https://hibernate.org/orm/).