# Paradigmas de programación

## Imperativa

### Orientada a objetos

El problema se modela como objetos que encapsulan la lógica y la parte del estado que controlan.

<details open><summary>Máximo valor en lista de enteros...</summary>

```js
class MaxFinder {
  constructor(values) { this.values = values; }
  find() { throw Error("Not implemented"); }
}
class MaxInteger extends MaxFinder {
  constructor(values) { super(values); }
  find() {
    let m = Number.MIN_SAFE_INTEGER;
    for (let i = 0; i < this.values.length; i++) {
      if (m < this.values[i]) m = this.values[i];
    }
    return m;
  }
}
const maxFinder = new MaxInteger([1,2,3,4,5]);
console.log(maxFinder.find());
```
</details>

<details><summary>Prueba aquí...</summary>

<br><iframe
  width="750"
  height="425"
  src="https://unpkg.com/javascript-playgrounds@1.2.3/public/index.html#data=%7B%22code%22%3A%22class%20MaxFinder%20%7B%5Cn%20%20constructor(values)%20%7B%20this.values%20%3D%20values%3B%20%7D%5Cn%20%20find()%20%7B%20throw%20Error(%5C%22Not%20implemented%5C%22)%3B%20%7D%5Cn%7D%5Cnclass%20MaxInteger%20extends%20MaxFinder%20%7B%5Cn%20%20constructor(values)%20%7B%20super(values)%3B%20%7D%5Cn%20%20find()%20%7B%5Cn%20%20%20%20var%20m%20%3D%20Number.MIN_SAFE_INTEGER%3B%5Cn%20%20%20%20for%20(var%20i%20%3D%200%3B%20i%20%3C%20this.values.length%3B%20i%2B%2B)%20%7B%5Cn%20%20%20%20%20%20if%20(m%20%3C%20this.values%5Bi%5D)%20m%20%3D%20this.values%5Bi%5D%3B%5Cn%20%20%20%20%7D%5Cn%20%20%20%20return%20m%3B%5Cn%20%20%7D%5Cn%7D%5Cnconst%20maxFinder%20%3D%20new%20MaxInteger(%5B1%2C2%2C3%2C4%2C5%5D)%3B%5Cnconsole.log(maxFinder.find())%3B%22%7D"></iframe>
</details>
