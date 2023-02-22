# JavaScript
## Sintaxis

### Excepciones

Para lanzar tus propios errores o excepciones se usa `throw`:

```js
const suma = function suma(a, b) {
  const resultado = a + b;
  if (!resultado) {
    throw 'Parámetros incorrectos';
  }
  return resultado;
}
```

> ⁉️ **Ejercicio:** _Copia y pega en la consola JavaScript el código anterior. Intenta provocar el error. Luego corrige el código para que cuando la suma sea 0, no dé error._

### Manejo de excepciones

Para controlar los posibles errores dentro de una sección de código se utiliza `try ... catch`:

```js
const jsonAobjeto = function jsonAobjeto(json) {
  try {
    return JSON.parse(json);
  } catch(error) {
    console.log('Se ha producido al convertir de JSON ➜ objeto JS:', error);
  }
}
```

> ⁉️ **Ejercicio:** _Copia y pega en la consola JavaScript el código anterior. Comprueba que valor se retorna en caso de error. Luego devuelve uno por defecto en caso de error._

