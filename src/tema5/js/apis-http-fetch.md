# JavaScript
## Web APIs

### HTTP

#### Fetch

[Fetch](https://developer.mozilla.org/en-US/docs/Web/API/fetch) es la versión moderna de XHR. Utiliza [promesas](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Promise) para manejar las respuestas asíncronas de un modo que es más fácil seguir y codificar su tratamiento[^1]. Para simplificar su sintaxis, se utilizan las palabras reservadas:

- `await`, para esperar a que la operación asíncrona termine (la promesa), y
- `async`, para marcar aquellas funciones que en su interior tienen operaciones asíncronas (tienen `await` y/o retornan promesas).

```js
const peticion = async function(url, config) {
  const respuesta = await fetch(url, config);
  return await respuesta.json();
}
const usaRespuesta = async function() {
  try {
    const objeto = await peticion('URL', {
      method: 'POST',
      mode: 'cors',
      headers: { 'Cabecera': 'valor' },
      body: 'cuerpo petición',
    });
    console.log('Respuesta:', objeto);
  } catch (error) {
    console.error('Error:', error);
  }
}
usaRespuesta();
```

> **❓ Ejercicio:** _Modifica el ejercicio anterior que usa XHR para que en su lugar utilice `fetch` usando:._
> <details><summary><em>Async y await</em></summary>
> 
> ```js
> try {
>   const respuesta = await fetch(...);
>   if (respuesta.ok) {
>     const objeto = await respuesta.json();
>     ...
>   } else {
>     ...
>   }
> } catch(error) {
>   ...
> }
> ```
> </details>
> <details><summary><em>Promises</em></summary>
> 
> ```js
> fetch(...)
>   .then(response => {
>     if (response.ok) {
>       return response.json();
>     } else {
>       throw new Error(`Respuesta con error ${response.status}`);
>     }
>   })
>   .then(objeto => {
>     ...
>   })
>   .catch(error => {
>     ...
>   });
> ```
> </details>
> <br>

[^1]: Por ejemplo, en XHR, una vez enviamos la petición con `xhr.send()`, no es evidente por donde continúa la lógica que trata su respuesta. Esto es por que hay una función que escucha configurada en alguna parte (en el evento `onload`, por ejemplo). Si, a continuación, quisiéramos lanzar otra petición asíncrona que utiliza datos de la respuesta anterior, tendríamos que anidar otra función que escucha dentro de la función de escucha inicial... y esto se vuelve un [infierno...](https://stackoverflow.com/questions/25098066/what-is-callback-hell-and-how-and-why-does-rx-solve-it).