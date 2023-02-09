# JavaScript
## Sintaxis

### Igualdad estricta

Comprueba el valor y el tipo:

```js
const array = ['a'];
console.log(1 === 1);
console.log('cadena' === 'cadena');
console.log(array === array);
console.log(array !== ['a']);
console.log('1' !== 1);
console.log(true !== 1);
console.log(false !== 0);
```

### Igualdad no estricta

Antes de comparar, convierte los tipos:

```js
const array = ['a'];
console.log('1' == 1);
console.log(true == 1);
console.log(false == 0);
console.log(array != ['a']);
```

> ⚠️ **Importante**: _Es mejor no usar la (des)igualdad no estricta, usar siempre la estricta: `===` y `!==`._

> ⁉️ **Ejercicio 1:** _En la consola JavaScript crea dos objetos con mismos campos en su interior. Comprueba si son iguales usando alguna de las dos igualdades._

> ⁉️ **Ejercicio 2:** _Compara los dos objetos pero conviértelos a una cadena con formato JSON previamente._
