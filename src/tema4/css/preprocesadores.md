# CSS
## Pre-procesadores

Una web puede tener muchos estilos, que deberán ser consistentes cuando cambien. Para facilitar su mantenimiento, se han creado herramientas que permiten escribir las reglas de forma más modular o programática. La más usada es [Sass](https://sass-lang.com/) que utiliza la sintaxis SCSS (`.scss`) para extender el lenguaje CSS. Los navegadores solo entienden CSS, por lo que para usar estas extensiones es necesario pre-procesar (o compilar) sus ficheros y convertirlos a CSS antes de desplegar la web[^1].

Algunas de las características de Sass son **similares** a otras de CSS:

<details><summary>Variables SCSS</summary>

```scss
/* SCSS */
$fuente-principal: Helvetica, sans-serif;
p { font: 100% $fuente-principal; }
```
</details>
<details><summary>Variables CSS</summary>

```css
/* CSS */
html { --fuente-principal: Helvetica, sans-serif; }
p { font: 100% var(--fuente-principal); }
```
</details>

<details><summary>Selector de hijos SCSS</summary>

```scss
/* SCSS */
nav {
  li { display: inline-block; }
}
```
</details>
<details><summary>Selector de hijos CSS</summary>

```css
/* CSS */
nav li { display: inline-block; }
```
</details>

<details><summary>Módulos SCSS</summary>

```scss
/* SCSS: hay otro fichero _base.scss */
@use 'base';
/* Aquí otras reglas SCSS */
```
</details>
<details><summary>Módulos CSS</summary>

```css
/* CSS: hay otro fichero base.css */
@import 'base.css';
/* Aquí otras reglas CSS */
```
</details>

<details><summary>Herencia SCSS</summary>

```scss
/* SCSS */
%message-common {
 border: 1px solid #ccc;
 padding: 10px;
 color: #333;
}
.mensaje {
  @extend %message-common;
}
.exito {
  @extend %message-common;
  border-color: green;
}
.error {
  @extend %message-common;
  border-color: red;
}
```
</details>
<details><summary>Herencia CSS</summary>

```css
/* CSS */
.mensaje, .exito, .error {
 border: 1px solid #ccc;
 padding: 10px;
 color: #333;
}
.exito { border-color: green; }
.error { border-color: red; }
```
</details>


<details><summary>Operaciones SCSS</summary>

```scss
/* SCSS */
$ancho-inicial: 30em;
div { width: $ancho-inicial + 2em; }
```
</details>
<details><summary>Operaciones CSS</summary>

```css
/* CSS */
html { --ancho-inicial: 30em; }
div { width: calc(var(--ancho-inicial) + 2em); }
```
</details>

Estas otras características solo son posibles gracias al **pre-procesado**:

<details><summary>Interpolación SCSS</summary>

```scss
$pantallas-peq: 36em;
@media (max-width: #{$pantallas-peq}) {
  /* reglas para pantallas pequeñas */
  p { font-size: 150%; }
}
```
</details>
<details><summary>Mixins SCSS</summary>

```scss
@mixin theme($theme: darkgray) {
  background: $theme;
  box-shadow: 0 0 1px rgba($theme, .25);
  color: #fff;
}
.info { @include theme; }
.alerta { @include theme($theme: darkred); }
.exito { @include theme($theme: darkgreen); }
```
</details>
<details><summary>Funciones SCSS</summary>

```scss
@function mas-verde($color) {
    @return $color + rgb(0,50,0);
}
p { background: mas-verde(gray); }
```
</details>
<details><summary>Directivas de control</summary>

```scss
$debug: true;
article {
    color: black;
    /* Para comprobar el diseño resaltando los bordes */
    @if ($debug) { border: 1px dotted red; }
}
```
</details>

---

<div class="codepen" data-prefill data-height="450" data-default-tab="css,result" data-theme-id="light" data-editable="true" style="opacity:0">
  <pre data-lang="html">&lt;body>
&lt;p>Este es un ejemplo de SCSS con el que puedes jugar directamente sin necesidad de compilar a CSS gracias a que la plataforma Codepen.io lo compila por ti. El mixin de ejemplo llamado "ellipsis" crea bloques de texto del ancho y número de líneas indicado. Si el contenido ocupa más que el número de líneas indicado, el texto se acorta y se muestra una elipsis ("…").&lt;/p>
&lt;/body></pre>
  <pre data-lang="scss" data-option-autoprefixer="true">@mixin ellipsis($lineas: 1, $ancho: 100%) {
  width: $ancho;
  overflow: hidden;
  text-overflow: ellipsis;
  display: -webkit-box;
  line-clamp: $lineas;
  -webkit-line-clamp: $lineas;
  -webkit-box-orient: vertical;
}

p { @include ellipsis($lineas: 2, $ancho: 20rem); }</pre></div>

[^1]: Esto implica tener un sistema de construcción del proyecto que automatice la generación de los CSS finales.