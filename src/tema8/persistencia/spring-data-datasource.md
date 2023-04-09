# Persistencia
## Spring data
### Datasource

Representa **la conexión** (URL, credenciales, etc.) a una base de datos específica usando su driver JDBC. A continuación, vamos a crear un proyecto Spring Data JPA y configurar su base de datos[^1].

1. [Genera el esqueleto](https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.0.5&packaging=jar&jvmVersion=17&groupId=edu.comillas.icai.gitt.pat.spring&artifactId=jpa&name=jpa&description=JPA&packageName=edu.comillas.icai.gitt.pat.spring.jpa&dependencies=web,data-jpa,h2) del proyecto y ábrelo en IntelliJ.

2. Añade la siguiente configuración al fichero de propiedades de la aplicación Spring Boot:
   ```properties
   spring.datasource.url=jdbc:h2:file:./dbdata
   spring.datasource.username=sa
   spring.h2.console.enabled=true
   spring.jpa.generate-ddl=true
   spring.sql.init.mode=always
   spring.sql.init.continue-on-error=true
   spring.jpa.defer-datasource-initialization=true
   ```

3. Arranca la aplicación Spring Boot, y conéctate a la [consola de administración de la BD](http://localhost:8080/h2-console) utilizando las propiedades del datasource anteriores.

[^1]: Normalmente, las bases de datos son procesos (servidores) independientes de las aplicaciones (clientes) que los usan. Para simplificar, utilizaremos una [BD embebida](http://www.h2database.com/html/main.html) en la propia aplicación: <details><summary><i class="fa fa-picture-o" aria-hidden="true"></i></summary><br><object type="image/svg+xml" data="./files/img/h2.excalidraw.svg" width="100%"></object></details>.
