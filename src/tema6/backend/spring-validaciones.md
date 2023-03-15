# Backend

## Spring

### Validaciones

Para validar que los campos proporcionados son correctos también se utilizan [anotaciones](https://docs.oracle.com/javaee/7/tutorial/bean-validation001.htm). Para que estén disponibles es necesario incluir una librería que las implemente. La de referencia es [Hibernate Validator](https://hibernate.org/validator/).

> ⁉️ **Ejercicio:** _Añade a la lista de dependencias del proyecto MVC la siguiente, y haz que el IDE la descargue._
> ```xml
>	<dependency>
>	  <groupId>org.springframework.boot</groupId>
>	  <artifactId>spring-boot-starter-validation</artifactId>
>	</dependency>
> ```

