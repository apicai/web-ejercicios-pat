# Paradigmas de programación
## Estructurada

Secuencia de órdenes con control de ejecución condicional (`if`, `else`) y repetitivo (`for`, `while`) que se pueden agrupar en subrutinas o bloques (`function`).

<details open><summary>Máximo valor en lista de enteros...</summary>

```js
function max(integers) {
  let m = Number.MIN_SAFE_INTEGER;
  for (let i = 0; i < integers.length; i++) {
    if (m < integers[i]) m = integers[i];
  }
  return m;
}
const integers = [1,2,3,4,5];
console.log(max(integers));
```
</details>

<details><summary>Prueba aquí...</summary>

<br/><iframe
  width="750"
  height="300"
  src="https://unpkg.com/javascript-playgrounds@1.2.3/public/index.html#data=%7B%22code%22%3A%22function%20max(integers)%20%7B%5Cn%20%20var%20m%20%3D%20Number.MIN_SAFE_INTEGER%3B%5Cn%20%20for%20(var%20i%20%3D%200%3B%20i%20%3C%20integers.length%3B%20i%2B%2B)%20%7B%5Cn%20%20%20%20if%20(m%20%3C%20integers%5Bi%5D)%20m%20%3D%20integers%5Bi%5D%3B%5Cn%20%20%7D%5Cn%20%20return%20m%3B%5Cn%7D%5Cnconst%20integers%20%3D%20%5B1%2C2%2C3%2C4%2C5%5D%3B%5Cnconsole.log(max(integers))%3B%22%7D"
></iframe>
</details>
