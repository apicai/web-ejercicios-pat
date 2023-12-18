# Paradigmas de programación

## Imperativa

### Procedural

Los procedimientos (`function`) modifican los datos o el estado compartido.

<details open><summary>Máximo valor en lista de enteros...</summary>

```js
let m = Number.MIN_SAFE_INTEGER;
function max(integers) {
  for (let i = 0; i < integers.length; i++) {
    if (m < integers[i]) m = integers[i];
  }
}
function print() {
  console.log(m);
}
function printMax(integers) {
  max(integers);
  print();
}
printMax([1,2,3,4,5]);
```
</details>

<details><summary>Prueba aquí...</summary>

<br><iframe
  width="750"
  height="400"
  src="https://unpkg.com/javascript-playgrounds@1.2.3/public/index.html#data=%7B%22code%22%3A%22let%20m%20%3D%20Number.MIN_SAFE_INTEGER%3B%5Cnfunction%20max(integers)%20%7B%5Cn%20%20for%20(let%20i%20%3D%200%3B%20i%20%3C%20integers.length%3B%20i%2B%2B)%20%7B%5Cn%20%20%20%20if%20(m%20%3C%20integers%5Bi%5D)%20m%20%3D%20integers%5Bi%5D%3B%5Cn%20%20%7D%5Cn%7D%5Cnfunction%20print()%20%7B%5Cn%20%20console.log(m)%3B%5Cn%7D%5Cnfunction%20printMax(integers)%20%7B%5Cn%20%20max(integers)%3B%5Cn%20%20print()%3B%5Cn%7D%5CnprintMax(%5B1%2C2%2C3%2C4%2C5%5D)%3B%22%7D"
></iframe>
</details>
