# CSS
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