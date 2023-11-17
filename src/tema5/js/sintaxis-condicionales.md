# JavaScript
## Sintaxis

### Condicionales

```js
const condicion1 = false;
const condicion2 = true;
if (condicion1 && condicion2) {
  console.log('Entro por if');
} else if (condicion1 || !condicion2) {
  console.log('Entro por else if');
} else {
  console.log('Entro por else');
}
```

### Condicional en una línea

```js
const condicion = true;
const resultado = condicion ? 1 : 2;
```

> **❓ Ejercicio 1:** _En la consola JavaScript convierte la anterior línea en un `if ... else ...`._

> **❓ Ejercicio 2:** _Utiliza los siguientes valores como condición y observa el resultado: `0`, `''`, `undefined`, `null`, `NaN`, `1`, `'a'`, `[]`, `{}`._
