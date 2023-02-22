# CSS
## Diseño adaptable

### Imágenes

Las imágenes normalmente no van a tener las dimensiones exactas para que encajen en el diseño, el cual además puede tener dimensiones variables si es adaptable. Para asegurar que las imágenes grandes no desbordan o creen barras de scroll, se añade la siguiente regla CSS para todos los `img`:

<div class="codepen" data-prefill data-height="350" data-default-tab="css,result" data-theme-id="light" data-editable="true" style="opacity:0">
  <pre data-lang="html">&lt;body>
  &lt;figure>
    &lt;img alt="Imagen grande" src="https://upload.wikimedia.org/wikipedia/commons/c/cf/1_6E9A4589.jpg">
    &lt;figcaption>Imagen más grande que el contenedor&lt;/figcaption>
  &lt;/figure>
&lt;/body></pre>
  <pre data-lang="css">img {
  max-width: 100%;
  display: block;
}
figure {
  border: 10px solid green;
  width: 250px;
  text-align: center;
  font-family: sans-serif;
}</pre></div>