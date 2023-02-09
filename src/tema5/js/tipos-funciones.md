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
const funcionSuma = function funcionSuma(param1, param2) {
  return () => param1 + param2;
}
const ejecutaConDemora = function ejecutaConDemora(funcion, demora) {
  const pintaDemoraYejecuta = () => console.log(`Ejecuto demorado ${demora / 1000}s:`, funcion());
  setTimeout(pintaDemoraYejecuta, demora);
};
ejecutaConDemora(funcionSuma(1, 2), 5000);
```

> ⁉️ **Ejercicio:** _Copia y pega el código anterior en la consola JavaScript. Familiarízate con su funcionamiento. Consulta también la documentación de [`setTimeout`](https://developer.mozilla.org/en-US/docs/Web/API/setTimeout). Ahora, sin modificar el código anterior, obtén la [fecha](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Date) actual y la fecha demorada 10s utilizando `ejecutaConDemora`._

[^1]: Esa sintaxis tiene más peculiaridades que puedes consultar en la web de [Mozilla](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Functions/Arrow_functions).



