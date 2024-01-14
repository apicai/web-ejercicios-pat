# JavaScript
## Web APIs

### <abbr title="Browser Object Model">BOM</abbr>

Es la interfaz con el que JavaScript interacciona con el navegador. Está compuesto por [varias APIs](https://developer.mozilla.org/en-US/docs/Web/API/Window). Estas son algunas de ellas que puedes probar en la consola JavaScript del navegador:

#### URL ventana actual

```js
location.reload(true);
location.href = 'https://developer.mozilla.org/en-US/docs/Web/API/Window/location';
```

#### Historial de navegación

```js
history.back();
history.forward();
```

#### Temporizadores

```js
const timeoutId = setTimeout(() => console.log('Salgo dentro de 2s'), 2000);
const intervalId = setInterval(() => console.log('Salgo cada 2s'), 2000);
```

> **❓ Ejercicio:** _El método `clearInterval(intervalId)` permite cancelar una ejecución a intervalos previamente programada. En la consola JavaScript del navegador, crea una que se ejecute cada 2 segundos y que se cancele a los 10s._

#### Otras APIs

<details><summary>Información del navegador</summary>

```js
console.log(navigator.userAgent);
```
</details>
<details><summary>Ventanitas emergentes</summary>

```js
const confirmResult = confirm('Si pulsas "Cancelar", retorno false. Si pulsas "Aceptar", retorno true.');
const promptResult = prompt('Retorno lo que tú teclees aquí');
alert('Solo muestro un aviso al usuario');
```
</details>

<details><summary>Tamaño y posición ventanas</summary>

```js
moveTo(0, 0);
resizeTo(screen.availWidth, screen.availHeight);
resizeBy(0, 50);
```
</details>

> 🔍 **Nota:** _Las APIs de ventanitas emergentes, y de tamaño y posición de ventanas, no conviene utilizarlas ya que son lo contrario a una buena experiencia de usuario. De hecho los navegadores impiden abusar de ellas ya que están asociadas a webs de publicidad intrusiva o maliciosa._
