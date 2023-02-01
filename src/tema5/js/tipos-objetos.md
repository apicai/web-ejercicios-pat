# JavaScript
## Tipos

### Objetos

En JavaScript, todo lo que no es primitivo es de tipo `Object`. El tipo `Object` básico es como un mapa o diccionario.

```js
const objeto = {
  campoNumero: 1.5,
  campoBooleano: false,
  campoObjeto: {
    campoCadena: 'Cadena',
    campoArray: [],
    otroObjeto: {}
  }
};
objeto.campoNumero += 2.5;

console.log('Campo modificado:', objeto['campoNumero']);
console.log('Campo anidado:', objeto.campoObjeto.campoCadena);
```

Abre la consola JavaScript del navegador (Botón derecho `➜` Inspeccionar `➜` Consola), realiza los siguientes ejercicios e intenta explicar los resultados.

> ⁉️ **Ejercicio 1:** _Copia y pega el código anterior en la consola. Intenta leer el campo `campoObjeto.otroObjeto.noExisto`. Luego intenta leer este otro `campoObjeto.otroObjeto.noExisto.tampocoExisto`._

> ⁉️ **Ejercicio 2:** _Asigna al `campoObjeto.otroObjeto` otro objeto creado así: `const objeto2 = {campo: 1}`. Luego cambia el valor del campo del `objeto2` y observa qué ocurre con el contenido del primer objeto._

> ⁉️ **Ejercicio 3:** _Utilizando los métodos del objeto [`JSON`](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/JSON#static_methods) de JavaScript:_
> 1. _Convierte el `objeto` en una cadena con formato JSON y asígnala a una constante `const json`._
> 1. _Convierte la constante `json` en un objeto y asígnalo a la constante `const objeto3`._
> 1. _Repite el cambio de valor en el `objeto2` y pinta el contenido de los 3 objetos creados._