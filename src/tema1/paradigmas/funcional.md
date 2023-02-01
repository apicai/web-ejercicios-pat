# Paradigmas de programación
## Declarativa

Lo contrario de imperativa: no hay estado, no especifica los pasos ni su orden de ejecución, define el "qué" pero no el "cómo".

### Funcional

Los resultados se obtienen componiendo expresiones (funciones) las cuales pueden devolver otras expresiones o recibirlas como parámetros.

<details open><summary>Máximo valor en lista de enteros...</summary>

```js
const max = (integers) => integers.reduce(
  (accumulator, currentValue) => accumulator < currentValue ? currentValue : accumulator
);
console.log(max([1, 2, 3, 4, 5]));
```
> 🔍 **Nota:** _[documentación](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/Reduce) de `array.reduce`._
</details>

<details><summary>Prueba aquí...</summary>

<br/><iframe
  width="750"
  height="175"
  src="https://unpkg.com/javascript-playgrounds@1.2.3/public/index.html#data=%7B%22code%22%3A%22const%20max%20%3D%20(integers)%20%3D%3E%20integers.reduce(%5Cn%20%20(accumulator%2C%20currentValue)%20%3D%3E%20accumulator%20%3C%20currentValue%20%3F%20currentValue%20%3A%20accumulator%5Cn)%3B%5Cnconsole.log(max(%5B1%2C%202%2C%203%2C%204%2C%205%5D))%3B%22%7D"
></iframe>
</details>