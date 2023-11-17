# JavaScript
## Sintaxis

### Bucles

JavaScript tiene los típicos bucles `for` y `while` para iterar. El más usado es el primero:

```js
const array = []
for (let i = 0; i < 10; i++) {
  array.push(i);
}

console.log(array);
```

> **❓ Ejercicio 1:** _En la consola JavaScript modifica el `for` anterior para que se salga del bucle usando `break` cuando haya añadido el número 4._

> **❓ Ejercicio 2:** _Utilizando `continue` haz que el `for` anterior solo añada elementos a partir del número 5._