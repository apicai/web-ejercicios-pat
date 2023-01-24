# CSS
## Pseudo-clases

Hay selectores de elementos que solo aplicarán cuando el elemento se encuentre en un estado especial (por ejemplo, si el puntero del ratón está encima o si es un campo de formulario con un valor incorrecto). Esos estados se llaman [pseudo-clases](https://developer.mozilla.org/en-US/docs/Web/CSS/Pseudo-classes) y se utilizan así: `selector:pseudo-clase { ... }`.

<div class="codepen" data-prefill data-height="450" data-default-tab="css,result" data-theme-id="light" data-editable="true" style="opacity:0">
  <pre data-lang="html">
&lt;nav>
 &lt;a href="#menu1">Menú 1&lt;/a>
 &lt;a href="#menu2">Menú 2&lt;/a>
&lt;/nav>
&lt;section id="menu1">
&lt;p>Este es el contenido del Menú 1 que solo aparece cuando el ID de este elemento está seleccionado como fragmento en la URL. Para cambiar el fragmento de la URL se utilizan enlaces internos con apariencia de botón.&lt;/p>
&lt;/section>
&lt;section id="menu2">
&lt;form>
 &lt;fieldset>
  &lt;legend>Contacto&lt;/legend>
  &lt;p>
   &lt;label for="name_id">Nombre:&lt;/label>&lt;br>
   &lt;input type="text" name="name" id="name_id" required>
  &lt;/p>
  &lt;p>
   &lt;label for="email_id">Email:&lt;/label>&lt;br>
   &lt;input type="email" name="email" id="email_id">
  &lt;/p>
 &lt;/fieldset>
 &lt;fieldset>
  &lt;input type="submit" value="Enviar">
 &lt;/fieldset>
&lt;/form>
&lt;/section></pre>
  <pre data-lang="css">a:hover {
	background-color: #0069d9;
	border-color: #0062cc;
}
#menu1:target, #menu2:target {
  display: block;
}
#menu1, #menu2 {
  display: none;
  padding: 20px;
}
input:user-invalid {
  border: 2px solid red;
  box-shadow: 0 0 2px red;
  outline: red;
}
input[type="text"]:valid {
  border: 2px solid green;
  box-shadow: 0 0 2px green;
  outline: green;
}
nav {
  width: 100%;
  text-align: center;
}
a {
  font-family: sans-serif;
  color: white;
  background-color: #007bff;
  padding: 7px 12px;
  border-radius: 5px;
  text-decoration: none;
  user-select: none;
}</pre></div>

> ⁉️ **Ejercicio:** _Identifica todas las pseudo-clases, y explica su utilidad en el menú y formulario anterior._

## Pseudo-elementos

Hay otros selectores que aplican a partes específicas de un elemento HTML. Por ejemplo, la primera letra, la primera línea, antes o después del elemento, etc. Esas partes se llaman [pseudo-elementos](https://developer.mozilla.org/en-US/docs/Web/CSS/Pseudo-elements) y se utilizan así: `selector::pseudo-elemento { ... }`.

<div class="codepen" data-prefill data-height="420" data-default-tab="css,result" data-theme-id="light" data-editable="true" style="opacity:0">
  <pre data-lang="html">&lt;blockquote>Estamos dando estilo a una cita importante sobre CSS&lt;/blockquote></pre>
  <pre data-lang="css">blockquote {
  font-family: Georgia, serif;
  font-size: 19px;
  font-style: italic;
  background: #eee;
  margin: 19px;
  padding: 19px;
  border-radius: 19px;
}
blockquote::first-letter, blockquote::after {
  font-size: 29px;
  font-weight: 800;
}
blockquote::after {
  content: '❞';
}</pre></div>

> ⁉️ **Ejercicio:** _Añade estas comillas `❝` al principio de la cita utilizando solo CSS._