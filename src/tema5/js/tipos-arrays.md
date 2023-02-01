# JavaScript
## Tipos

### Arrays

Los arrays son también objetos y pueden contener tipos primitivos y objetos mezclados en su interior:

```js
const array = [1.2, true, {campo: 'a'}, [1, 2]];
array[0] = '1er elemento modificado';
array.push('elemento nuevo añadido al final');

console.log('Longitud del array:', array.length);
```

Abre la consola JavaScript del navegador (Botón derecho `➜` Inspeccionar `➜` Consola), realiza los siguientes ejercicios e intenta explicar los resultados.

> ⁉️ **Ejercicio 1:** _Copia y pega el código anterior en la consola. Intenta leer la posición 10 del array. Asigna un valor a dicha posición, y mira de nuevo la longitud del array._

> ⁉️ **Ejercicio 2:** _Utilizando los métodos del objeto [`Array`](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array#instance_methods) quita el último elemento del array, añade un nuevo elemento al principio, y quita ese elemento a continuación._
