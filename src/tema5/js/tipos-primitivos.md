# JavaScript
## Tipos

### Primitivos

Los tipos primitivos básicos son `boolean`, `number` y `string`.

```js
const booleano = true && !false || true;
const numero = 10 + 2 * 2 / 4 - 1;
const cadena = 'Cadena con \' (comilla simple escapada)';
const cadenaConVariables = `Núm:${numero}, Booleano:${booleano}, Cadena:'${cadena}'`;

// Comentario: ¡pinta por consola para depurar!
console.log(cadenaConVariables);
```

Abre la consola JavaScript del navegador (Botón derecho `➜` "Inspeccionar" `➜` "Consola"), realiza los siguientes ejercicios e intenta explicar los resultados.

> **❓ Ejercicio 1:** _Divide, separadamente, el número `10` por: el número `0`, la cadena `'2'` y la cadena `'a'`._

> **❓ Ejercicio 2:** _Suma a la cadena `'10'`, separadamente, el número `0`, la cadena `'1'` y el booleano `true`._

> **❓ Ejercicio 3:** _Utiliza uno de los métodos de [`String`](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String#instance_methods) para separar las palabras de esta cadena `'uno dos tres'`._