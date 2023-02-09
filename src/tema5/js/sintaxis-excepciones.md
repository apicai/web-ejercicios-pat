# JavaScript
## Sintaxis

### Excepciones

Para lanzar tus propios errores o excepciones se usa `throw`:

```js
const suma = function suma(a, b) {
  const resultado = a + b;
  if (!resultado && resultado !== 0) {
    throw 'Parámetros incorrectos';
  }
  return resultado;
}
```

### Manejo de excepciones

Para controlar los posibles errores dentro de una sección de código se utiliza `try ... catch`:

```js
const jsonAobjecto = function jsonAobjecto(json) {
  try {
    return JSON.parse(json);
  } catch(error) {
    console.log('Se ha producido al convertir de JSON ➜ objeto JS:', error);
  }
}
```

> ⁉️ **Ejercicio:** _Copia y pega en la consola JavaScript el código anterior. Modifica el código para que usando `finally` se retorne el valor `{}` en caso de error._

