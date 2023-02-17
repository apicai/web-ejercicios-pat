# JavaScript
## Tipos

### Funciones

Las funciones también son objetos que pueden incluirse como campos de otros objetos:

```js
const suma = function suma(param1, param2) {
    return param1 + param2;
};
const objetoConSuma = {campo: 'valor'};
objetoConSuma.suma = suma;

console.log(suma(1, 2));
console.log(objetoConSuma.suma("¡Hola ", "Mundo!"));
```

### Funciones flecha

Las funciones se pueden pasar como parámetros o devolverse como resultado de otra función. En esos casos se suele usar la sintaxis "flecha" que es más escueta[^1]:

```js
// Misma función que el ejemplo anterior:
const suma = (param1, param2) => param1 + param2;
// Aquí, creamos una función y la pasamos como 1er parámetro en una sola línea:
setTimeout(
  () => console.log('Resultado:', suma(1, 2)), 
  5000
);
```

> ⁉️ **Ejercicio:** _Utilizando [`setTimeout`](https://developer.mozilla.org/en-US/docs/Web/API/setTimeout), obtén la [fecha](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Date) fecha dentro de 5s._

[^1]: Esa sintaxis tiene más peculiaridades que puedes consultar en la web de [Mozilla](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Functions/Arrow_functions).



